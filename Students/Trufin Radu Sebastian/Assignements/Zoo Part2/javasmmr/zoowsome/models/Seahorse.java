package javasmmr.zoowsome.models;

public class Seahorse extends Aquatic 
{
	public Seahorse(Integer nrOfLegs, String name, Integer avgSwimDepth, waterType livesIn,
			boolean takenCareOf, double maintenanceCost, double dangerPerc)
	{
		super(nrOfLegs, name, avgSwimDepth, livesIn, takenCareOf, maintenanceCost, dangerPerc);
	}

	public Seahorse()
	{
		this.name = "Murgu";
		this.nrOfLegs = 0;
		this.avgSwimDepth = 500;
	}
	
	public double getPredisposition()
	{
		return this.dangerPerc;
	}
}
