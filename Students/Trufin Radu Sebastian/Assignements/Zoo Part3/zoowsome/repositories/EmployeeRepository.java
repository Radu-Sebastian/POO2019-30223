package javasmmr.zoowsome.repositories;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javasmmr.zoowsome.employees.Caretaker;
import javasmmr.zoowsome.employees.Employee;
import javasmmr.zoowsome.services.Constants;

public class EmployeeRepository 
{
	private static final String XML_FILENAME2 = "Employees.xml";
	
	public void save(ArrayList<Employee> employees) throws FileNotFoundException, XMLStreamException 
	{
		XMLOutputFactory outputFactory2 = XMLOutputFactory.newInstance();
		XMLEventWriter eventWriter2 = outputFactory2.createXMLEventWriter(new FileOutputStream(XML_FILENAME2));
		XMLEventFactory eventFactory2 = XMLEventFactory.newInstance();
		XMLEvent end2 = eventFactory2.createDTD("\n");
		
		StartDocument startDocument2 = eventFactory2.createStartDocument();
		eventWriter2.add(startDocument2);
		StartElement configStartElement2 = eventFactory2.createStartElement("", "", "content");
		
		eventWriter2.add(configStartElement2);
		eventWriter2.add(end2);
		
		for (Employee employee : employees) 
		{
		   StartElement sElement2 = eventFactory2.createStartElement("", "", Constants.XML_TAGS.EMPLOYEE);
		   eventWriter2.add(sElement2);
		   eventWriter2.add(end2);
		   employee.encodeToXml(eventWriter2);
		   EndElement eElement2 = eventFactory2.createEndElement("", "", Constants.XML_TAGS.EMPLOYEE);
		   eventWriter2.add(eElement2);
		   eventWriter2.add(end2);
		}
		   eventWriter2.add(eventFactory2.createEndElement("", "", "content"));
		   eventWriter2.add(eventFactory2.createEndDocument());
		   eventWriter2.close();
	 }
	
	public static void createNode(XMLEventWriter eventWriter, String name, String value) throws XMLStreamException 
	{
		XMLEventFactory eventFactory2 = XMLEventFactory.newInstance();
		XMLEvent end2 = eventFactory2.createDTD("\n");
		XMLEvent tab2 = eventFactory2.createDTD("\t");

		StartElement sElement2 = eventFactory2.createStartElement("", "", name);
		eventWriter.add(tab2);
		eventWriter.add(sElement2);

		Characters characters2 = eventFactory2.createCharacters(value);
		eventWriter.add(characters2);

		EndElement eElement2 = eventFactory2.createEndElement("", "", name);
		eventWriter.add(eElement2);
		eventWriter.add(end2);
	}
	
	public ArrayList<Employee> load() throws ParserConfigurationException, SAXException, IOException 
	{
		ArrayList<Employee> employees = new ArrayList<Employee>();
		File fXmlFile2 = new File(XML_FILENAME2);
		
		DocumentBuilderFactory dbFactory2 = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder2 = dbFactory2.newDocumentBuilder();
		
		Document doc2 = dBuilder2.parse(fXmlFile2);
		doc2.getDocumentElement().normalize();
		NodeList nodeList2 = doc2.getElementsByTagName(Constants.XML_TAGS.EMPLOYEE);
		
		for(int i=0; i<nodeList2.getLength(); i++) 
		{
			  Node node2 = nodeList2.item(i);
		   if (node2.getNodeType() == Node.ELEMENT_NODE) 
		   {
			  Element element2 = (Element) node2;
		      String discriminant2 = element2.getElementsByTagName(Constants.XML_TAGS.DISCRIMINANT).item(0)
		     .getTextContent();
		      
		     switch (discriminant2) 
		   {
		      case Constants.EmployeeTypes.Caretakers:
		     {
			     Employee caretaker = new Caretaker();
		         caretaker.decodeFromXml(element2);
		         employees.add(caretaker);
		     }
		     break;
		default:
		break;
		   }
		  }
		 }
		return employees;
		}
}
