package javasmmr.zoowsome.employees;
import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

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
	
	public Caretaker()
	{
		this.setName("<Unknown Caretaker>");
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException 
	{
		super.encodeToXml(eventWriter);
		createNode(eventWriter, "workingHours", String.valueOf(getWorkingHours()));
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
		return Math.floor(workingHours * 100)/100;
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
