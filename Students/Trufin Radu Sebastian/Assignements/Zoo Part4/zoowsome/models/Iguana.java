package javasmmr.zoowsome.models;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;
import org.w3c.dom.Element;
import javasmmr.zoowsome.services.Constants;
import static javasmmr.zoowsome.repositories.EntityRepository.createNode;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.TimeZone;

public class Iguana extends Reptile 
{
	public Iguana(Integer nrOfLegs, String name, boolean laysEggs,
			boolean takenCareOf, double maintenanceCost, double dangerPerc) 
	{
		super(nrOfLegs, name, laysEggs, takenCareOf, maintenanceCost, dangerPerc);
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException 
	{
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT,
		Constants.Animals.Reptiles.Iguana);
	}
	
	public Iguana()
	{
		this.name = "Nelu";
		this.laysEggs = true;
		this.nrOfLegs = 4;
	}	
	
	public double getPredisposition()
	{
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		LocalTime startTime = LocalTime.parse("06:00:00");
		LocalTime endTime = LocalTime.parse("08:00:00");
		LocalTime t = LocalTime.now();
		if(t.isAfter(startTime) && t.isBefore(endTime) && dayOfWeek>=3)
		{
		   this.setDangerPerc(this.getDangerPerc() + 0.55);
		}
		return (float) (Math.floor(this.dangerPerc * 100)/100);
	}

	@Override
	public void decodeFromXml(Element element) {
		// TODO Auto-generated method stub
		
	}	
}
