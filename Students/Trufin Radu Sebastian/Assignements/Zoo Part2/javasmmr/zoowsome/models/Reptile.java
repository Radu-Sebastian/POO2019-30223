package javasmmr.zoowsome.models;

public abstract class Reptile extends Animal 
{
	Boolean laysEggs;

	public Reptile(Integer nrOfLegs, String name, boolean laysEggs,
			boolean takenCareOf, double maintenanceCost, double dangerPerc) 
	{
		super(nrOfLegs, name, takenCareOf, maintenanceCost, dangerPerc);
		this.laysEggs = laysEggs;
	}
	
	public Reptile()
	{
		this.name = "<Unknown name>";
	}
	
	public void setEggsLayed(Boolean laysEggs)
	{
		this.laysEggs = laysEggs;
	}
	
	public Boolean isLayingEggs()
	{
		return this.laysEggs;
	}
}
