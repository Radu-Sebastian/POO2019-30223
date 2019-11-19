package javasmmr.zoowsome.models;
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
	
	public Monkey()
	{
		this.name = "Paleologul";
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
			double newDanger = 0;
		    newDanger = this.getDangerPerc() + extraPercentage;
			
		   if(newDanger >= 1)
			   this.setDangerPerc(1);
		   else
		       this.setDangerPerc(this.getDangerPerc() + extraPercentage);
		}
		return this.getDangerPerc();
	}
}
