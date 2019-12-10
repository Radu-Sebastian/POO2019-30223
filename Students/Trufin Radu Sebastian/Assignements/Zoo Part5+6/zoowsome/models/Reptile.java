package javasmmr.zoowsome.models;
import static javasmmr.zoowsome.repositories.EntityRepository.createNode;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

public abstract class Reptile extends Animal 
{
	Boolean laysEggs;

	public Reptile(Integer nrOfLegs, String name, boolean laysEggs,
			boolean takenCareOf, double maintenanceCost, double dangerPerc) 
	{
		super(nrOfLegs, name, takenCareOf, maintenanceCost, dangerPerc);
		this.laysEggs = laysEggs;
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException 
	{
		super.encodeToXml(eventWriter);
		createNode(eventWriter, "laysEggs", String.valueOf(isLayingEggs()));
	}
	
	public void decodeFromXml(Element element) 
	{
		super.decodeFromXml(element);
		setEggsLayed(Boolean.valueOf(element.getElementsByTagName("laysEggs").item(0).getTextContent()));
	}

	public void setEggsLayed(Boolean laysEggs)
	{
		this.laysEggs = laysEggs;
	}
	
	public Boolean isLayingEggs()
	{
		return this.laysEggs;
	}
}
