package javasmmr.zoowsome.views;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import javasmmr.zoowsome.employees.Caretaker;
import javasmmr.zoowsome.views.utilities.FrameStack;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public abstract class ZooFrame extends JFrame implements ZooFrame_I 
{	
	private static final long serialVersionUID = 1L;
	protected JPanel contentPanel;
	
	public ZooFrame(String title) 
	{
		FrameStack.getInstance().push(this);
		setTitle(title);
		setSize(1250, 900);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPanel.setBackground(new Color(230,230,250));
		add(contentPanel, BorderLayout.CENTER);
	}
	
	public void setBackButtonActionListener(ActionListener a) 
	{
		JPanel buttonPanel = new JPanel();
		JLabel clockLabel = new JLabel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JButton backButton = new JButton("Back");
		backButton.setBackground(new Color(230,230,250));
		backButton.setFont(new Font("Verdana", Font.CENTER_BASELINE, 20));
		clockLabel.setBackground(new Color(230,230,250));
		clockLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
		clockLabel.setFont(new Font("Century Gothic", Font.CENTER_BASELINE, 20));
		buttonPanel.add(backButton);
		clockLabel.setForeground(new Color(67,67,67));
		buttonPanel.add(clockLabel);
		currentDate(clockLabel);
		this.add(buttonPanel, BorderLayout.NORTH);
		backButton.addActionListener(a);
		setVisible(true); 
	}
	
	public void currentDate(JLabel clockLabel)
	{
		Thread clock = new Thread() 
		{
		public void run()
		{
			for(;;)
			{
				try 
				{
				Calendar cal = new GregorianCalendar();
				SimpleDateFormat myFormat = new SimpleDateFormat("HH:mm:ss");
				clockLabel.setText(myFormat.format(cal.getTime()));
				clockLabel.revalidate();
				clockLabel.repaint();
				sleep(1000);
				} catch(InterruptedException e)
				{
				    	Logger.getLogger(Caretaker.class.getName()).log(Level.SEVERE, "Error");
				}
			}	
		}
		};
		clock.start();
	}
}
