package controller;

/**
 * Interfata controlerului jocului
 * @author Radu-Sebastian
 * 
 */

public interface IController 
{
    public void loadGame();

    public void newGame();

    public void pass();

    public void move(int row, int column);

    public void quitGame();

    public void saveGame();

    public void endGame();

    public boolean isGameLoadable();
    
}