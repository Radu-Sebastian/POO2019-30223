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
import javasmmr.zoowsome.models.Colibri;
import javasmmr.zoowsome.models.Kiwi;
import javasmmr.zoowsome.models.Penguin;
import javasmmr.zoowsome.services.AnimalFactory;
import javasmmr.zoowsome.services.Constants;
import javasmmr.zoowsome.services.SpeciesFactory;

public class BirdFrame extends ZooFrame 
{
	AnimalFactory abstractFactory = new AnimalFactory();
	ArrayList<Animal> myList = new ArrayList<Animal>();
	JLabel outputText = new JLabel();
	private static final long serialVersionUID = 1L;
	JPanel gridPanel =  new JPanel(new GridLayout(4, 1));
	JPanel newPanel = new JPanel(new SpringLayout());
	Icon kiwiIcon = new ImageIcon(this.getClass().getResource("kiwi.png"));
	JButton kiwiButton = new JButton("Kiwi",kiwiIcon);
	Icon colibriIcon = new ImageIcon(this.getClass().getResource("colibri.png"));
	JButton colibriButton = new JButton("Colibri",colibriIcon);
	Icon penguinIcon = new ImageIcon(this.getClass().getResource("penguin.png"));
	JButton penguinButton = new JButton("Penguin",penguinIcon);
	
	public BirdFrame(String title)
	{
		super(title);
   
		gridPanel.add(kiwiButton);
		gridPanel.add(colibriButton);
		gridPanel.add(penguinButton);
		newPanel.add(outputText);
		newPanel.setBackground(new Color(230,230,250));
		gridPanel.add(newPanel);
		
		kiwiButton.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 20));
		kiwiButton.setBackground(new Color(230,230,250));
		kiwiButton.addActionListener(new addKiwi());
		
		colibriButton.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 20));
		colibriButton.setBackground(new Color(230,230,250));
		colibriButton.addActionListener(new addColibri());
		
		penguinButton.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 20));
		penguinButton.setBackground(new Color(230,230,250));  
		penguinButton.addActionListener(new addPenguin());
		
	    contentPanel.add(gridPanel);
	}
	
	private class addKiwi implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			try 
			{
				SpeciesFactory speciesFactoryBirds = abstractFactory.getSpeciesFactory(Constants.Species.Birds);
				Kiwi myKiwi = (Kiwi) speciesFactoryBirds.getAnimal(Constants.Animals.Birds.Kiwi);
				myList = ListFrame.getAnimalRepository().load();
				myList.add(myKiwi);
				outputText.setBorder(new EmptyBorder(10, 10, 10, 10));
				outputText.setFont(new Font("Century Gothic", Font.CENTER_BASELINE, 15));
				outputText.setText("Added new kiwi " + myKiwi.getName());
				newPanel.add(outputText);
				ListFrame.getAnimalRepository().save(myList);
			} catch (Exception e1)
			{
				e1.printStackTrace();
			}
		}
	}
	
	private class addColibri implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			try 
			{
				SpeciesFactory speciesFactoryBirds = abstractFactory.getSpeciesFactory(Constants.Species.Birds);
				Colibri myColibri = (Colibri) speciesFactoryBirds.getAnimal(Constants.Animals.Birds.Colibri);
				myList = ListFrame.getAnimalRepository().load();
				myList.add(myColibri);
				outputText.setBorder(new EmptyBorder(10, 10, 10, 10));
				outputText.setFont(new Font("Century Gothic", Font.CENTER_BASELINE, 15));
				outputText.setText("Added new colibri " + myColibri.getName());
				newPanel.add(outputText);
				ListFrame.getAnimalRepository().save(myList);
			} catch (Exception e1)
			{
				e1.printStackTrace();
			}
		}
	}
	
	private class addPenguin implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			try 
			{
				SpeciesFactory speciesFactoryBirds = abstractFactory.getSpeciesFactory(Constants.Species.Birds);
				Penguin myPenguin = (Penguin) speciesFactoryBirds.getAnimal(Constants.Animals.Birds.Penguin);
				myList = ListFrame.getAnimalRepository().load();
				myList.add(myPenguin);
				outputText.setBorder(new EmptyBorder(10, 10, 10, 10));
				outputText.setFont(new Font("Century Gothic", Font.CENTER_BASELINE, 15));
				outputText.setText("Added new penguin " + myPenguin.getName());
				newPanel.add(outputText);
				ListFrame.getAnimalRepository().save(myList);
			} catch (Exception e1)
			{
				e1.printStackTrace();
			}
		}
	}
}