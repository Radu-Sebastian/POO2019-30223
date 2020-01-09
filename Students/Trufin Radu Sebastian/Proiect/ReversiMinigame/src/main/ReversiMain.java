package main;
import controller.Controller;
import controller.IController;
import model.GameState;
import view.GUIView;
import view.IView;

/**
 * Programul principal MVC
 * @author Radu-Sebastian
 * 
 */

public class ReversiMain 
{
	public static void main(String[] args) 
    {
        GameState s = new GameState();
        IView v = new GUIView(s);
        IController c = new Controller(s,v);
        v.showMain(c);
    }
}
