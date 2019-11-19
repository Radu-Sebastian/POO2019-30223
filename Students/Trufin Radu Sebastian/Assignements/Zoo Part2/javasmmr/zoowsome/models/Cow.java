package javasmmr.zoowsome.models;
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
	
	public Cow()
	{
		this.name = "Jiuncutza";
		this.normalBodyTemp = (float) 38.6;
		this.percBodyHair = 5;
		this.nrOfLegs = 4;
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
		   this.setDangerPerc(this.getDangerPerc() + extraPercentage);
		}
		return this.dangerPerc;
	}	
}
