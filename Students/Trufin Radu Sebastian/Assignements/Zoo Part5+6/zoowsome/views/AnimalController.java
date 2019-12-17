package javasmmr.zoowsome.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimalController extends AbstractController 
{
	public AnimalController(AnimalFrame animalFrame, boolean hasBackButton) 
	{
		super(animalFrame, hasBackButton);
		animalFrame.setAddMammalActionListener(new AddMammalActionListener());
		animalFrame.setAddAquaticActionListener(new AddAquaticActionListener());
		animalFrame.setAddReptileActionListener(new AddReptileActionListener());
		animalFrame.setAddInsectActionListener(new AddInsectActionListener());
		animalFrame.setAddBirdActionListener(new AddBirdActionListener());
	}
	
	private class AddMammalActionListener implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			new MammalController(new MammalFrame("Add Mammals"), true);
		}
	}
	
	private class AddInsectActionListener implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			new InsectController(new InsectFrame("Add Insects"), true);
		}
	}
	
	private class AddBirdActionListener implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			new BirdController(new BirdFrame("Add Birds"), true);
		}
	}
	
	private class AddReptileActionListener implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			new ReptileController(new ReptileFrame("Add Reptiles"), true);
		}
	}
	
	private class AddAquaticActionListener implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			new AquaticController(new AquaticFrame("Add Aquatics"), true);
		}
	}
}