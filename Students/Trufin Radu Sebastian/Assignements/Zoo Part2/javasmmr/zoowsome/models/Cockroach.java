package javasmmr.zoowsome.models;

public class Cockroach extends Insect 
{
	public Cockroach(Integer nrOfLegs, String name, boolean canFly, boolean isDangerous,
			boolean takenCareOf, double maintenanceCost, double dangerPerc) 
	{
		super(nrOfLegs, name, canFly, isDangerous, takenCareOf, maintenanceCost, dangerPerc);
	}
	
	public Cockroach()
	{
		this.name = "Caminar";
		this.canFly = true;
		this.isDangerous = false;
	}
	
	public double getPredisposition()
	{
		return this.dangerPerc;
	}

}
