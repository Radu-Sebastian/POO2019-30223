package javasmmr.zoowsome.models;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

import javasmmr.zoowsome.services.Constants;
import static javasmmr.zoowsome.repositories.EntityRepository.createNode;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.TimeZone;

public class Cow extends Mammal 
{
	public Cow(Integer nrOfLegs, String name, float normalBodyTemp, float percBodyHair,
			boolean takenCareOf, double maintenanceCost, double dangerPerc)
	{
		super(nrOfLegs, name, normalBodyTemp, percBodyHair, takenCareOf, maintenanceCost, dangerPerc);
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException 
	{
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT,
		Constants.Animals.Mammals.Cow);
	}
	
	public void decodeFromXml(Element element) 
	{
		super.decodeFromXml(element);
	}
	
	public Cow()
	{
		super(4, "<Unknown Cow>", 38, 5, false, 0.0, 0.0);
	}
	
	public double getPredisposition()
	{
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		double extraPercentage = 0.01;
		LocalTime startTime = LocalTime.parse("06:00:00");
		LocalTime endTime = LocalTime.parse("08:00:00");
		LocalTime t = LocalTime.now();
		if(t.isAfter(startTime) && t.isBefore(endTime) && dayOfWeek>=3)
		{
		   double newDanger = (float) (Math.floor((this.getDangerPerc() + extraPercentage) * 100)/100);
		   this.setDangerPerc(newDanger);
		}
		return (Math.floor(this.getDangerPerc() * 100)/100);
	}
}
