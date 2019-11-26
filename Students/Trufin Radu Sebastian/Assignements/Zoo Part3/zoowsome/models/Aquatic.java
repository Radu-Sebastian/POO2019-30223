package javasmmr.zoowsome.models;
import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;
import org.w3c.dom.Element;

public abstract class Aquatic extends Animal
{
	public Integer avgSwimDepth;
	public enum waterType {saltwater, freshwater};
	public waterType livesIn;
	
	public Aquatic(Integer nrOfLegs, String name, Integer avgSwimDepth, waterType livesIn,
			boolean takenCareOf, double maintenanceCost, double dangerPerc)
	{
		super(nrOfLegs,name,takenCareOf,maintenanceCost,dangerPerc);
		this.avgSwimDepth = avgSwimDepth;
		this.livesIn = livesIn;
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException 
	{
		super.encodeToXml(eventWriter);
		createNode(eventWriter, "avgSwimDepth", String.valueOf(getAvgSwimDepth() ));
		createNode(eventWriter, "livesIn", String.valueOf(getWaterType()));
	}
	
	public void decodeFromXml(Element element) 
	{
		setTakenCareOf(Boolean.valueOf(element.getElementsByTagName("avgSwimDepth").item(0).getTextContent()));
		setTakenCareOf(Boolean.valueOf(element.getElementsByTagName("livesIn").item(0).getTextContent()));
	}	
	
	public Aquatic()
	{
	    this.name = "<Unknown Aquatic>";
	}
	
	public void setWaterType(waterType livesIn)
	{
		this.livesIn = livesIn;
	}
	
	public void setAvgSwimDepth(Integer avgSwimDepth)
	{
		this.avgSwimDepth = avgSwimDepth;
	}
	
	public waterType getWaterType()
	{
		return this.livesIn;
	}
	
	public Integer getAvgSwimDepth() 
	{
		return this.avgSwimDepth;
	}	
}
