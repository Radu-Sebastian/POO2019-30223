package javasmmr.zoowsome.models;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;
import javasmmr.zoowsome.services.Constants;
import static javasmmr.zoowsome.repositories.EntityRepository.createNode;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.TimeZone;

public class Tiger extends Mammal 
{
	public Tiger(Integer nrOfLegs, String name, float normalBodyTemp, float percBodyHair,
			boolean takenCareOf, double maintenanceCost, double dangerPerc)
	{
		super(nrOfLegs, name, normalBodyTemp, percBodyHair, takenCareOf, maintenanceCost, dangerPerc);
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException 
	{
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT,
		Constants.Animals.Mammals.Tiger);
	}
	
	public Tiger()
	{
		this.name = "<Unknown Tiger>";
		this.normalBodyTemp = (float) 37.5;
		this.percBodyHair = 95;
		this.nrOfLegs = 2;
	}
	
	public double getPredisposition()
	{
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		double extraPercentage = 0.15;
		LocalTime startTime = LocalTime.parse("14:00:00");
		LocalTime endTime = LocalTime.parse("23:00:00");
		LocalTime t = LocalTime.now();
		if(t.isAfter(startTime) && t.isBefore(endTime))
		{
			double newDanger = 0;
			double newDanger2 = this.getDangerPerc() + extraPercentage;
			if(dayOfWeek == 4)
		        {
				   newDanger = (float) (Math.floor((this.getDangerPerc() + extraPercentage) * 100)/100);
				   this.setDangerPerc(newDanger);
		        }
			else
			{
				   newDanger = (float) (Math.floor((this.getDangerPerc() + extraPercentage + 0.05) * 100)/100);
				   this.setDangerPerc(newDanger);
			}
		   
		   if(newDanger2 >= 1)
			   this.setDangerPerc(1);
		   else
		       this.setDangerPerc(newDanger);
		}
		return (Math.floor(this.getDangerPerc() * 100)/100);
	}
}
