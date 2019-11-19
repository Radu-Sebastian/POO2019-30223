package javasmmr.zoowsome.models;

public abstract class Animal implements Killer
{
	public Integer nrOfLegs;
	public String name;
	public final double maintenanceCost;
	public double dangerPerc;
	public boolean takenCareOf;
	
	public boolean kill()
	{
		double rand = Math.random();
        if(rand < this.dangerPerc)
        	return true;
        else return false;
	}
	
	public double getPredisposition()
	{
		return 0;
	}
	
	public double getDangerPerc()
	{
		return this.dangerPerc;
	}
	
	public double getMaintenanceCost()
	{
		return this.maintenanceCost;
	}
	
	public boolean getTakenCareOf()
	{
		return this.takenCareOf;
	}
	
	public void setTakenCareOf(boolean bit)
	{
		this.takenCareOf = bit;
	}
	
	public void setDangerPerc(double dangerPerc)
	{
		this.dangerPerc = dangerPerc;
	}
	
	public Animal()
	{
		this.nrOfLegs = 0;
	    this.name = "<Unknown Animal>";
	    this.takenCareOf = false;
	    this.maintenanceCost = 0;
	    this.dangerPerc = 0;
	}
	
	public Animal(Integer nrOfLegs, String name, boolean takenCareOf,
			double maintenanceCost, double dangerPerc)
	{
		this.nrOfLegs = nrOfLegs;
		this.name = name;
		this.takenCareOf = takenCareOf;
		this.maintenanceCost = maintenanceCost;
		this.dangerPerc = dangerPerc + this.getPredisposition();
	}
	
	public void setNrOfLegs(Integer k)
	{
		this.nrOfLegs = k;
	}
	
	public Integer getNrOfLegs()
	{
		return this.nrOfLegs;
	}
	
	public void setName(String s)
	{
		this.name = s;
	}
	
	public String getName()
	{
		return this.name;
	}
}
