package javasmmr.zoowsome.models;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;

public abstract class Insect extends Animal
{
	Boolean canFly;
	Boolean isDangerous;
	
	public Insect(Integer nrOfLegs, String name, boolean canFly, boolean isDangerous,
			boolean takenCareOf, double maintenanceCost, double dangerPerc) 
	{
		super(nrOfLegs, name, takenCareOf, maintenanceCost, dangerPerc);
		this.canFly = canFly;
		this.isDangerous = isDangerous;
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException 
	{
		super.encodeToXml(eventWriter);
		createNode(eventWriter, "canFly", String.valueOf(Flies()));
		createNode(eventWriter, "isDangerous", String.valueOf(Endanger()));
	}
	
	public void decodeFromXml(Element element) 
	{
		setTakenCareOf(Boolean.valueOf(element.getElementsByTagName("canFly").item(0).getTextContent()));
		setTakenCareOf(Boolean.valueOf(element.getElementsByTagName("isDangerous").item(0).getTextContent()));
	}
	
	public Insect()
	{
		this.name = "<Unknown name>";
	}
	
	public void setFly(boolean canFly)
	{
		this.canFly = canFly;
	}
	
	public void setDanger(boolean isDangerous)
	{
		this.isDangerous = isDangerous;
	}
	
	public Boolean Flies()
	{
		return this.canFly;
	}
	
	public Boolean Endanger()
	{
		return this.isDangerous;
	}	
}
