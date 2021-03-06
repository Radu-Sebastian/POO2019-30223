package javasmmr.zoowsome.models;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;
import static javasmmr.zoowsome.repositories.EntityRepository.createNode;
import javasmmr.zoowsome.services.Constants;

public class Chameleon extends Reptile 
{
	public Chameleon(Integer nrOfLegs, String name, boolean laysEggs,
			boolean takenCareOf, double maintenanceCost, double dangerPerc) 
	{
		super(nrOfLegs, name, laysEggs, takenCareOf, maintenanceCost, dangerPerc);
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException 
	{
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT,
		Constants.Animals.Reptiles.Chameleon);
	}
	
	public Chameleon()
	{
		this.name = "<Unknown Chameleon>";
		this.laysEggs = true;
		this.nrOfLegs = 2;
	}
	
	public double getPredisposition()
	{
		return (float) (Math.floor(this.dangerPerc * 100)/100);
	}
}
