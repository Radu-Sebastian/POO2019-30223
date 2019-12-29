package javastreams10;

public class Employee 
{
	String name;
	int age;
	double salary;
	
	Employee(String name, int age, double salary)
	{
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	
	String getName()
	{
		return this.name;
	}
	
	double getSalary()
	{
		return this.salary;
	}
	
	int getAge()
	{
		return this.age;
	}	
}
