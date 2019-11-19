package javasmmr.zoowsome.models;

public class Butterfly extends Insect
{
	public Butterfly(Integer nrOfLegs, String name, boolean canFly, boolean isDangerous,
			boolean takenCareOf, double maintenanceCost, double dangerPerc) 
	{
		super(nrOfLegs, name, canFly, isDangerous, takenCareOf, maintenanceCost, dangerPerc);
	}
	
	public Butterfly()
	{
		this.name = "Lepidoptera";
		this.nrOfLegs = 6;
		this.canFly = true;
		this.isDangerous = false;
	}
	
	public double getPredisposition()
	{
		return this.dangerPerc;
	}
}
