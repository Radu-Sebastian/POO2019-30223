package model;
import java.util.Iterator;

/**
 * Itereaza toate miscarile posibile pentru un jucator
 * @author Radu-Sebastian
 * 
 */

public class LegalMovesIterator implements Iterator<BoardSquare>, Iterable<BoardSquare> 
{
	/**
     * Starea jocului
     */
    private GameState state;
    /**
     * Iteratorul tabelei
     */
    private Iterator<BoardSquare> boardIterator;
    /**
     * Miscare corecta returnata de next()
     */
    private BoardSquare nextLegalMove;
    
    public LegalMovesIterator(GameState s) 
    {
        state = s;
        boardIterator = s.getBoard().iterator();
        findNextLegalMove();
    }
    
    /**
     * Gasirea urmatoarei miscari valide din tabela
     */
    private void findNextLegalMove() 
    {
        nextLegalMove = null;
        
        while (boardIterator.hasNext()) 
        {
            BoardSquare sq = boardIterator.next();
            
            BoardCardinalIterator it =
                    new BoardCardinalIterator(state.getBoard(), sq.getRow(), sq.getColumn());
            
            boolean ok = false;
            
            if (sq.getPlayer() != Player.NONE) 
            { 
            	continue; 
            }

            for (BoardSquare t : it) 
            {
                if (t.getRow() == sq.getRow() && t.getColumn() == sq.getColumn()) 
                {
                    ok = false;
                    continue;
                    
                } else if (t.getPlayer() == state.getOpponentPlayer()) 
                {
                    ok = true;
                    
                } else if (t.getPlayer() == state.getCurrentPlayer() && ok) 
                {
                    nextLegalMove = sq;
                    return;
                    
                } else 
                {
                    it.advanceCardinal();
                }
            }
        }
    }

    /**
     * Returneaza true daca sunt miscari valide
     */
    @Override
    public boolean hasNext() 
    {
        return nextLegalMove != null;
    }

    /**
     * Next-valid-move
     */
    @Override
    public BoardSquare next() 
    {
        BoardSquare m = nextLegalMove;
        findNextLegalMove();
        return m;
    }

    @Override
    public void remove()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * "return itself"
     */
    @Override
    public Iterator<BoardSquare> iterator() 
    {
        return this;
    }
}