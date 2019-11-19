package javasmmr.zoowsome.models;

public class Kiwi extends Bird 
{
	public Kiwi(Integer nrOfLegs, String name, boolean migrates, Integer avgFlightAltitude,
			boolean takenCareOf, double maintenanceCost, double dangerPerc) 
	{
		super(nrOfLegs, name, migrates, avgFlightAltitude, takenCareOf, maintenanceCost, dangerPerc);
	}
	
	public Kiwi()
	{
		this.name = "Zalmoxis";
		this.avgFlightAltitude = 0;
		this.migrates = false;
		this.nrOfLegs = 2;
	}
	
	public double getPredisposition()
	{
		return this.dangerPerc;
	}
}
