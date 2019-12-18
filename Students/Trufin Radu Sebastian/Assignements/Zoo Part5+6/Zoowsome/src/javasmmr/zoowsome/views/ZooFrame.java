package javasmmr.zoowsome.views;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javasmmr.zoowsome.employees.Caretaker;
import javasmmr.zoowsome.views.utilities.FrameStack;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

public abstract class ZooFrame extends JFrame
{	
	public class timeMenu extends JPopupMenu
	{
		private static final long serialVersionUID = 1L;

		timeMenu()
		{
			String[] timeZones = {"Europe/Bucharest", "Europe/Berlin", "Europe/London",
					"Europe/Moscow", "America/New_York", "Asia/Tokyo", "US/Hawaii", "US/Pacific"};
			
			for(int i=0; i<timeZones.length; i++)
			{
				JMenuItem popList = new JMenuItem(timeZones[i]);
				popList.addActionListener(popUpListener);
				add(popList);
			}
		}
		
		ActionListener popUpListener = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				JMenuItem popMenu = (JMenuItem) e.getSource();
				myTimeZone = popMenu.getText();
			}
		};
	}
	
	private static final long serialVersionUID = 1L;
	protected JPanel contentPanel;
	String myTimeZone = new String("Europe/Bucharest");
	
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
	
	public void setBackButtonAndClockActionListener(ActionListener a) 
	{
		JPanel buttonPanel = new JPanel();
		JPanel clockPanel = new JPanel();
		JPanel topPanel= new JPanel();
		JLabel clockLabel = new JLabel();
		topPanel.setLayout(new GridLayout(0,2));
		buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		clockPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		clockLabel.setComponentPopupMenu(new timeMenu());
		JButton backButton = new JButton("Back");
		backButton.setBackground(new Color(230,230,250));
		backButton.setFont(new Font("Verdana", Font.CENTER_BASELINE, 20));
		clockLabel.setBackground(new Color(230,230,250));
		clockLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
		clockLabel.setFont(new Font("Century Gothic", Font.CENTER_BASELINE, 20));
		buttonPanel.add(backButton);
		clockPanel.add(clockLabel);
		topPanel.add(buttonPanel);
		topPanel.add(clockPanel);
		add(topPanel, BorderLayout.NORTH);
		currentDate(clockLabel);
		backButton.addActionListener(a);
		setVisible(true); 
	}
	
	public void setBackButtonActionListener(ActionListener a) 
	{
		JPanel buttonPanel = new JPanel();
		JPanel clockPanel = new JPanel();
		JPanel topPanel= new JPanel();
		topPanel.setLayout(new GridLayout(0,2));
		buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		clockPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		JButton backButton = new JButton("Back");
		JLabel clock = new JLabel("clock");
		buttonPanel.add(backButton);
		clockPanel.add(clock);
		topPanel.add(buttonPanel);
		topPanel.add(clockPanel);
		this.add(topPanel, BorderLayout.NORTH);
		backButton.addActionListener(a);
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
						SimpleDateFormat myFormat;
						Calendar cal = new GregorianCalendar();
						myFormat = new SimpleDateFormat("HH:mm:ss");
						myFormat.setTimeZone(TimeZone.getTimeZone(myTimeZone));
						clockLabel.setText(myFormat.format(cal.getTime()));
				        clockLabel.revalidate();
				        clockLabel.repaint();
				        sleep(1000);
				    }   catch(InterruptedException e)
				    {
				        Logger.getLogger(Caretaker.class.getName()).log(Level.SEVERE, "Error");
				    }
			    }	
		    }
		};
		clock.start();
	}
}
