package javasmmr.zoowsome.views;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class MainMenuFrame extends ZooFrame 
{
	private static final long serialVersionUID = 1L;
	private JButton btnAdd;
	private JButton btnList;
	private JButton btnSaveAndExit;
	
	public MainMenuFrame(String title) 
	{
		super(title);
		contentPanel.setLayout(new GridLayout(0, 3, 0, 0));
		JPanel panel = new JPanel() 
		{	
				private static final long serialVersionUID = 1L;

				public void paintComponent(Graphics g) 
	        	{
	        		super.paintComponent(g);
	        		g.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 15));
	        		g.drawString("Radu-Sebastian's Zoo ", 25, 25);  
	        	}
	    };
		
		contentPanel.add(panel);
		JPanel pan = new JPanel();
		contentPanel.add(pan);
		SpringLayout slPanel = new SpringLayout();
		pan.setLayout(slPanel);

		Icon addIcon = new ImageIcon(getClass().getResource("vault2.png"));
		btnAdd = new JButton("Fill the Zoo!",addIcon);
		btnAdd.setBackground(new Color(230,230,250));
		btnAdd.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 20));
		
		slPanel.putConstraint(SpringLayout.NORTH, btnAdd, 35, SpringLayout.NORTH, pan);
		slPanel.putConstraint(SpringLayout.WEST, btnAdd, 0, SpringLayout.WEST, pan);
		
		pan.add(btnAdd);
		Icon listIcon = new ImageIcon(this.getClass().getResource("vault3.png"));
		
		btnList = new JButton("List the Zoo",listIcon);
		btnList.setBackground(new Color(230,230,250));
		btnList.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 20));
		
		slPanel.putConstraint(SpringLayout.NORTH, btnList, 295, SpringLayout.NORTH, pan);
		slPanel.putConstraint(SpringLayout.WEST, btnList, 0, SpringLayout.WEST, pan);
		
		pan.add(btnList);
		Icon saveIcon = new ImageIcon(this.getClass().getResource("vault4.png"));
		
		btnSaveAndExit = new JButton("Save & Quit",saveIcon);
		btnSaveAndExit.addActionListener(event -> exitApplication());
		btnSaveAndExit.setBackground(new Color(230,230,250));
		btnSaveAndExit.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 20));
		
		slPanel.putConstraint(SpringLayout.NORTH, btnSaveAndExit, 555, SpringLayout.NORTH, pan);
		slPanel.putConstraint(SpringLayout.WEST, btnSaveAndExit, 0, SpringLayout.WEST, pan);
		
		pan.add(btnSaveAndExit);
		JPanel panel_2 = new JPanel()
		{	
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) 
        	{
        		super.paintComponent(g);
        		g.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 15));
        		g.drawString(" © 2019 ", 335, 25); 
        	}
        };
        
		contentPanel.add(panel_2);
		setVisible(true); 
	}
	
	public void setAddButtonActionListener(ActionListener a) 
	{
		btnAdd.addActionListener(a);
	}
	
	public void setListButtonActionListener(ActionListener a) 
	{
		btnList.addActionListener(a);
	}
	
	public void setSaveAndExitButtonActionListener(ActionListener a) 
	{
		btnSaveAndExit.addActionListener(a);
	}
	
	private void exitApplication()
	{
	    System.exit(0); 
	}
}