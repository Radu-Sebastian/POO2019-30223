package view;
import controller.IController;
import model.Board;
import model.BoardSquare;
import model.GameState;
import model.LegalMovesIterator;
import model.Player;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Panel-ul cu tabla 8x8
 * @author Radu-Sebastian
 * 
 */

public class BoardPanel extends JPanel implements Observer 
{
	private static final long serialVersionUID = 1L;

    private GameState state;
    private JButton buttons[][];
    private ImageIcon blackIcon;
    private ImageIcon whiteIcon;
    
    public BoardPanel(GameState s, IController c) 
    {
        state = s;
        state.addObserver(this);
        
        buttons = new JButton[8][8];
        
        setLayout(new GridLayout(8, 8));
        
        int i, j;
        
        for (i=0; i<8; i++) 
        {
            for (j=0; j<8; j++) 
            {
                buttons[i][j] = new JButton();
                buttons[i][j].setPreferredSize(new Dimension(50, 50));
                buttons[i][j].addActionListener(new BoardButtonActionListener(c, i, j));
                add(buttons[i][j]);
            }
        }
        
        blackIcon = new ImageIcon(getClass().getResource("black.png"));
        whiteIcon = new ImageIcon(getClass().getResource("white.png"));
        
        update(null, null);
    }

    @Override
    public void update(Observable o, Object o1) 
    {
        Board b = state.getBoard();
        
        int i, j;
        
        for (i=0; i<8; i++) 
        {
            for (j=0; j<8; j++) 
            {
                Player p = b.get(i, j);
                
                buttons[i][j].setIcon(null);
                buttons[i][j].setEnabled(false);
                
                if (p != Player.NONE) 
                {
                    buttons[i][j].setEnabled(true);
                    buttons[i][j].setIcon(p == Player.BLACK ? blackIcon : whiteIcon);
                }
            }
        }

        if (state.getState() != GameState.State.WAITING) 
        {
            for (BoardSquare sq : new LegalMovesIterator(state)) 
            {
                buttons[sq.getRow()][sq.getColumn()].setEnabled(true);
            }
        }
    }
    
    private class BoardButtonActionListener implements ActionListener 
    {
        private IController controller;
        private int row;
        private int column;
        
        public BoardButtonActionListener(IController ctrl, int r, int c) 
        {
            controller = ctrl;
            row = r;
            column = c;
        }

        @Override
        public void actionPerformed(ActionEvent a) 
        {
            if (state.getBoard().get(row, column) != Player.NONE) 
            {
            	return; 
            }
            controller.move(row, column);
        }  
    }
}