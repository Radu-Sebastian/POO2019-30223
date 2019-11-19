package javasmmr.zoowsome.models;

public class Gecko extends Reptile 
{
	public Gecko(Integer nrOfLegs, String name, boolean laysEggs,
			boolean takenCareOf, double maintenanceCost, double dangerPerc) 
	{
		super(nrOfLegs, name, laysEggs,takenCareOf,maintenanceCost,dangerPerc);
	}
	
	public Gecko() 
	{
		this.name = "Palmoliviu";
		this.laysEggs = true;
		this.nrOfLegs = 4;
	}
	
	public double getPredisposition()
	{
		return this.dangerPerc;
	}
}
