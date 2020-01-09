package controller;

import model.BoardCardinalIterator;
import model.BoardSquare;
import model.GameState;
import model.GameState.Type;
import model.LegalMovesIterator;
import view.IView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Controlerul jocului
 * @author Radu-Sebastian
 * 
 */

public class Controller implements IController 
{
	/**
     * Fisierul in care se salveaza jocul
     */
    private static final String SAVE_FILE = ".reversi.sav";
    /**
     * Starea jocului
     */
    private GameState state;
    /**
     * Vederea jocului
     */
    private IView view;
    
    /**
     * Crearea unui nou controlor
     */
    public Controller(GameState s, IView v) 
    {
        state = s;
        view = v;
    }

    /**
     * Realizeaza tura unui jucator
     * @param row linie
     * @param column coloana
     */
    @Override
    public void move(int row, int column) 
    {
        state.begin();
        placeStone(row, column);
        state.setCurrentPlayer(state.getOpponentPlayer());
        
        if (state.getType() == GameState.Type.TWO_PLAYER) 
        {
            state.setState(GameState.State.INTERACTIVE);
            state.end();
            
        } else if (state.getType() == GameState.Type.ONE_PLAYER) 
        {
            play();
            
        } else 
        {
            throw new RuntimeException("Game type " + state.getType() + " not implemented.");
        }
    }

    /**
     * Schimbarea culorii celulelor 
     * @param row linie
     * @param column coloana
     */
    private void placeStone(int row, int column) 
    {
        Set<BoardSquare> sqs = new HashSet<BoardSquare>();
        BoardCardinalIterator it = new BoardCardinalIterator(state.getBoard(), row, column);
        
        state.getBoard().set(row, column, state.getCurrentPlayer());
        
        for (BoardSquare sq : it) 
        {
            if (sq.getRow() == row && sq.getColumn() == column) 
            {
                sqs.clear();
                
            } else if (sq.getPlayer() == state.getOpponentPlayer()) 
            {
                sqs.add(sq);
                
            } else if (sq.getPlayer() == state.getCurrentPlayer()) 
            {
                for (BoardSquare t : sqs) 
                {
                    state.getBoard().set(t.getRow(), t.getColumn(), state.getCurrentPlayer());
                }
                
                it.advanceCardinal();
                
            } else 
            {   
                it.advanceCardinal();
            }
        }
    }
    
    /**
     * Miscarea computerului
     */
    private void play() 
    {
        state.setState(GameState.State.WAITING);

        new Timer().schedule(new TimerTask() 
        {
            @SuppressWarnings("rawtypes")
			@Override
            public void run() 
            {
                @SuppressWarnings("unchecked")
				List<BoardSquare> legalMoves = new LinkedList();

                for (BoardSquare sq : new LegalMovesIterator(state)) 
                {
                    legalMoves.add(sq);
                }

                if (legalMoves.size() > 0) 
                {
                    BoardSquare max = legalMoves.get(0);
                    placeStone(max.getRow(), max.getColumn());
                }

                state.setCurrentPlayer(state.getOpponentPlayer());
                state.setState(GameState.State.INTERACTIVE);

                state.end();
            }
        }, 500);
    }
    
    /**
     * Saltul turei -> oponent
     */
    @Override
    public void pass() 
    {
        state.begin();
        
        state.setCurrentPlayer(state.getOpponentPlayer());
        
        if (state.getType() == GameState.Type.ONE_PLAYER) 
        {
            play();   
        } else 
        {
            state.end();
        }
    }


    /**
     * Incepe joc nou
     */
    @Override
    public void newGame() 
    {
        view.showSelectGameType(new IView.IGameTypeSelector() 
        {
            @Override
            public void gameTypeSelected(Type t) 
            {
                state.reset(new GameState(t));
            }
        });
    }

    /**
     * Incarca joc salvat
     */
    @Override
    public void loadGame() 
    {
        try 
        {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(getSaveFile()));
            
            state.reset((GameState) in.readObject());
            
            in.close();
            
        } catch (Exception ex) 
        {
            view.showCannotLoad();
        }
    }

    /**
     * Salveaza jocul curent
     */
    @Override
    public void saveGame() 
    {
        try 
        {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(getSaveFile()));
            
            out.writeObject(state);
            
            out.close();
            
        } catch (Exception ex) 
        {
            view.showCannotSave();
        }
    }

    /**
     * Parasirea aplicatiei
     */
    @Override
    public void quitGame() 
    {
        System.exit(0);
    }

    /**
     * Terminarea jocului
     */
    @Override
    public void endGame() 
    {
        state.setState(GameState.State.ENDED);
    }

    /**
     * Returneaza true daca jocul e incarcabil
     */
    @Override
    public boolean isGameLoadable() 
    {
        return getSaveFile().exists();
    }
    
    /**
     * Returneaza fisierul salvat
     */
    private File getSaveFile() 
    {
        return new File(System.getProperty("user.home") + File.separator + SAVE_FILE);
    }
}