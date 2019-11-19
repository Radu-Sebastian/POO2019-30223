package javasmmr.zoowsome.services;
import javasmmr.zoowsome.employees.Employee;

public abstract class EmployeeAbstractFactory 
{
	public abstract Employee getEmployeeFactory(String type) throws Exception;
}
