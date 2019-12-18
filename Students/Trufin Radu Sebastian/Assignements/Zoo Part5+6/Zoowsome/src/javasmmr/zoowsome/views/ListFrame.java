package javasmmr.zoowsome.views;
import java.awt.Color;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import javasmmr.zoowsome.employees.Employee;
import javasmmr.zoowsome.models.*;
import javasmmr.zoowsome.repositories.AnimalRepository;
import javasmmr.zoowsome.repositories.EmployeeRepository;
import javasmmr.zoowsome.services.Constants;

public class ListFrame extends ZooFrame 
{
	private static final long serialVersionUID = 1L;
	
    static AnimalRepository animalRepository = new AnimalRepository("AnimalsGeneric.xml", Constants.XML_TAGS.ANIMAL);
    static EmployeeRepository employeeRepository = new EmployeeRepository("EmployeesGeneric.xml", Constants.XML_TAGS.EMPLOYEE);
	static ArrayList<Animal> myAnimals;

	public ListFrame(String title) throws ParserConfigurationException, SAXException, IOException 
	{
		super(title);
		
		contentPanel.setLayout(new GridLayout(1,2));
		JPanel newPanel = new JPanel(new GridLayout());
		Border border = BorderFactory.createLineBorder(Color.magenta);
		JTable animalTable = new JTable()
		{
			private static final long serialVersionUID = 1L;
			DefaultTableCellRenderer renderCenter = new DefaultTableCellRenderer();
		    { 
		    	renderCenter.setHorizontalAlignment(SwingConstants.CENTER);
		    }

		    @Override
		    public TableCellRenderer getCellRenderer(int arg0, int arg1) 
		    {
		        return renderCenter;
		    }
		};
		
		JScrollPane animalScroll = new JScrollPane(animalTable);
		JTable caretakerTable = new JTable()
		{
			private static final long serialVersionUID = 1L;
			DefaultTableCellRenderer renderCenter = new DefaultTableCellRenderer();
		    { 
		    	renderCenter.setHorizontalAlignment(SwingConstants.CENTER);
		    }

		    @Override
		    public TableCellRenderer getCellRenderer (int arg0, int arg1) 
		    {
		        return renderCenter;
		    }
		};
		
		JScrollPane caretakerScroll = new JScrollPane(caretakerTable);
		newPanel.setBorder(border);
		animalTable.setName("Zoowsome Members");
		animalTable.setGridColor(new Color(230,230,250));
		animalTable.setForeground(new Color(51,51,51));
		caretakerTable.setName("Zoowsome Caretakers");
		caretakerTable.setGridColor(new Color(230,230,250));
		caretakerTable.setForeground(new Color(51,51,51));
		
		DefaultTableModel animalModel = new DefaultTableModel();
		String[] animalHeaders = {"Name", "Danger %" ,"Maintenance Cost", "Number of legs", "Discriminant"};
		animalModel.setColumnIdentifiers(animalHeaders);
		animalTable.setDefaultEditor(Object.class, null);
		ArrayList<Animal> myAnimals = animalRepository.load();
		
		Object animalRowData[] = new Object[5];
		for(int i=0; i<myAnimals.size(); i++) 
		{
			animalRowData[0] = myAnimals.get(i).getName();
			animalRowData[1] = Math.floor(myAnimals.get(i).getDangerPerc() * 100)/100;
			animalRowData[2] = Math.floor(myAnimals.get(i).getMaintenanceCost() * 100)/100;
			animalRowData[3] = myAnimals.get(i).getNrOfLegs();
			animalRowData[4] = myAnimals.get(i).getClass().getName().substring(25);
			animalModel.addRow(animalRowData);
		}
		
		DefaultTableModel caretakerModel = new DefaultTableModel();
		String[] caretakerHeaders = {"Name", "ID" ,"Salary", "Death Status", "Discriminant"};
		caretakerModel.setColumnIdentifiers(caretakerHeaders);
		caretakerTable.setDefaultEditor(Object.class, null);
		ArrayList<Employee> myEmployees = employeeRepository.load();
		animalTable.setAlignmentX(CENTER_ALIGNMENT);
		animalTable.setAlignmentY(CENTER_ALIGNMENT);

		Object employeeRowData[] = new Object[5];
		for(int i=0; i<myEmployees.size(); i++) 
		{
			employeeRowData[0] = myEmployees.get(i).getName();
			employeeRowData[1] = myEmployees.get(i).getID();
			employeeRowData[2] = myEmployees.get(i).getSalary();
			employeeRowData[3] = myEmployees.get(i).getDeath();
			employeeRowData[4] = myEmployees.get(i).getClass().getName().substring(28);
			caretakerModel.addRow(employeeRowData);
		}
		
		animalTable.setModel(animalModel);
		caretakerTable.setModel(caretakerModel);

		newPanel.add(caretakerScroll);
		newPanel.add(animalScroll);
		
		contentPanel.add(newPanel);
	}
	
	public static AnimalRepository getAnimalRepository()
	{
		return animalRepository;
	}
}