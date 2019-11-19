package javasmmr.zoowsome.models;
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
	
	Tiger()
	{
		this.name = "Vlad Rusu";
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
		LocalTime endTime = LocalTime.parse("20:00:00");
		LocalTime t = LocalTime.now();
		if(t.isAfter(startTime) && t.isBefore(endTime))
		{
			double newDanger = 0;
			if(dayOfWeek == 4)
		        newDanger = this.getDangerPerc() + extraPercentage;
			else
			{
				extraPercentage = extraPercentage + 0.05;
				newDanger = this.getDangerPerc() + extraPercentage;
			}
		   
		   if(newDanger >= 1)
			   this.setDangerPerc(1);
		   else
		       this.setDangerPerc(this.getDangerPerc() + extraPercentage);
		}
		
		return this.getDangerPerc();
	}
}
