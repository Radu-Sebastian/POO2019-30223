package javasmmr.zoowsome.views;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.net.URI;
import java.util.LinkedList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javasmmr.zoowsome.employees.Caretaker;
import javasmmr.zoowsome.employees.CaretakerException;

public class AddFrame extends ZooFrame 
{
	private static final long serialVersionUID = 1L;
	private LinkedList<Caretaker> caretakerLinkedList = new LinkedList<Caretaker>();
	JTextArea caretakerTextArea = new JTextArea ();
	JLabel idLabel = new JLabel("ID: ");
	JTextField idTextField = new JTextField (10);
	JLabel nameLabel = new JLabel("Name: ");
	JTextField nameTextField = new JTextField(10);
	JButton addButton = new JButton("Add");
    JButton deleteButton = new JButton("Delete");
	JButton addAnimalButton = new JButton("Add Animals");
	JButton exitButton = new JButton("Exit");
	Icon vaultIcon = new ImageIcon(this.getClass().getResource("vaultboy.png"));
	JButton iconButton = new JButton(" ",vaultIcon);
	
	public AddFrame(String title)
	{
		super(title);
		JPanel firstPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	    JPanel secondPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel gridPanel  = new JPanel(new GridLayout(2, 1));
		caretakerTextArea.setEditable(false);
		
		firstPanel.add(idLabel);
		firstPanel.add(idTextField);
		firstPanel.add(nameLabel);
		firstPanel.add(nameTextField);

		secondPanel.add(addButton);
		secondPanel.add(deleteButton);
		secondPanel.add(addAnimalButton);
		secondPanel.add(exitButton);
		secondPanel.add(iconButton);

		gridPanel.add(firstPanel);
	    gridPanel.add(secondPanel);
	    
	    nameLabel.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 20));
	    idLabel.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 20));
	    addButton.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 20));
	    addButton.setBackground(new Color(230,230,250));
	    deleteButton.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 20));
	    deleteButton.setBackground(new Color(230,230,250));
	    addAnimalButton.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 20));
	    addAnimalButton.setBackground(new Color(230,230,250));
	    exitButton.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 20));
	    exitButton.setBackground(new Color(230,230,250));
	    idTextField.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 20));
	    nameTextField.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 20));
	    iconButton.setBackground(new Color(230,230,250));
	    iconButton.addActionListener(event -> openWebPage("https://github.com/Radu-Sebastian"));
	   
		add(caretakerTextArea, BorderLayout.CENTER);
		add(gridPanel, BorderLayout.SOUTH);
		
		addButton.addActionListener(event -> addCaretaker());
		addAnimalButton.addActionListener(event -> displayAll());
	    exitButton.addActionListener(event -> exitApplication());
	    deleteButton.addActionListener(event -> deleteCaretaker());
	    
	}
	
	public static void openWebPage(String url) 
	{
        try 
        {
            Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
            if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE))
            {
                desktop.browse(new URI(url));
            }
            throw new NullPointerException();
        } catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, url, "", JOptionPane.PLAIN_MESSAGE);
        }
    }
	
	 private boolean isCaretakerIDInLinkedList(String id)
     {
        boolean inList = false;

        for(Caretaker caretaker : caretakerLinkedList)
        {
           if(caretaker.getID().compareToIgnoreCase(id) == 0)
           {
              inList = true;
           }
        }

        return inList;
     }
	
	private void addCaretaker()
	{
	      if(isCaretakerIDInLinkedList(idTextField.getText()) == true)
	      {
	         JOptionPane.showMessageDialog(null, "Error: caretaker ID is already in the database.");
	      }
	      else
	      {
	         try
	         {
	        	Caretaker caretaker = new Caretaker(nameTextField.getText(),idTextField.getText());
	        	
	            caretakerLinkedList.add(caretaker);
	            displayAll();
	            
	            nameTextField.setText("");
	            idTextField.setText("");
	            
	         } catch (CaretakerException error)
	         {
	             JOptionPane.showMessageDialog(null, error.toString());
	         }
	      }
	 }
	
	private void deleteCaretaker()
	{
	      if (caretakerLinkedList.size() == 0)
	      {
	         JOptionPane.showMessageDialog(null, "Error: Database is empty.");
	      }
	      else if (isCaretakerIDInLinkedList(idTextField.getText()) == false)
	      {
	         JOptionPane.showMessageDialog(null, "Error: caretaker ID is not in the database.");
	      }
	      else
	      {
	         for(int s=0; s <caretakerLinkedList.size(); s++)
	         {
	            String currId = caretakerLinkedList.get(s).getID();

	            if(currId.compareToIgnoreCase(idTextField.getText()) == 0)
	            {
	               caretakerLinkedList.remove(s);
	            }
	         }

	         displayAll();

	         nameTextField.setText("");
	         idTextField.setText("");
	      }
	}
	
	private void exitApplication()
	{
	      System.exit(0); 
	}
	
	public void setAddAnimalActionListener(ActionListener a) 
	{
		addAnimalButton.addActionListener(a);
	}
	
	private void displayAll()
	{
	      caretakerTextArea.setText("");
	      for (Caretaker caretaker : caretakerLinkedList)
	      {
	    	  caretakerTextArea.append (caretaker + "\n");
	      }
	}
}