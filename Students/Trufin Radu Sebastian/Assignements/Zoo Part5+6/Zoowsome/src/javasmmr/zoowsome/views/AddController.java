package javasmmr.zoowsome.views;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddController extends AbstractController 
{
	public AddController(AddFrame addFrame, boolean hasBackButton) 
	{
		super(addFrame, hasBackButton);
		addFrame.setAddAnimalActionListener(new AddAnimalActionListener());
	}
	
	private class AddAnimalActionListener implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			new AnimalController(new AnimalFrame("Add Animals"), true);
		}
	}
}