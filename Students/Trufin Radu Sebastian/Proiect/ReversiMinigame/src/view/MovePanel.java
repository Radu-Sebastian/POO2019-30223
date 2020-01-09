package view;
import controller.IController;
import model.BoardSquare;
import model.GameState;
import model.LegalMovesIterator;
import model.Player;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Panel-ul ce afiseaza jucatorul curent si castigatorul
 * @author Radu-Sebastian
 * 
 */

public class MovePanel extends JPanel implements Observer 
{
	private static final long serialVersionUID = 1L;
    private GameState state;
    private IController controller;
    private JLabel playerLabel;
    private JButton passButton;
    private ImageIcon blackIcon;
    private ImageIcon whiteIcon;
    public MovePanel(GameState s, IController c) 
    {
        state = s;
        state.addObserver(this);
        
        controller = c;
        
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        playerLabel = new JLabel();
        add(playerLabel);
        
        add(Box.createGlue());
        
        passButton = new JButton("PASS");
        passButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent a) 
            {
                controller.pass();
            }
        });
        passButton.setEnabled(false);
        add(passButton);
        
        blackIcon = new ImageIcon(getClass().getResource("black.png"));
        whiteIcon = new ImageIcon(getClass().getResource("white.png"));
        
        update(null, null);
    }

    @Override
    public void update(Observable o, Object o1) 
    {
        playerLabel.setIcon(null);
        playerLabel.setText(null);
        passButton.setEnabled(false);
        
        switch (state.getState()) 
        {
            case ENDED:
                int blackScore = 0, whiteScore = 0;

                for (BoardSquare sq : state.getBoard())
                {
                    if (sq.getPlayer() == Player.BLACK) 
                    {
                        ++blackScore;
                    } else if (sq.getPlayer() == Player.WHITE) 
                    {
                        ++whiteScore;
                    }
                }

                playerLabel.setText("WHITE : " + blackScore +
                        " BLACK : " + whiteScore + ". " +
                        (blackScore != whiteScore
                            ? (
                                (blackScore > whiteScore && blackScore != whiteScore ? "WINNER" : " WHITE") +
                                " BLACK")
                            : ""));
            break;
            
            case INTERACTIVE:
                Player p = state.getCurrentPlayer();

                if (p != Player.NONE) 
                {
                    playerLabel.setIcon(p == Player.BLACK ? blackIcon : whiteIcon);
                }

                playerLabel.requestFocus();

                if (!new LegalMovesIterator(state).hasNext()) 
                {
                    if (new LegalMovesIterator(new GameState(state, state.getOpponentPlayer())).hasNext()) 
                    {
                        passButton.setEnabled(true);

                    } else 
                    {
                        controller.endGame();
                    }
                }
            break;
		default:
			break;
        }
    }
}