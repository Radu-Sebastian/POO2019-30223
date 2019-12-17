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
import javasmmr.zoowsome.models.Cow;
import javasmmr.zoowsome.models.Monkey;
import javasmmr.zoowsome.models.Tiger;
import javasmmr.zoowsome.services.AnimalFactory;
import javasmmr.zoowsome.services.Constants;
import javasmmr.zoowsome.services.SpeciesFactory;

public class MammalFrame extends ZooFrame 
{
	AnimalFactory abstractFactory = new AnimalFactory();
	ArrayList<Animal> myList = new ArrayList<Animal>();
	JLabel outputText = new JLabel();
	
	private static final long serialVersionUID = 1L;
	JPanel gridPanel  = new JPanel(new GridLayout(4, 1));
	JPanel newPanel = new JPanel(new SpringLayout());
	Icon monkeyIcon = new ImageIcon(this.getClass().getResource("monkey.png"));
	JButton monkeyButton = new JButton("Monkey",monkeyIcon);
	Icon tigerIcon = new ImageIcon(this.getClass().getResource("tiger.png"));
	JButton tigerButton = new JButton("Tiger",tigerIcon);
	Icon cowIcon = new ImageIcon(this.getClass().getResource("cow.png"));
	JButton cowButton = new JButton("Cow",cowIcon);
	
	public MammalFrame(String title)
	{
		super(title);
   
		gridPanel.add(monkeyButton);
		gridPanel.add(tigerButton);
		gridPanel.add(cowButton);
		newPanel.add(outputText);
		gridPanel.add(newPanel);
		newPanel.setBackground(new Color(230,230,250));
		
		monkeyButton.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 20));
		monkeyButton.setBackground(new Color(230,230,250));
		monkeyButton.addActionListener(new addMonkey());
		
		tigerButton.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 20));
		tigerButton.setBackground(new Color(230,230,250));
		tigerButton.addActionListener(new addTiger());
		
		cowButton.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 20));
		cowButton.setBackground(new Color(230,230,250));  
		cowButton.addActionListener(new addCow());
		
	    contentPanel.add(gridPanel);
	}
	
	private class addMonkey implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			try 
			{
				SpeciesFactory speciesFactoryMammals = abstractFactory.getSpeciesFactory(Constants.Species.Mammals);
				Monkey myMonkey = (Monkey) speciesFactoryMammals.getAnimal(Constants.Animals.Mammals.Monkey);
				myList = ListFrame.getAnimalRepository().load();
				myList.add(myMonkey);
				outputText.setBorder(new EmptyBorder(10, 10, 10, 10));
				outputText.setFont(new Font("Century Gothic", Font.CENTER_BASELINE, 15));
				outputText.setText("Added new monkey " + myMonkey.getName());
				newPanel.add(outputText);
				ListFrame.getAnimalRepository().save(myList);
			} catch (Exception e1)
			{
				e1.printStackTrace();
			}
		}
	}
	
	private class addCow implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			try 
			{
				SpeciesFactory speciesFactoryMammals = abstractFactory.getSpeciesFactory(Constants.Species.Mammals);
				Cow myCow = (Cow) speciesFactoryMammals.getAnimal(Constants.Animals.Mammals.Cow);
				myList = ListFrame.getAnimalRepository().load();
				myList.add(myCow);
				outputText.setBorder(new EmptyBorder(10, 10, 10, 10));
				outputText.setFont(new Font("Century Gothic", Font.CENTER_BASELINE, 15));
				outputText.setText("Added new cow " + myCow.getName());
				newPanel.add(outputText);
				ListFrame.getAnimalRepository().save(myList);
			} catch (Exception e1)
			{
				e1.printStackTrace();
			}
		}
	}
	
	private class addTiger implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			try 
			{
				SpeciesFactory speciesFactoryMammals = abstractFactory.getSpeciesFactory(Constants.Species.Mammals);
				Tiger myTiger = (Tiger) speciesFactoryMammals.getAnimal(Constants.Animals.Mammals.Tiger);
				myList = ListFrame.getAnimalRepository().load();
				myList.add(myTiger);
				outputText.setBorder(new EmptyBorder(10, 10, 10, 10));
				outputText.setFont(new Font("Century Gothic", Font.CENTER_BASELINE, 15));
				outputText.setText("Added new tiger " + myTiger.getName());
				newPanel.add(outputText);
				ListFrame.getAnimalRepository().save(myList);
			} catch (Exception e1)
			{
				e1.printStackTrace();
			}
		}
	}
}