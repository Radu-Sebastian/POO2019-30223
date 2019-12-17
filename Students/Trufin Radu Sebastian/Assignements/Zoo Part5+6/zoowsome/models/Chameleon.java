package javasmmr.zoowsome.models;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

import static javasmmr.zoowsome.repositories.EntityRepository.createNode;
import javasmmr.zoowsome.services.Constants;

public class Chameleon extends Reptile 
{
	public Chameleon(Integer nrOfLegs, String name, boolean laysEggs, boolean takenCareOf, double maintenanceCost,
			double dangerPerc) 
	{
		super(nrOfLegs, name, laysEggs, takenCareOf, maintenanceCost, dangerPerc);
	}

	public Chameleon() 
	{
		super(4, "<Unknown Chameleon>", true, false, 0.0, 0.0);
	}

	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException 
	{
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Reptiles.Chameleon);
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
