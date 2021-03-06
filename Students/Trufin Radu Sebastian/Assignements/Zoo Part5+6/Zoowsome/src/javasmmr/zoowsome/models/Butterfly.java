package javasmmr.zoowsome.models;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

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
		super(6, "<Unknown Butterfly>", true, false, false, 0.0, 0.0);
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException 
	{
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT,
		Constants.Animals.Insects.Butterfly);
	}
	
	public void decodeFromXml(Element element) 
	{
		super.decodeFromXml(element);
	}
	
	public double getPredisposition()
	{
		return (float) (Math.floor(this.dangerPerc * 100)/100);
	}
}
