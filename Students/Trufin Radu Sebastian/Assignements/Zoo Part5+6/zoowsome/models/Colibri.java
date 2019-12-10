package javasmmr.zoowsome.models;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

import javasmmr.zoowsome.services.Constants;
import static javasmmr.zoowsome.repositories.EntityRepository.createNode;

public class Colibri extends Bird 
{
	public Colibri(Integer nrOfLegs, String name, boolean migrates, Integer avgFlightAltitude,
			boolean takenCareOf, double maintenanceCost, double dangerPerc) 
	{
		super(nrOfLegs, name, migrates, avgFlightAltitude, takenCareOf, maintenanceCost, dangerPerc);
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException 
	{
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT,
		Constants.Animals.Birds.Colibri);
	}
	
	public void decodeFromXml(Element element) 
	{
		super.decodeFromXml(element);
	}
	
	public Colibri()
	{
		super(2, "<Unknown Colibri>", false, 25, false, 0.0, 0.0);
	}
	
	public double getPredisposition()
	{
		return (float) (Math.floor(this.dangerPerc * 100)/100);
	}
}
