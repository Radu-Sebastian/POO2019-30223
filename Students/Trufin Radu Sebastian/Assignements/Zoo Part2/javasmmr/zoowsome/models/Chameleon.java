package javasmmr.zoowsome.models;

public class Chameleon extends Reptile 
{
	public Chameleon(Integer nrOfLegs, String name, boolean laysEggs,
			boolean takenCareOf, double maintenanceCost, double dangerPerc) 
	{
		super(nrOfLegs, name, laysEggs, takenCareOf, maintenanceCost, dangerPerc);
	}
	
	public Chameleon()
	{
		this.name = "Oedipus";
		this.laysEggs = true;
		this.nrOfLegs = 2;
	}
	
	public double getPredisposition()
	{
		return this.dangerPerc;
	}

}
