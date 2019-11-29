package javasmmr.zoowsome.models;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;
import org.w3c.dom.Element;
import javasmmr.zoowsome.services.Constants;
import static javasmmr.zoowsome.repositories.EntityRepository.createNode;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.TimeZone;

public class Monkey extends Mammal 
{
	public Monkey(Integer nrOfLegs, String name, float normalBodyTemp, float percBodyHair,
			boolean takenCareOf, double maintenanceCost, double dangerPerc)
	{
		super(nrOfLegs, name, normalBodyTemp, percBodyHair, takenCareOf, maintenanceCost, dangerPerc);
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException 
	{
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT,
		Constants.Animals.Mammals.Monkey);
	}
	
	public Monkey()
	{
		this.name = "Oita Claudiu Andrei";
		this.nrOfLegs = 2;
		this.normalBodyTemp = (float) 38.2;
		this.percBodyHair = 82;
	}
	
	public double getPredisposition()
	{
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		double extraPercentage = 0.05;
		LocalTime startTime = LocalTime.parse("11:00:00");
		LocalTime endTime = LocalTime.parse("23:00:00");
		LocalTime t = LocalTime.now();
		
		if(t.isAfter(startTime) && t.isBefore(endTime) && dayOfWeek >=3)
		{		
			double newDanger = this.getDangerPerc() + extraPercentage;
		   if(newDanger >= 1)
			   this.setDangerPerc(1);
		   else
		   {
			   newDanger = (float) (Math.floor((this.getDangerPerc() + extraPercentage) * 100)/100);
		       this.setDangerPerc(newDanger);
		   }
		}
		return  (Math.floor(this.getDangerPerc() * 100)/100);
	}

	@Override
	public void decodeFromXml(Element element) {
		// TODO Auto-generated method stub
	}
}
