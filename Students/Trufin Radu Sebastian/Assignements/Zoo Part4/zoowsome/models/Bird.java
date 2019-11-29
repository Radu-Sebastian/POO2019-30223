package javasmmr.zoowsome.models;
import static javasmmr.zoowsome.repositories.EntityRepository.createNode;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;
import org.w3c.dom.Element;

public abstract class Bird extends Animal 
{
	public Boolean migrates;
	public Integer avgFlightAltitude;
	
	public Bird(Integer nrOfLegs, String name, boolean migrates, Integer avgFlightAltitude,
			boolean takenCareOf, double maintenanceCost, double dangerPerc) 
	{
		super(nrOfLegs, name, takenCareOf, maintenanceCost, dangerPerc);
		this.migrates = migrates;
		this.avgFlightAltitude = avgFlightAltitude;
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException 
	{
		super.encodeToXml(eventWriter);
		createNode(eventWriter, "migrates", String.valueOf(getMigrate()));
		createNode(eventWriter, "avgFlightAltitude", String.valueOf(getAvgFlightAltitude()));
	}
	
	public void decodeFromXml(Element element) 
	{
		setTakenCareOf(Boolean.valueOf(element.getElementsByTagName("migrates").item(0).getTextContent()));
		setTakenCareOf(Boolean.valueOf(element.getElementsByTagName("avgFlightAltitude").item(0).getTextContent()));
	}	
	
	public Bird()
	{
		this.name = "<Unknown Bird>";
	}
	
	public void setMigrate(boolean migrates)
	{
		this.migrates = migrates;
	}
	
	public void setAvgFlightAltitude(Integer avgFlightAltitude) 
	{
		this.avgFlightAltitude = avgFlightAltitude;
	}
	
	public Boolean getMigrate()
	{
		return this.migrates;
	}
	
	public Integer getAvgFlightAltitude()
	{
		return this.avgFlightAltitude;
	}
	
	public double getPredisposition()
	{
		return (float) (Math.floor(this.dangerPerc * 100)/100);
	}
}
