package javasmmr.zoowsome.models;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;
import java.lang.Math;
import org.w3c.dom.Element;
import static javasmmr.zoowsome.repositories.EntityRepository.createNode;
import javasmmr.zoowsome.models.interfaces.XML_Parsable;

public abstract class Animal implements Killer,XML_Parsable
{
	public Integer nrOfLegs;
	public String name;
	public double maintenanceCost;
	public double dangerPerc;
	public boolean takenCareOf;
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException 
	{
		createNode(eventWriter, "nrOfLegs", String.valueOf(this.nrOfLegs));
		createNode(eventWriter, "name", String.valueOf(this.name));
		createNode(eventWriter, "maintenanceCost", String.valueOf(this.maintenanceCost));
		createNode(eventWriter, "dangerPerc", String.valueOf(this.dangerPerc));
		createNode(eventWriter, "takenCareOf", String.valueOf(this.takenCareOf));
	}
	
	public void decodeFromXml(Element element) 
	{
		setNrOfLegs(Integer.valueOf(element.getElementsByTagName("nrOfLegs").item(0).getTextContent()));
		setName(element.getElementsByTagName("name").item(0).getTextContent());
		setMaintenanceCost(Double.valueOf(element.getElementsByTagName("maintenanceCost").item(0).getTextContent()));
		setDangerPerc(Double.valueOf(element.getElementsByTagName("dangerPerc").item(0).getTextContent()));
		setTakenCareOf(Boolean.valueOf(element.getElementsByTagName("takenCareOf").item(0).getTextContent()));
	}
	
	public boolean kill()
	{
		double rand = Math.random();
        if(rand < this.dangerPerc)
        	return true;
        else return false;
	}
	
	public double getPredisposition()
	{
		return (float) (Math.floor(this.dangerPerc * 100)/100);
	}
	
	public double getDangerPerc()
	{
		return (float) (Math.floor(this.dangerPerc * 100)/100);
	}
	
	public double getMaintenanceCost()
	{
		return (float) (Math.floor(this.maintenanceCost * 100)/100);
	}
	
	public boolean getTakenCareOf()
	{
		return this.takenCareOf;
	}
	
	public void setTakenCareOf(boolean bit)
	{
		this.takenCareOf = bit;
	}
	
	public void setDangerPerc(double dangerPerc)
	{
		this.dangerPerc = dangerPerc;
	}
	
	public Animal()
	{
	    this.name = "<Unknown Animal>";
	}
	
	public Animal(Integer nrOfLegs, String name, boolean takenCareOf,
			double maintenanceCost, double dangerPerc)
	{
		this.nrOfLegs = nrOfLegs;
		this.name = name;
		this.takenCareOf = takenCareOf;
		this.maintenanceCost = maintenanceCost;
		this.dangerPerc = Math.floor(dangerPerc*100)/100;
	}
	
	public void setNrOfLegs(Integer k)
	{
		this.nrOfLegs = k;
	}
	
	public Integer getNrOfLegs()
	{
		return this.nrOfLegs;
	}
	
	public void setName(String s)
	{
		this.name = s;
	}
	
	public void setMaintenanceCost(double maintenanceCost)
	{
		this.maintenanceCost = (float) (Math.floor(maintenanceCost * 100)/100);
	}
	
	public String getName()
	{
		return this.name;
	}
}
