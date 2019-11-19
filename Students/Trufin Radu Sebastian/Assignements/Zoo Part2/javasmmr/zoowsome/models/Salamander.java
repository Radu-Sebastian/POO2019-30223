package javasmmr.zoowsome.models;
import java.time.LocalTime;

public class Salamander extends Aquatic 
{
	public Salamander(Integer nrOfLegs, String name, Integer avgSwimDepth, waterType livesIn,
			boolean takenCareOf, double maintenanceCost, double dangerPerc)
	{
		super(nrOfLegs, name, avgSwimDepth, livesIn, takenCareOf, maintenanceCost, dangerPerc);
	}
	
	public Salamander()
	{
		this.name = "Cerasela";
		this.nrOfLegs = 4;
		this.avgSwimDepth = 175;
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
		return this.dangerPerc;
	}
}
