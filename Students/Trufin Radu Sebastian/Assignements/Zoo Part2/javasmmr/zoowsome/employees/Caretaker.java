package javasmmr.zoowsome.employees;
import javasmmr.zoowsome.models.Animal;
import javasmmr.zoowsome.services.Constants;

public class Caretaker extends Employee implements Caretaker_I
{
	private double workingHours;
	
	public Caretaker(String name, boolean isDead, double salary,
			 double workingHours)
	{
		super(name,isDead,salary);
		this.workingHours = workingHours;
	}
	
	public String toString()
	{
		String formatSalariu = String.format("%.02f",this.getSalary());
		String formatOre = String.format("%.02f",this.getWorkingHours());
		return("Caretaker " + this.getName() + " with the salary of " + formatSalariu + 
		" and " + formatOre + " working hours is dead? : " + this.getDeath());
	}
	
	public void print()
	{
		System.out.println(toString());
	}
	
	public double getWorkingHours() 
	{
		return workingHours;
	}

	public void setWorkingHours(double workingHours) 
	{
		this.workingHours = workingHours;
	}

	public String takeCareOf(Animal animal) 
	{
		if(animal.kill())
		{
			return Constants.Employees.Caretakers.TCO_KILLED;
		}
		
		if(this.workingHours < animal.getMaintenanceCost())
		{
			return Constants.Employees.Caretakers.TCO_NO_TIME;
		}
		
		animal.takenCareOf = true;
		this.workingHours = this.workingHours - animal.maintenanceCost;
		
		return Constants.Employees.Caretakers.TCO_SUCCES;
	}
}
