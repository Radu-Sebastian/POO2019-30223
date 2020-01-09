package model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Observable;

/**
 * Tabla jocului
 * @author Radu-Sebastian
 * 
 */

public class Board extends Observable implements Serializable, Iterable<BoardSquare> 
{
	private static final long serialVersionUID = 1L;
    /**
     * Matricea de (alb,negru,nul)
     */
    private Player data[][]; 
    /**
     * true daca begin() s-a apelat
     */
    private boolean begun; 

    /**
     * Crearea unei table
     */
    public Board() 
    {
        data = new Player[8][8];
        begun = false;
        reset();
    }

    /**
     * Creaza o tabla dupa o tabla data
     */
    public Board(Board b) 
    {
        data = new Player[8][8];
        begun = false;
        reset(b);
    }
   
    /**
     * Reseteaza tabla intr-o noua stare
     */
    public void reset() 
    {
        int i, j;
        
        for (i=0; i<8; i++) 
        {
            for (j=0; j<8; j++) 
            {
                data[i][j] = Player.NONE;
            }
        }
        
        data[3][4] = data[4][3] = Player.BLACK;
        data[3][3] = data[4][4] = Player.WHITE;
        
        setChanged();
        notifyObservers();
    }
    
    /**
     * Reseteaza tabla intr-o stare data
     */
    public void reset(Board b) 
    {
        int i, j;
        
        for (i=0; i<8; i++) 
        {
            for (j=0; j<8; j++) 
            {
                data[i][j] = b.data[i][j];
            }
        }
        
        setChanged();
        notifyObservers();
    }
    
    /**
     * Returneaza informatia pe o celula specifica
     */
    public Player get(int row, int column)
    {
        return data[row][column];
    }
   
    /**
     * Seteaza o noua valoare pe o celula data
     * Daca valoarea se schimba, toti observerii vor fi notificati
     */

    public void set(int row, int column, Player newValue) 
    {
        Player oldValue = data[row][column];
        data[row][column] = newValue;
        
        if (newValue != oldValue) 
        {
            setChanged();
        }
        
        if (!begun) 
        {
            notifyObservers();
        }
    }
    
    /**
     * Nu mai notifica observerii
     */
    public void begin() 
    {
        begun = true;
    }
    
    /**
     * Daca se modifica niste valori
     * Observerii vor fi notificati
     */
    public void end() 
    {
        begun = false;
        notifyObservers();
    }

    /**
     * Returneaza iteratorul tabelei
     */
    @Override
    public Iterator<BoardSquare> iterator() 
    {
        return new Iterator<BoardSquare>() 
        {
            private int r = 0, c = 0;

            @Override
            public boolean hasNext() 
            {
                return r < 8 && c < 8;
            }

            @Override
            public BoardSquare next() 
            {
                BoardSquare sq = new BoardSquare(r, c, data[r][c]);
                c++;
                
                if(c > 7) 
                {
                    r++;
                    c = 0;
                }
                
                return sq;
            }

            @Override
            public void remove() 
            {
                throw new UnsupportedOperationException("Not supported yet.");
            }
            
        };
    }
}