package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FarmacieView extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JTextField outputText = new JTextField(20);
	private JButton SortButton = new JButton("Sort");
	
	public FarmacieView()
	{
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new FlowLayout());
		mainPanel.add(SortButton);
		mainPanel.add(outputText);
		
		getContentPane().setLayout(new GridLayout());
		mainPanel.setLayout(new GridLayout(2,2));
		setPreferredSize(new Dimension(400,300));
		setLocationRelativeTo(null);
		setContentPane(mainPanel);
        setTitle("Simulare Farmacie");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
	}
	
	public void addSortListener(ActionListener a) 
	{
	    SortButton.addActionListener(a);
	}
	
	public void changeText(String s)
	{
		outputText.setText(s);
	}
}