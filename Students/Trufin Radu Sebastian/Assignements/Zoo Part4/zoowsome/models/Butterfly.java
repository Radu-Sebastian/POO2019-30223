package javasmmr.zoowsome.models;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;
import static javasmmr.zoowsome.repositories.EntityRepository.createNode;
import javasmmr.zoowsome.services.Constants;

public class Butterfly extends Insect
{
	public Butterfly(Integer nrOfLegs, String name, boolean canFly, boolean isDangerous,
			boolean takenCareOf, double maintenanceCost, double dangerPerc) 
	{
		super(nrOfLegs, name, canFly, isDangerous, takenCareOf, maintenanceCost, dangerPerc);
	}
	
	public Butterfly()
	{
		this.name = "<Unknown Butterfly>";
		this.nrOfLegs = 6;
		this.canFly = true;
		this.isDangerous = false;
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException 
	{
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT,
		Constants.Animals.Insects.Butterfly);
	}
	
	public double getPredisposition()
	{
		return (float) (Math.floor(this.dangerPerc * 100)/100);
	}
}
