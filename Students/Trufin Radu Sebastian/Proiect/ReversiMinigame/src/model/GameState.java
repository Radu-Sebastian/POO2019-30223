package model;
import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

/**
 * Starea jocului
 * @author Radu-Sebastian
 * 
 */

public class GameState extends Observable implements Serializable, Observer
{
	private static final long serialVersionUID = 1L;
	/**
     * Jucatorul curent
     */
	private Player currentPlayer;
	/**
     * Tabela curenta
     */
    private Board board;
    /**
     * Starile posibile
     * INTERACTIVE - asteapta user input
     * ENDED - s-a terminat jocul
     * WAITING - asteapta computer input
     */
    public enum State 
    {
        INTERACTIVE,
        ENDED, 
        WAITING 
    }
    
    private State state;
    public enum Type 
    {
        ONE_PLAYER, 
        TWO_PLAYER 
    }

    private Type type;
    /**
     * Adevarat daca begin() s-a apelat
     */
    private boolean begun; 
    
    /**
     * Crearea unei noi stari a jocului
     */
    public GameState() 
    {
        board = new Board();
        board.addObserver(this);
        begun = false;
        reset();
    }
    
    /**
     * Crearea unei noi stari dupa o alta stare
     */
    public GameState(GameState s) 
    {
        board = new Board();
        board.addObserver(this);
        begun = false;
        reset(s);
    }
    
    public GameState(Type t) 
    {
        board = new Board();
        board.addObserver(this);
        begun = false;
        reset();
        type = t;
    }
    
    public GameState(GameState s, Player newCurrentPlayer) 
    {
        this(s);
        currentPlayer = newCurrentPlayer;
    }

    /**
     * Metoda board.reset() va notifica toti observerii
     */
    public void reset() 
    {
        currentPlayer = Player.BLACK;
        state = State.INTERACTIVE;
        type = Type.TWO_PLAYER;
        board.reset(); 
    }
    
    /**
     * Reseteaza la o stare specifica
     */
    public void reset(GameState s) 
    {
        currentPlayer = s.currentPlayer;
        state = s.state;
        type = s.type;
        board.reset(s.board);
    }
    
    /**
     * Returneaza tabela
     */
    public Board getBoard() 
    {
        return board;
    }
    
    /**
     * Returneaza jucatorul curent
     */
    public Player getCurrentPlayer() 
    {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player p) 
    {
        if (p == currentPlayer) { return; }
        
        currentPlayer = p;
        setChanged();
        
        if (!begun) 
        {
            notifyObservers();
        }
    }
    
    /**
     * Returneaza oponentul curent
     */
    public Player getOpponentPlayer() 
    {
        if (currentPlayer == Player.NONE) 
        {
            return Player.NONE;
        }
        
        return currentPlayer == Player.BLACK ? Player.WHITE : Player.BLACK;
    }

    /**
     * "Listen" pentru update-uri
     */
    @Override
    public void update(Observable o, Object o1) 
    {
        setChanged();
        
        if (!begun) 
        {
            notifyObservers();
        }
    }

    public void begin() 
    {
        begun = true;
    }
    
    public void end() 
    {
        begun = false;
        notifyObservers();
    }
    
    public State getState() 
    {
        return state;
    }
    
    public void setState(State s) 
    {
        if (s != state) 
        {
            setChanged();
        }
        
        state = s;
        
        if (!begun) 
        {
            notifyObservers();
        }
    }
    
    public Type getType() 
    {
        return type;
    }
    
    public void setType(Type t) 
    {
        if (t != type) 
        {
            setChanged();
        }
        
        type = t;
        
        if (!begun) 
        {
            notifyObservers();
        }
    }
}