package javasmmr.zoowsome.models;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;
import org.w3c.dom.Element;
import javasmmr.zoowsome.services.Constants;
import static javasmmr.zoowsome.repositories.EntityRepository.createNode;
import java.time.LocalTime;

public class Spider extends Insect
{
	public Spider(Integer nrOfLegs, String name, boolean canFly, boolean isDangerous,
			boolean takenCareOf, double maintenanceCost, double dangerPerc) 
	{
		super(nrOfLegs, name, canFly, isDangerous, takenCareOf, maintenanceCost, dangerPerc);
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException 
	{
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT,
		Constants.Animals.Insects.Spider);
	}
	
	public Spider()
	{
		this.name = "Lucas";
		this.canFly = false;
		this.isDangerous = true;
		this.nrOfLegs = 8;
	}
	
	public double getPredisposition()
	{
		LocalTime startTime = LocalTime.parse("01:00:00");
		LocalTime endTime = LocalTime.parse("09:00:00");
		LocalTime t = LocalTime.now();
		if(t.isAfter(startTime) && t.isBefore(endTime))
		{
		   this.setDangerPerc(this.getDangerPerc() + 0.25);
		}
		return (float) (Math.floor(this.dangerPerc * 100)/100);
	}

	@Override
	public void decodeFromXml(Element element) {
		// TODO Auto-generated method stub
		
	}
}
