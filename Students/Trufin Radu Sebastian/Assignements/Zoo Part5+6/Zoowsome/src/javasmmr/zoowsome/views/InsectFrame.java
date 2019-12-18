package javasmmr.zoowsome.views;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

import javasmmr.zoowsome.models.Animal;
import javasmmr.zoowsome.models.Butterfly;
import javasmmr.zoowsome.models.Cockroach;
import javasmmr.zoowsome.models.Spider;
import javasmmr.zoowsome.services.AnimalFactory;
import javasmmr.zoowsome.services.Constants;
import javasmmr.zoowsome.services.SpeciesFactory;

public class InsectFrame extends ZooFrame 
{
	AnimalFactory abstractFactory = new AnimalFactory();
	ArrayList<Animal> myList = new ArrayList<Animal>();
	JLabel outputText = new JLabel();
	
	private static final long serialVersionUID = 1L;
	JPanel gridPanel =  new JPanel(new GridLayout(4, 1));
	JPanel newPanel = new JPanel(new SpringLayout());
	Icon cockroachIcon = new ImageIcon("./resources/cockroach.png");
	JButton cockroachButton = new JButton("Cockroach",cockroachIcon);
	Icon spiderIcon = new ImageIcon("./resources/spider.png");
	JButton spiderButton = new JButton("Spider",spiderIcon);
	Icon butterflyIcon = new ImageIcon("./resources/butterfly.png");
	JButton butterflyButton = new JButton("Butterfly",butterflyIcon);
	
	public InsectFrame(String title)
	{
		super(title);
   
		gridPanel.add(cockroachButton);
		gridPanel.add(spiderButton);
		gridPanel.add(butterflyButton);
		newPanel.add(outputText);
		newPanel.setBackground(new Color(230,230,250));
		gridPanel.add(newPanel);
		
		cockroachButton.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 20));
		cockroachButton.setBackground(new Color(230,230,250));
		cockroachButton.addActionListener(new addCockroach());
		
		spiderButton.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 20));
		spiderButton.setBackground(new Color(230,230,250));
		spiderButton.addActionListener(new addSpider());
		
		butterflyButton.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 20));
		butterflyButton.setBackground(new Color(230,230,250));  
		butterflyButton.addActionListener(new addButterfly());
		
	    contentPanel.add(gridPanel);
	}
	
	private class addCockroach implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			try 
			{
				SpeciesFactory speciesFactoryInsects = abstractFactory.getSpeciesFactory(Constants.Species.Insects);
				Cockroach myCockroach = (Cockroach) speciesFactoryInsects.getAnimal(Constants.Animals.Insects.Cockroach);
				myList = ListFrame.getAnimalRepository().load();
				myList.add(myCockroach);
				outputText.setBorder(new EmptyBorder(10, 10, 10, 10));
				outputText.setFont(new Font("Century Gothic", Font.CENTER_BASELINE, 15));
				outputText.setText("Added new cockroach " + myCockroach.getName());
				newPanel.add(outputText);
				ListFrame.getAnimalRepository().save(myList);
			} catch (Exception e1)
			{
				e1.printStackTrace();
			}
		}
	}
	
	private class addSpider implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			try 
			{
				SpeciesFactory speciesFactoryInsects = abstractFactory.getSpeciesFactory(Constants.Species.Insects);
				Spider mySpider = (Spider) speciesFactoryInsects.getAnimal(Constants.Animals.Insects.Spider);
				myList = ListFrame.getAnimalRepository().load();
				myList.add(mySpider);
				outputText.setBorder(new EmptyBorder(10, 10, 10, 10));
				outputText.setFont(new Font("Century Gothic", Font.CENTER_BASELINE, 15));
				outputText.setText("Added new spider " + mySpider.getName());
				newPanel.add(outputText);
				ListFrame.getAnimalRepository().save(myList);
			} catch (Exception e1)
			{
				e1.printStackTrace();
			}
		}
	}
	
	private class addButterfly implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			try 
			{
				SpeciesFactory speciesFactoryInsects = abstractFactory.getSpeciesFactory(Constants.Species.Insects);
				Butterfly myButterfly= (Butterfly) speciesFactoryInsects.getAnimal(Constants.Animals.Insects.Butterfly);
				myList = ListFrame.getAnimalRepository().load();
				myList.add(myButterfly);
				outputText.setBorder(new EmptyBorder(10, 10, 10, 10));
				outputText.setFont(new Font("Century Gothic", Font.CENTER_BASELINE, 15));
				outputText.setText("Added new butterfly " + myButterfly.getName());
				newPanel.add(outputText);
				ListFrame.getAnimalRepository().save(myList);
			} catch (Exception e1)
			{
				e1.printStackTrace();
			}
		}
	}
}