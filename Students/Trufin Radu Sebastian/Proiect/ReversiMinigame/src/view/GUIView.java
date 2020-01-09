package view;

import controller.IController;
import model.GameState;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 * Crearea frame-ului / interfetei
 * @author Radu-Sebastian
 * 
 */

public class GUIView implements IView 
{
    private GameState state;
    public GUIView(GameState s) 
    {
        state = s;
    }

    @Override
    public void showMain(final IController controller) 
    {
        SwingUtilities.invokeLater(new Runnable() 
        {
            @Override
            public void run() 
            {
                MainPanel p = new MainPanel(state, controller);
                
                JFrame f = new JFrame();     
                f.add(p);
                f.setTitle("REVERSI");
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.pack();
                f.setLocationRelativeTo(null);
                f.setVisible(true);
            }
        });
    }

    @Override
    public void showCannotSave() 
    {
        JOptionPane.showMessageDialog(null, "Cannot save");
    }

    @Override
    public void showCannotLoad() 
    {
        JOptionPane.showMessageDialog(null, "Cannot load");
    }

    @Override
    public void showSelectGameType(IGameTypeSelector s) 
    {
        String[] options = new String[GameState.Type.values().length];
        options[GameState.Type.ONE_PLAYER.ordinal()] = "Yay";
        options[GameState.Type.TWO_PLAYER.ordinal()] = "Nay";
        
        int n = JOptionPane.showOptionDialog
        (
            null,
            "Start new game?",
            "Oops",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            (Object[]) options,
            null
        );
        
        if (n == -1) 
        {
            n = GameState.Type.ONE_PLAYER.ordinal();
        }
        
        s.gameTypeSelected(GameState.Type.values()[n]);
    }
    
} 	