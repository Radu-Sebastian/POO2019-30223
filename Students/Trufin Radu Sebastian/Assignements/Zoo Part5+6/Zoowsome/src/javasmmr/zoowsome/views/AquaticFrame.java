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
import javasmmr.zoowsome.models.Clownfish;
import javasmmr.zoowsome.models.Salamander;
import javasmmr.zoowsome.models.Seahorse;
import javasmmr.zoowsome.services.AnimalFactory;
import javasmmr.zoowsome.services.Constants;
import javasmmr.zoowsome.services.SpeciesFactory;

public class AquaticFrame extends ZooFrame 
{
	AnimalFactory abstractFactory = new AnimalFactory();
	ArrayList<Animal> myList = new ArrayList<Animal>();
	JLabel outputText = new JLabel();
	private static final long serialVersionUID = 1L;
	JPanel gridPanel =  new JPanel(new GridLayout(4, 1));
	JPanel newPanel = new JPanel(new SpringLayout());
	Icon salamanderIcon = new ImageIcon("./resources/lizard.png");
	JButton salamanderButton = new JButton("Salamander",salamanderIcon);
	Icon clownfishIcon = new ImageIcon("./resources/clownfish.png");
	JButton clownfishButton = new JButton("Clownfish",clownfishIcon);
	Icon seahorseIcon = new ImageIcon("./resources/seahorse.png");
	JButton seahorseButton = new JButton("Seahorse",seahorseIcon);
	
	public AquaticFrame(String title)
	{
		super(title);
   
		gridPanel.add(salamanderButton);
		gridPanel.add(clownfishButton);
		gridPanel.add(seahorseButton);
		newPanel.add(outputText);
		newPanel.setBackground(new Color(230,230,250));
		gridPanel.add(newPanel);
		
		salamanderButton.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 20));
		salamanderButton.setBackground(new Color(230,230,250));
		salamanderButton.addActionListener(new addSalamander());
		
		clownfishButton.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 20));
		clownfishButton.setBackground(new Color(230,230,250));
		clownfishButton.addActionListener(new addClownfish());
		
		seahorseButton.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 20));
		seahorseButton.setBackground(new Color(230,230,250));  
		seahorseButton.addActionListener(new addSeahorse());
		
	    contentPanel.add(gridPanel);
	}
	
	private class addClownfish implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			try 
			{
				SpeciesFactory speciesFactoryAquatics = abstractFactory.getSpeciesFactory(Constants.Species.Aquatics);
				Clownfish myClownfish = (Clownfish) speciesFactoryAquatics.getAnimal(Constants.Animals.Aquatics.Clownfish);
				myList = ListFrame.getAnimalRepository().load();
				myList.add(myClownfish);
				outputText.setBorder(new EmptyBorder(10, 10, 10, 10));
				outputText.setFont(new Font("Century Gothic", Font.CENTER_BASELINE, 15));
				outputText.setText("Added new clownfish " + myClownfish.getName());
				newPanel.add(outputText);
				ListFrame.getAnimalRepository().save(myList);
			} catch (Exception e1)
			{
				e1.printStackTrace();
			}
		}
	}
	
	private class addSeahorse implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			try 
			{
				SpeciesFactory speciesFactoryAquatics = abstractFactory.getSpeciesFactory(Constants.Species.Aquatics);
				Seahorse mySeahorse = (Seahorse) speciesFactoryAquatics.getAnimal(Constants.Animals.Aquatics.Seahorse);
				myList = ListFrame.getAnimalRepository().load();
				myList.add(mySeahorse);
				outputText.setBorder(new EmptyBorder(10, 10, 10, 10));
				outputText.setFont(new Font("Century Gothic", Font.CENTER_BASELINE, 15));
				outputText.setText("Added new seahorse " + mySeahorse.getName());
				newPanel.add(outputText);
				ListFrame.getAnimalRepository().save(myList);
			} catch (Exception e1)
			{
				e1.printStackTrace();
			}
		}
	}
	
	private class addSalamander implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			try 
			{
				SpeciesFactory speciesFactoryAquatics = abstractFactory.getSpeciesFactory(Constants.Species.Aquatics);
				Salamander mySalamander = (Salamander) speciesFactoryAquatics.getAnimal(Constants.Animals.Aquatics.Salamander);
				myList = ListFrame.getAnimalRepository().load();
				myList.add(mySalamander);
				outputText.setBorder(new EmptyBorder(10, 10, 10, 10));
				outputText.setFont(new Font("Century Gothic", Font.CENTER_BASELINE, 15));
				outputText.setText("Added new salamander " + mySalamander.getName());
				newPanel.add(outputText);
				ListFrame.getAnimalRepository().save(myList);
			} catch (Exception e1)
			{
				e1.printStackTrace();
			}
		}
	}
}