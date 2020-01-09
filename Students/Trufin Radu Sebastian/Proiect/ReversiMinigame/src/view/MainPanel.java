package view;
import controller.IController;

import model.GameState;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 * Panel-ul principal ce contine tabla si meniul
 * @author Radu-Sebastian
 * 
 */

public class MainPanel extends JPanel 
{
	private static final long serialVersionUID = 1L;

    public MainPanel(GameState s, IController c) 
    {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        add(new MenuPanel(s, c));
        add(new BoardPanel(s, c));
        add(new MovePanel(s, c));
    }
}