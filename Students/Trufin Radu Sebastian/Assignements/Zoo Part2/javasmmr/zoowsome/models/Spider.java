package javasmmr.zoowsome.models;
import java.time.LocalTime;

public class Spider extends Insect
{
	public Spider(Integer nrOfLegs, String name, boolean canFly, boolean isDangerous,
			boolean takenCareOf, double maintenanceCost, double dangerPerc) 
	{
		super(nrOfLegs, name, canFly, isDangerous, takenCareOf, maintenanceCost, dangerPerc);
	}
	
	public Spider()
	{
		this.name = "Lucas";
		this.canFly = false;
		this.isDangerous = true;
		this.nrOfLegs = 8;
	}
	
	public double getPredisposition()
	{
		LocalTime startTime = LocalTime.parse("01:00:00");
		LocalTime endTime = LocalTime.parse("09:00:00");
		LocalTime t = LocalTime.now();
		if(t.isAfter(startTime) && t.isBefore(endTime))
		{
		   this.setDangerPerc(this.getDangerPerc() + 0.25);
		}
		return this.dangerPerc;
	}
}
