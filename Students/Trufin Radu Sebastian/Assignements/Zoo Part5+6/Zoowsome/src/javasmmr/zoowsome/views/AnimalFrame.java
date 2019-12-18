package javasmmr.zoowsome.views;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class AnimalFrame extends ZooFrame 
{
	private static final long serialVersionUID = 1L;
	JPanel gridPanel;
	
	Icon mammalIcon = new ImageIcon("./resources/dog.png");
	JButton mammalButton = new JButton("Mammal",mammalIcon);
	Icon birdIcon = new ImageIcon("./resources/toucan.png");
	JButton birdButton = new JButton("Bird",birdIcon);
	Icon insectIcon = new ImageIcon("./resources/insect.png");
	JButton insectButton = new JButton("Insect",insectIcon);
	Icon aquaticIcon = new ImageIcon("./resources/fish.png");
	JButton aquaticButton = new JButton("Aquatic",aquaticIcon);
	Icon reptileIcon = new ImageIcon("./resources/lizard.png");
	JButton reptileButton = new JButton("Reptile",reptileIcon);
	
	public AnimalFrame(String title)
	{
		super(title);
		JPanel gridPanel  = new JPanel(new GridLayout(5, 1));
		
		gridPanel.add(mammalButton);
		gridPanel.add(birdButton);
		gridPanel.add(insectButton);
		gridPanel.add(aquaticButton);
		gridPanel.add(reptileButton);
		
	    mammalButton.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 20));
	    mammalButton.setBackground(new Color(230,230,250));
	    birdButton.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 20));
	    birdButton.setBackground(new Color(230,230,250));
	    insectButton.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 20));
	    insectButton.setBackground(new Color(230,230,250));
	    aquaticButton.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 20));
	    aquaticButton.setBackground(new Color(230,230,250));
	    reptileButton.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 20));
	    reptileButton.setBackground(new Color(230,230,250));    
	    
	    contentPanel.add(gridPanel);
	}
	
	public void setAddMammalActionListener(ActionListener a) 
	{
		mammalButton.addActionListener(a);
	}
	
	public void setAddBirdActionListener(ActionListener a) 
	{
		birdButton.addActionListener(a);
	}
	
	public void setAddInsectActionListener(ActionListener a) 
	{
		insectButton.addActionListener(a);
	}
	
	public void setAddReptileActionListener(ActionListener a) 
	{
		reptileButton.addActionListener(a);
	}
	
	public void setAddAquaticActionListener(ActionListener a) 
	{
		aquaticButton.addActionListener(a);
	}
}