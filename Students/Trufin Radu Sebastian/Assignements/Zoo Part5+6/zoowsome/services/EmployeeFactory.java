package javasmmr.zoowsome.services;

public class EmployeeFactory 
{
	  public EmployeeAbstractFactory getEmployeeFactory(String type) throws Exception
	  {
		  if(Constants.EmployeeTypes.Caretakers.equals(type))
			  return new CaretakerFactory();
		  else throw new Exception("Invalid species exception");
	  }
}
