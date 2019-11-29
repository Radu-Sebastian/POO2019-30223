package javasmmr.zoowsome.models;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;
import org.w3c.dom.Element;
import javasmmr.zoowsome.services.Constants;
import static javasmmr.zoowsome.repositories.EntityRepository.createNode;

public class Penguin extends Bird 
{
	public Penguin(Integer nrOfLegs, String name, boolean migrates, Integer avgFlightAltitude,
			boolean takenCareOf, double maintenanceCost, double dangerPerc) 
	{
		super(nrOfLegs, name, migrates, avgFlightAltitude, takenCareOf, maintenanceCost, dangerPerc);
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException 
	{
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT,
		Constants.Animals.Birds.Penguin);
	}
	
	public Penguin()
	{
		this.name = "Happy Feet";
		this.avgFlightAltitude = 0;
		this.migrates = false;
		this.nrOfLegs = 2;
	}
	
	public double getPredisposition()
	{
		return (float) (Math.floor(this.dangerPerc * 100)/100);
	}

	@Override
	public void decodeFromXml(Element element) {
		// TODO Auto-generated method stub
		
	}
}
