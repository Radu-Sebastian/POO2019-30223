package model;

/**
 * O celula din tabel
 * @author Radu-Sebastian
 * 
 */

public class BoardSquare 
{
	/**
     * Linie
     */
    private int row;
    /**
     * Coloana
     */
    private int column;
    /**
     * Jucator curent
     */
    private Player player;
    
    /**
     * Crearea unui nou patrat gol
     */
    public BoardSquare(int r, int c) 
    {
        this(r, c, Player.NONE);
    }

    /**
     * Crearea unui nou patrat
     */
    public BoardSquare(int r, int c, Player p) 
    {
        row = r;
        column = c;
        player = p;
    }

    /**
     * Crearea unei copii 
     */
    public BoardSquare(BoardSquare c) 
    {
        row = c.row;
        column = c.column;
        player = c.player;
    }

    /**
     * Returneaza linia celulei
     */
    public int getRow() 
    {
        return row;
    }

    /**
     * Returneaza coloana celulei
     */
    public int getColumn() 
    {
        return column;
    }
    
    /**
     * Returneaza culoarea/jucatorul celulei
     */
    public Player getPlayer() 
    {
        return player;
    }
}