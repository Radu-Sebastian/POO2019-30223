package javasmmr.zoowsome.models;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

import javasmmr.zoowsome.services.Constants;
import static javasmmr.zoowsome.repositories.EntityRepository.createNode;
import java.time.LocalTime;

public class Salamander extends Aquatic 
{
	public Salamander(Integer nrOfLegs, String name, Integer avgSwimDepth, waterType livesIn,
			boolean takenCareOf, double maintenanceCost, double dangerPerc)
	{
		super(nrOfLegs, name, avgSwimDepth, livesIn, takenCareOf, maintenanceCost, dangerPerc);
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException 
	{
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT,
		Constants.Animals.Aquatics.Salamander);
	}
	
	public void decodeFromXml(Element element) 
	{
		super.decodeFromXml(element);
	}
	
	public Salamander()
	{
		super(6, "<Unknown Salamander>", 50, waterType.saltwater, false, 0.0, 0.0);
	}
	
	public double getPredisposition()
	{
		LocalTime startTime = LocalTime.parse("12:00:00");
		LocalTime endTime = LocalTime.parse("23:00:00");
		LocalTime t = LocalTime.now();
		if(t.isAfter(startTime) && t.isBefore(endTime))
		{
		   this.setDangerPerc(this.getDangerPerc() + 0.45);
		}
		return (float) (Math.floor(this.dangerPerc * 100)/100);
	}
}
