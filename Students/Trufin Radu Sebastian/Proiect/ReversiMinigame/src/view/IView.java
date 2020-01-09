package view;
import controller.IController;
import model.GameState.Type;

/**
 * Interfata pentru view
 * @author Radu-Sebastian
 * 
 */

public interface IView 
{
    public void showMain(IController controller);

    public void showCannotSave();

    public void showCannotLoad();

    public void showSelectGameType(IGameTypeSelector s);
    
    public interface IGameTypeSelector 
    {
        public void gameTypeSelected(Type t);
    }
    
}