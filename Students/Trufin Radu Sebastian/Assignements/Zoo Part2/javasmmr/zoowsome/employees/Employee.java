package javasmmr.zoowsome.employees;

import java.util.UUID;

public abstract class Employee 
{
	private String name;
	private long id;
	private boolean isDead;
	private double salary;
	
	public Employee(String name, boolean isDead, double salary)
	{
		this.name = name;
		this.id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
		this.isDead = isDead;
		this.salary = salary;
	}
	
	public Employee()
	{
		this.id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
		this.isDead = false;
		this.name = "<Unknown Name>";
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public long getID()
	{
		return this.id;
	}
	
	public boolean getDeath()
	{
		return this.isDead;
	}
	
	public double getSalary()
	{
		return this.salary;
	}
	
	public void setSalary(double salary)
	{
		this.salary = salary;
	}
	
	public void setDeath(boolean isDead)
	{
		this.isDead = isDead;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setID(Long id)
	{
		this.id = id;
	}
	
}
