package javasmmr.zoowsome.models;

public class Penguin extends Bird 
{
	public Penguin(Integer nrOfLegs, String name, boolean migrates, Integer avgFlightAltitude,
			boolean takenCareOf, double maintenanceCost, double dangerPerc) 
	{
		super(nrOfLegs, name, migrates, avgFlightAltitude, takenCareOf, maintenanceCost, dangerPerc);
	}
	
	public Penguin()
	{
		this.name = "Happy Feet";
		this.avgFlightAltitude = 0;
		this.migrates = false;
		this.nrOfLegs = 2;
	}
	
	public double getPredisposition()
	{
		return this.dangerPerc;
	}
}
