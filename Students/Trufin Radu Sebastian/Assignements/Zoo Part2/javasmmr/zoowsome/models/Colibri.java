package javasmmr.zoowsome.models;

public class Colibri extends Bird 
{
	public Colibri(Integer nrOfLegs, String name, boolean migrates, Integer avgFlightAltitude,
			boolean takenCareOf, double maintenanceCost, double dangerPerc) 
	{
		super(nrOfLegs, name, migrates, avgFlightAltitude, takenCareOf, maintenanceCost, dangerPerc);
	}
	
	public Colibri()
	{
		this.name = "Eugenia";
		this.migrates = false;
		this.avgFlightAltitude = 10;
		this.nrOfLegs = 2;
	}
	
	public double getPredisposition()
	{
		return this.dangerPerc;
	}

}
