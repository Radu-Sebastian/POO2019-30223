package view;
import controller.IController;
import model.GameState;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Panel-ul ce afiseaza meniul cu optiunile sale
 * @author Radu-Sebastian
 * 
 */

public class MenuPanel extends JPanel implements ActionListener 
{
	private static final long serialVersionUID = 1L;
    private IController controller;
    private JButton newGameButton;
    private JButton loadGameButton;
    private JButton saveGameButton;
    private JButton quitGameButton;

    public MenuPanel(GameState s, IController c) 
    {
        controller = c;
        
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        newGameButton = new JButton("New Game");
        newGameButton.addActionListener(this);
        add(newGameButton);
        
        loadGameButton = new JButton("Load");
        loadGameButton.addActionListener(this);
        loadGameButton.setEnabled(controller.isGameLoadable());
        add(loadGameButton);
        
        saveGameButton = new JButton("Save");
        saveGameButton.addActionListener(this);
        add(saveGameButton);
        
        quitGameButton = new JButton("Quit");
        quitGameButton.addActionListener(this);
        add(quitGameButton);
    }

    @Override
    public void actionPerformed(ActionEvent a) 
    {
        JButton b = (JButton) a.getSource();
        
        if (b == newGameButton) 
        {
            controller.newGame();
            
        } else if (b == loadGameButton) 
        {
            controller.loadGame();
            
        } else if (b == saveGameButton) 
        {
            controller.saveGame();
            loadGameButton.setEnabled(true);
            
        } else if (b == quitGameButton) 
        {
            controller.quitGame();
        }
    }
}