package javasmmr.zoowsome.models;
import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;
import java.lang.Math;
import org.w3c.dom.Element;

public abstract class Mammal extends Animal 
{
	double normalBodyTemp;
	double percBodyHair;
	
	public Mammal(Integer nrOfLegs, String name, float normalBodyTemp, float percBodyHair,
			boolean takenCareOf, double maintenanceCost, double dangerPerc) 
	{
		super(nrOfLegs, name, takenCareOf, maintenanceCost, dangerPerc);
		this.normalBodyTemp = normalBodyTemp;
		this.percBodyHair = percBodyHair;
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException 
	{
		super.encodeToXml(eventWriter);
		createNode(eventWriter, "normalBodyTemp", String.valueOf(getNormalBodyTemperature()));
		createNode(eventWriter, "percBodyHair", String.valueOf(getPercBodyHair()));
	}
	
	public void decodeFromXml(Element element) 
	{
		setTakenCareOf(Boolean.valueOf(element.getElementsByTagName("normalBodyTemp").item(0).getTextContent()));
		setTakenCareOf(Boolean.valueOf(element.getElementsByTagName("percBodyHair").item(0).getTextContent()));
	}	
	
	public Mammal()
	{
		this.name = "<Unknown Mammal>";
	}
	
	public void setPercBodyHair(float percBodyHair)
	{
		this.percBodyHair = percBodyHair;
	}
	
	public void setBodyTemperature(float normalBodyTemp)
	{
		this.normalBodyTemp = normalBodyTemp;
	}
	
	public float getNormalBodyTemperature()
	{
		return (float) (Math.floor(this.normalBodyTemp * 100)/100);
	}
	
	public float getPercBodyHair()
	{
		return (float) (Math.floor(this.percBodyHair * 100)/100);
	}
}
