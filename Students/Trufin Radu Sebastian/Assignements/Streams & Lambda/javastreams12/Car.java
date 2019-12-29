package javastreams12;

public class Car
{
	String brand;
	int yearOfFabrication;
	String colour;
	Double price;
	
	Car(String brand, int yearOfFabrication, String colour, Double price)
	{
		this.brand = brand;
		this.yearOfFabrication = yearOfFabrication;
		this.colour = colour;
		this.price = price;
	}
	
	String getBrand()
	{
		return this.brand;
	}
	
	int getYearOfFabrication()
	{
		return this.yearOfFabrication;
	}
	
	String getColour()
	{
		return this.colour;
	}	
	
	Double getPrice()
	{
		return this.price;
	}
	
	public String toString()
	{
		return (this.brand + " " + this.price);
	}
}
