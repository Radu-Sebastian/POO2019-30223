package model;
import java.util.Iterator;

/**
 * Itereaza prin tabela in toate directiile cardinale
 * @author Radu-Sebastian
 * 
 */

public class BoardCardinalIterator implements Iterator<BoardSquare>, Iterable<BoardSquare> 
{
    private Board board;
    private int startRow;
    private int startColumn;
    private int currentRow;
    private int currentColumn;
    private int currentCardinal;
    private boolean justAdvanced; 
    /**
     * Directiile cardinale 
     */
    private static final int cardinals[][] = 
    {
        { -1, 0 }, // north
        { -1, 1 }, // north-east
        { 0, 1 }, // east
        { 1, 1 }, // south-east
        { 1, 0 }, // south
        { 1, -1 }, // south-west
        { 0, -1 }, // west
        { -1, -1 } // north-west
    };
    
    /**
     * Crearea unui nou iterator
     */
    public BoardCardinalIterator(Board b, int r, int c) 
    {
        board = b;
        startRow = currentRow = r;
        startColumn = currentColumn = c;
        currentCardinal = 0;
    }
    
    
    public BoardCardinalIterator(Board b, BoardSquare s) 
    {
        this(b, s.getRow(), s.getColumn());
    }

    /**
     * Adevarat daca exista un element urmator
     */
    @Override
    public boolean hasNext() 
    {
        return currentRow >= 0 && currentRow < 8 &&
                currentColumn >= 0 && currentColumn < 8 &&
                currentCardinal < cardinals.length;
    }

    /**
     * Returneaza urmatorul element
     */
    @Override
    public BoardSquare next() 
    {
        BoardSquare ret = new BoardSquare(currentRow, currentColumn, board.get(currentRow, currentColumn));
        
        currentRow += cardinals[currentCardinal][0];
        currentColumn += cardinals[currentCardinal][1];
        
        justAdvanced = false;
        
        if (currentRow < 0 || currentRow > 7 || currentColumn < 0 || currentColumn > 7) 
        {
            currentRow = startRow;
            currentColumn = startColumn;
            ++currentCardinal;
            justAdvanced = true;
        }
        
        return ret;
    }

    
    @Override
    public void remove() 
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Iterator<BoardSquare> iterator() 
    {
        return this;
    }
    
    /**
     * Avansare pe urmatoarea directie
     */
    public void advanceCardinal() 
    {
        if (!justAdvanced) 
        {
            currentRow = startRow;
            currentColumn = startColumn;
            ++currentCardinal;
        }
    }
}