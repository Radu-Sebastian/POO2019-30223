package javasmmr.zoowsome.employees;
import static javasmmr.zoowsome.repositories.EntityRepository.createNode;
import java.util.UUID;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;
import org.w3c.dom.Element;
import javasmmr.zoowsome.models.interfaces.XML_Parsable;

public abstract class Employee implements XML_Parsable
{
	private String name;
	private String id;
	private boolean isDead;
	private double salary;
	
	public Employee(String name, boolean isDead, double salary)
	{
		this.name = name;
		this.id = String.valueOf((long) (Math.floor(UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE)/ 1e12));
		this.isDead = isDead;
		this.salary = Math.floor(salary * 100)/100;
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException 
	{
		createNode(eventWriter, "id", String.valueOf(this.id));
		createNode(eventWriter, "name", String.valueOf(this.name));
		createNode(eventWriter, "isDead", String.valueOf(this.isDead));
		createNode(eventWriter, "salary", String.valueOf(this.salary));
	}
	
	public void decodeFromXml(Element element) 
	{
		setID(String.valueOf(element.getElementsByTagName("id").item(0).getTextContent()));
		setName(element.getElementsByTagName("name").item(0).getTextContent());
		setDeath(Boolean.valueOf(element.getElementsByTagName("isDead").item(0).getTextContent()));
		setSalary(Double.valueOf(element.getElementsByTagName("salary").item(0).getTextContent()));
	}
	
	public Employee()
	{
		this.id = String.valueOf(UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE);
		this.isDead = false;
		this.name = "<Unknown Name>";
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getID()
	{
		return this.id;
	}
	
	public boolean getDeath()
	{
		return this.isDead;
	}
	
	public double getSalary()
	{
		return Math.floor(this.salary * 100)/100;
	}
	
	public void setSalary(double salary)
	{
		this.salary = Math.floor(salary * 100)/100;
	}
	
	public void setDeath(boolean isDead)
	{
		this.isDead = isDead;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setID(String id)
	{
		this.id = id;
	}
}
