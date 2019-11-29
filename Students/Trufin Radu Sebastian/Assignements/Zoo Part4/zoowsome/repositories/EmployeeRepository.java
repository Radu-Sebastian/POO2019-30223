package javasmmr.zoowsome.repositories;
import org.w3c.dom.Element;
import javasmmr.zoowsome.employees.Caretaker;
import javasmmr.zoowsome.employees.Employee;
import javasmmr.zoowsome.services.Constants;

public class EmployeeRepository extends EntityRepository<Employee> 
{
	public EmployeeRepository(String filename, String tag) 
	{
		super(filename, tag);
	}

	protected Employee getEntityFromXmlElement(Element element) 
	{
	     String discriminant = element.getElementsByTagName(Constants.XML_TAGS.DISCRIMINANT).item(0)
	     .getTextContent();	
	     try 
	     {
		    switch (discriminant) 
		      {
		         case Constants.EmployeeTypes.Caretakers:
			        Employee caretaker = new Caretaker();
		            caretaker.decodeFromXml(element);
		            break;
		        }
		  }
		   catch(NullPointerException e) {}
		return null;
	}

	protected Employee getEntityFormXMLElement(Element element) 
	{
		return null;
	}
}		        

