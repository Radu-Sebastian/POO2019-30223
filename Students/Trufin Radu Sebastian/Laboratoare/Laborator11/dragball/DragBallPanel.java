package dragball;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Random;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class DragBallPanel extends JPanel implements MouseListener, MouseMotionListener 
{
	private static final long serialVersionUID = 1L;
	private static final int BALL_DIAMETER = 70;
	private int _ballX = 210; 
	private int _ballY = 210;
	private int xDecrement = -1;
	private int yDecrement = 1;
	private int _dragFromX = 0;
	private int _dragFromY = 0; 
	private boolean _canDrag = false;
	private int stopDVD = 0;
	private JButton dvdButton = new JButton("move");
	private JButton stopButton = new JButton("stop");
	
	DragBallPanel() 
	{
		setPreferredSize(new Dimension(500, 500));
		setBackground(new Color(230,230,250));
		setForeground(new Color(147,112,219)); 
		add(dvdButton);
		add(stopButton);
		setBorder(new EmptyBorder(15, 15, 15, 15));
		dvdButton.addActionListener(new dvdMove());
		dvdButton.setFont(new Font("Calibri", Font.CENTER_BASELINE, 15));
		dvdButton.setBackground(new Color(255,255,255));
		stopButton.setBackground(new Color(255,255,255));
		stopButton.setFont(new Font("Calibri", Font.CENTER_BASELINE, 15));
		stopButton.addActionListener(new stopMove());
		addMouseListener(this);
	    addMouseMotionListener(this);
	}
		
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g); 
		g.drawLine(0, 60, 500, 60);
		g.setFont(new Font("Calibri", Font.CENTER_BASELINE, 15));
		g.drawString("X :", 25, 25);  
		g.drawString(String.valueOf(_ballX), 55, 25); 
		g.drawString("Y :", 25, 45); 
		g.drawString(String.valueOf(_ballY), 55, 45); 
		g.drawString("punct singular esential izolat", 160, 15);
		g.drawString(" © 2019 ", 423, 25); 
		g.drawString("Radu-Sebastian", 400, 45);
		g.fillArc(_ballX, _ballY, BALL_DIAMETER, BALL_DIAMETER,30,300);
	}
	
	public void mousePressed(MouseEvent e) 
	{
		int x = e.getX(); 
		int y = e.getY(); 
		
		if (x >= _ballX && x <= (_ballX + BALL_DIAMETER)
				&& y >= _ballY && y <= (_ballY + BALL_DIAMETER)) 
		{
			_canDrag = true;
			_dragFromX = x - _ballX;
			_dragFromY = y - _ballY; 
		} 
		else 
		{
			_canDrag = false;
		}
	}
	
	public void mouseDragged(MouseEvent e) 
	{
		if (_canDrag) 
		{ 
			_ballX = e.getX() - _dragFromX;
			_ballY = e.getY() - _dragFromY;
			_ballX = Math.max(_ballX, 0);
			_ballX = Math.min(_ballX, getWidth() - BALL_DIAMETER);
			_ballY = Math.max(_ballY, 0);
			_ballY = Math.min(_ballY, getHeight() - BALL_DIAMETER);
			this.repaint();
		}
	}
	
	public void mouseExited(MouseEvent e) 
	{
		_canDrag = false;
	}
	
	public void mouseClicked(MouseEvent e)
	{
		Thread clk = new Thread() 
		{
		public void run()
		{
			int ok = 0;
			for(;;)
			{
				try 
				{
					int x = e.getX(); 
					int y = e.getY(); 
					
					if (x >= _ballX && x <= (_ballX + BALL_DIAMETER)
							&& y >= _ballY && y <= (_ballY + BALL_DIAMETER) && ok !=1 ) 
					{
						try 
						{
							InputStream music = new FileInputStream(new File("D:\\Eclipse\\Radu-Sebastian12\\src\\dragball\\Inception.wav"));
							AudioStream audio = new AudioStream(music);
							AudioPlayer.player.start(audio);
						} catch (Exception e1) 
						{
							JOptionPane.showMessageDialog(null, "Error");
						}
						
						_ballX = new Random().nextInt(370) + 60;
						_ballY = new Random().nextInt(370) + 60;
						repaint();
						ok=1;
					}
					else if(ok>=1)
					{
						_ballX = new Random().nextInt(370) + 60;
						_ballY = new Random().nextInt(370) + 60;
						sleep(1000);
						ok++;
						repaint();
					}
					if(ok == 5)
						break;
				}
				 catch(InterruptedException e)
				{
				    	System.out.println("Error");
				}
			}	
		}
		};
		clk.start();
	}
	
	public void mouseMoved (MouseEvent e) {}
	public void mouseEntered (MouseEvent e) {}
	public void mouseReleased(MouseEvent e){}
	
	public class dvdMove implements ActionListener
    {
		public void actionPerformed(ActionEvent e)
   	  {
		  stopDVD = 0;
   		  Thread clk = new Thread() 
   		  {
   			  public void run()
   			  {
   				  for(;;)
   				  {
   					  try 
   					  {	
   						  _ballX = _ballX + xDecrement;
   						  _ballY = _ballY + yDecrement;
   						  
   						  if(_ballX < 0)
   						  {
   							  _ballX = 0;
   							  xDecrement = (-1) * xDecrement;
   						  }
   						  
   						  if(_ballX >= 430)
   						  {
   							  _ballX = 430;
   							  xDecrement = (-1) * xDecrement;
   						  }
   						  
   						  if(_ballY < 60)
   						  {
   							  _ballY = 60;
   							  yDecrement = (-1) * yDecrement;
   						  }
   						  
   						  if(_ballY >= 430)
   						  {
   							  _ballY = 430;
   							  yDecrement = (-1) * yDecrement;
   						  }
   						  sleep(7);
   						  if(stopDVD == 1)
   							  break;
   						  repaint();
			          } catch(InterruptedException e)
			            {
			        	  System.out.println("Error");
			            }
		         }	
	        }
	     };
	        clk.start();
   	  }
    }
	
	
	public class stopMove implements ActionListener
    {
		public void actionPerformed(ActionEvent e)
   	  {
			stopDVD = 1;
   	  }
    }
}