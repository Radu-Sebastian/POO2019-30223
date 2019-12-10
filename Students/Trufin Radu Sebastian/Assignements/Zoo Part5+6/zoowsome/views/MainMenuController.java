package javasmmr.zoowsome.views;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import javasmmr.zoowsome.views.AddFrame;
import javasmmr.zoowsome.views.MainMenuFrame;

public class MainMenuController extends AbstractController
{
	public MainMenuController(MainMenuFrame frame, boolean hasBackButton) 
	{
		super(frame, hasBackButton);
		frame.setAddButtonActionListener(new AddButtonActionListener());
		frame.setListButtonActionListener(new ListButtonActionListener());
	}
	
	private class AddButtonActionListener implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			new AddController(new AddFrame("Add"), true);
		}
	}
	
	private class ListButtonActionListener implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			try {
				new ListController(new ListFrame("List"), true);
			} catch (ParserConfigurationException | SAXException | IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}