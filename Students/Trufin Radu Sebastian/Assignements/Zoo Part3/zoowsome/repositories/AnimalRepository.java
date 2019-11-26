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
import javasmmr.zoowsome.models.*;
import javasmmr.zoowsome.services.Constants;

public class AnimalRepository
{
	private static final String XML_FILENAME = "Animals.xml";
	
	public void save(ArrayList<Animal> animals) throws FileNotFoundException, XMLStreamException 
	{
		XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
		XMLEventWriter eventWriter = outputFactory.createXMLEventWriter(new FileOutputStream(XML_FILENAME));
		XMLEventFactory eventFactory = XMLEventFactory.newInstance();
		XMLEvent end = eventFactory.createDTD("\n");
		
		StartDocument startDocument = eventFactory.createStartDocument();
		eventWriter.add(startDocument);
		StartElement configStartElement = eventFactory.createStartElement("", "", "content");
		
		eventWriter.add(configStartElement);
		eventWriter.add(end);
		
		for (Animal animal : animals) 
		{
		   StartElement sElement = eventFactory.createStartElement("", "", Constants.XML_TAGS.ANIMAL);
		   eventWriter.add(sElement);
		   eventWriter.add(end);
		   animal.encodeToXml(eventWriter);
		   EndElement eElement = eventFactory.createEndElement("", "", Constants.XML_TAGS.ANIMAL);
		   eventWriter.add(eElement);
		   eventWriter.add(end);
		}
		   eventWriter.add(eventFactory.createEndElement("", "", "content"));
		   eventWriter.add(eventFactory.createEndDocument());
		   eventWriter.close();
	 }
	
	public static void createNode(XMLEventWriter eventWriter, String name, String value) throws XMLStreamException 
	{
		XMLEventFactory eventFactory = XMLEventFactory.newInstance();
		XMLEvent end = eventFactory.createDTD("\n");
		XMLEvent tab = eventFactory.createDTD("\t");

		StartElement sElement = eventFactory.createStartElement("", "", name);
		eventWriter.add(tab);
		eventWriter.add(sElement);

		Characters characters = eventFactory.createCharacters(value);
		eventWriter.add(characters);

		EndElement eElement = eventFactory.createEndElement("", "", name);
		eventWriter.add(eElement);
		eventWriter.add(end);
	}
	
	public ArrayList<Animal> load() throws ParserConfigurationException, SAXException, IOException 
	{
		ArrayList<Animal> animals = new ArrayList<Animal>();
		File fXmlFile = new File(XML_FILENAME);
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		
		Document doc = dBuilder.parse(fXmlFile);
		doc.getDocumentElement().normalize();
		NodeList nodeList = doc.getElementsByTagName(Constants.XML_TAGS.ANIMAL);
		
		for(int i=0; i<nodeList.getLength(); i++) 
		{
			  Node node = nodeList.item(i);
		   if (node.getNodeType() == Node.ELEMENT_NODE) 
		   {
			  Element element = (Element) node;
		      String discriminant = element.getElementsByTagName(Constants.XML_TAGS.DISCRIMINANT).item(0)
		     .getTextContent();
		      
		     switch (discriminant) 
		   {
		      case Constants.Animals.Insects.Butterfly:
		     {
			     Animal butterfly = new Butterfly();
		         butterfly.decodeFromXml(element);
		         animals.add(butterfly);
		     }
		     case Constants.Animals.Reptiles.Chameleon:
		     {
			    Animal chameleon = new Chameleon();
			    chameleon.decodeFromXml(element);
			    animals.add(chameleon);
		     }
		    case Constants.Animals.Aquatics.Clownfish:
		     {
			    Animal clownfish = new Clownfish();
			    clownfish.decodeFromXml(element);
			    animals.add(clownfish);
		     }
		    case Constants.Animals.Insects.Cockroach:
		    {
			    Animal cockroach = new Cockroach();
			    cockroach.decodeFromXml(element);
			    animals.add(cockroach);
		    }
		    case Constants.Animals.Birds.Colibri:
		    {
			    Animal colibri = new Colibri();
			    colibri.decodeFromXml(element);
			    animals.add(colibri);
		    }
		    case Constants.Animals.Mammals.Cow:
		    {
			   Animal cow = new Cow();
			   cow.decodeFromXml(element);
			   animals.add(cow);
		    }
		   case Constants.Animals.Reptiles.Gecko:
		    {
			    Animal gecko = new Gecko();
			    gecko.decodeFromXml(element);
			    animals.add(gecko);
		    }
		   case Constants.Animals.Reptiles.Iguana:
		    {
			   Animal iguana = new Iguana();
			   iguana.decodeFromXml(element);
			   animals.add(iguana);
		    }
		   case Constants.Animals.Birds.Kiwi:
		    {
			   Animal kiwi = new Kiwi();
			   kiwi.decodeFromXml(element);
			   animals.add(kiwi);
		    }
		   case Constants.Animals.Mammals.Monkey:
		    {
			   Animal monkey = new Monkey();
			   monkey.decodeFromXml(element);
			   animals.add(monkey);
		    }
		   case Constants.Animals.Birds.Penguin:
		    {
			   Animal penguin = new Penguin();
			   penguin.decodeFromXml(element);
			   animals.add(penguin);
		    }
		    case Constants.Animals.Aquatics.Salamander:
		    {
			   Animal salamander = new Salamander();
			   salamander.decodeFromXml(element);
			   animals.add(salamander);
		    }
		    case Constants.Animals.Aquatics.Seahorse:
		    {
			   Animal seahorse = new Seahorse();
			   seahorse.decodeFromXml(element);
			   animals.add(seahorse);
		    }
		    case Constants.Animals.Insects.Spider:
		    {
			   Animal spider = new Spider();
			   spider.decodeFromXml(element);
			   animals.add(spider);
		    }
		    case Constants.Animals.Mammals.Tiger:
		    {
			   Animal tiger = new Tiger();
			   tiger.decodeFromXml(element);
			   animals.add(tiger);
		    }
		default:
		break;
		   }
		  }
		 }
		return animals;
		}
}
