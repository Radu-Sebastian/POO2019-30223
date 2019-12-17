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
import javasmmr.zoowsome.models.Chameleon;
import javasmmr.zoowsome.models.Gecko;
import javasmmr.zoowsome.models.Iguana;
import javasmmr.zoowsome.services.AnimalFactory;
import javasmmr.zoowsome.services.Constants;
import javasmmr.zoowsome.services.SpeciesFactory;

public class ReptileFrame extends ZooFrame 
{
	AnimalFactory abstractFactory = new AnimalFactory();
	ArrayList<Animal> myList = new ArrayList<Animal>();
	JLabel outputText = new JLabel();
	
	private static final long serialVersionUID = 1L;
	JPanel gridPanel =  new JPanel(new GridLayout(4, 1));
	JPanel newPanel = new JPanel(new SpringLayout());
	Icon geckoIcon = new ImageIcon(this.getClass().getResource("pictures/gecko.png"));
	JButton geckoButton = new JButton("Gecko",geckoIcon);
	Icon iguanaIcon = new ImageIcon(this.getClass().getResource("pictures/iguana.png"));
	JButton iguanaButton = new JButton("Iguana",iguanaIcon);
	Icon chameleonIcon = new ImageIcon(this.getClass().getResource("pictures/chameleon.png"));
	JButton chameleonButton = new JButton("Chameleon",chameleonIcon);
	
	public ReptileFrame(String title)
	{
		super(title);
		
		gridPanel.add(geckoButton);
		gridPanel.add(iguanaButton);
		gridPanel.add(chameleonButton);
		newPanel.add(outputText);
		newPanel.setBackground(new Color(230,230,250));
		gridPanel.add(newPanel);
		
		geckoButton.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 20));
		geckoButton.setBackground(new Color(230,230,250));
		geckoButton.addActionListener(new addGecko());
		
		iguanaButton.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 20));
		iguanaButton.setBackground(new Color(230,230,250));
		iguanaButton.addActionListener(new addIguana());
		
		chameleonButton.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 20));
		chameleonButton.setBackground(new Color(230,230,250));  
		chameleonButton.addActionListener(new addChameleon());
		
	    contentPanel.add(gridPanel);
	}
	
	private class addGecko implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			try 
			{
				SpeciesFactory speciesFactoryReptiles = abstractFactory.getSpeciesFactory(Constants.Species.Reptiles);
				Gecko myGecko = (Gecko) speciesFactoryReptiles.getAnimal(Constants.Animals.Reptiles.Gecko);
				myList = ListFrame.getAnimalRepository().load();
				myList.add(myGecko);
				outputText.setBorder(new EmptyBorder(10, 10, 10, 10));
				outputText.setFont(new Font("Century Gothic", Font.CENTER_BASELINE, 15));
				outputText.setText("Added new gecko " + myGecko.getName());
				newPanel.add(outputText);
				ListFrame.getAnimalRepository().save(myList);
			} catch (Exception e1)
			{
				e1.printStackTrace();
			}
		}
	}
	
	private class addIguana implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			try 
			{
				SpeciesFactory speciesFactoryReptiles = abstractFactory.getSpeciesFactory(Constants.Species.Reptiles);
				Iguana myIguana = (Iguana) speciesFactoryReptiles.getAnimal(Constants.Animals.Reptiles.Iguana);
				myList = ListFrame.getAnimalRepository().load();
				myList.add(myIguana);
				outputText.setBorder(new EmptyBorder(10, 10, 10, 10));
				outputText.setFont(new Font("Century Gothic", Font.CENTER_BASELINE, 15));
				outputText.setText("Added new iguana " + myIguana.getName());
				newPanel.add(outputText);
				ListFrame.getAnimalRepository().save(myList);
			} catch (Exception e1)
			{
				e1.printStackTrace();
			}
		}
	}
	
	private class addChameleon implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			try 
			{
				SpeciesFactory speciesFactoryReptiles = abstractFactory.getSpeciesFactory(Constants.Species.Reptiles);
				Chameleon myChameleon = (Chameleon) speciesFactoryReptiles.getAnimal(Constants.Animals.Reptiles.Chameleon);
				myList = ListFrame.getAnimalRepository().load();
				myList.add(myChameleon);
				outputText.setBorder(new EmptyBorder(10, 10, 10, 10));
				outputText.setFont(new Font("Century Gothic", Font.CENTER_BASELINE, 15));
				outputText.setText("Added new chameleon " + myChameleon.getName());
				newPanel.add(outputText);
				ListFrame.getAnimalRepository().save(myList);
			} catch (Exception e1)
			{
				e1.printStackTrace();
			}
		}
	}
}