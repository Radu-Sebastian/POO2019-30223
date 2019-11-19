package javasmmr.zoowsome.models;

import java.time.LocalTime;
import java.util.Calendar;
import java.util.TimeZone;

public class Iguana extends Reptile 
{
	public Iguana(Integer nrOfLegs, String name, boolean laysEggs,
			boolean takenCareOf, double maintenanceCost, double dangerPerc) 
	{
		super(nrOfLegs, name, laysEggs,takenCareOf,maintenanceCost,dangerPerc);
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
		return this.dangerPerc;
	}	
}
