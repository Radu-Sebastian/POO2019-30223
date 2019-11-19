package javasmmr.zoowsome.models;

public class Clownfish extends Aquatic 
{
	public Clownfish(Integer nrOfLegs, String name, Integer avgSwimDepth, waterType livesIn,
			boolean takenCareOf, double maintenanceCost, double dangerPerc)
	{
		super(nrOfLegs, name, avgSwimDepth, livesIn, takenCareOf, maintenanceCost, dangerPerc);
	}
	
	public Clownfish()
	{
		this.name = "Nemo";
		this.nrOfLegs = 0;
		this.avgSwimDepth = 250;
	}
	
	public double getPredisposition()
	{
		return this.dangerPerc;
	}
}
