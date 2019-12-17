package dragball;
import javax.swing.*;

public class DragDemo
{
	public static void main(String[] args) 
	{
		JFrame window = new JFrame();
		window.setTitle("Drag Demo");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setContentPane(new DragBallPanel());
		window.setLocationRelativeTo(null);
		window.show();
		window.pack();
	}
}