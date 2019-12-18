package javasmmr.zoowsome.repositories;
import org.w3c.dom.Element;
import javasmmr.zoowsome.models.*;
import javasmmr.zoowsome.services.Constants;

public class AnimalRepository extends EntityRepository<Animal> 
{
	public AnimalRepository(String filename, String tag) 
	{
		super(filename, tag);
	}

	protected Animal getEntityFromXMLElement(Element element) 
	{
		String discriminant = element.getElementsByTagName(Constants.XML_TAGS.DISCRIMINANT).item(0).getTextContent();
		switch (discriminant) 
		{
		case Constants.Animals.Insects.Butterfly: 
		{
			Animal butterfly = new Butterfly();
			butterfly.decodeFromXml(element);
			return butterfly;
		}

		case Constants.Animals.Reptiles.Chameleon: 
		{
			Animal chameleon = new Chameleon();
			chameleon.decodeFromXml(element);
			return chameleon;
		}

		case Constants.Animals.Aquatics.Clownfish: 
		{
			Animal clownfish = new Clownfish();
			clownfish.decodeFromXml(element);
			return clownfish;
		}

		case Constants.Animals.Insects.Cockroach: 
		{
			Animal cockroach = new Cockroach();
			cockroach.decodeFromXml(element);
			return cockroach;
		}

		case Constants.Animals.Birds.Colibri: 
		{
			Animal colibri = new Colibri();
			colibri.decodeFromXml(element);
			return colibri;
		}

		case Constants.Animals.Mammals.Cow: 
		{
			Animal cow = new Cow();
			cow.decodeFromXml(element);
			return cow;
		}

		case Constants.Animals.Reptiles.Gecko: 
		{
			Animal gecko = new Gecko();
			gecko.decodeFromXml(element);
			return gecko;
		}

		case Constants.Animals.Reptiles.Iguana: 
		{
			Animal iguana = new Iguana();
			iguana.decodeFromXml(element);
			return iguana;
		}

		case Constants.Animals.Birds.Kiwi: 
		{
			Animal kiwi = new Kiwi();
			kiwi.decodeFromXml(element);
			return kiwi;
		}

		case Constants.Animals.Mammals.Monkey: 
		{
			Animal monkey = new Monkey();
			monkey.decodeFromXml(element);
			return monkey;
		}

		case Constants.Animals.Birds.Penguin: 
		{
			Animal penguin = new Penguin();
			penguin.decodeFromXml(element);
			return penguin;
		}

		case Constants.Animals.Aquatics.Salamander: 
		{
			Animal salamander = new Salamander();
			salamander.decodeFromXml(element);
			return salamander;
		}

		case Constants.Animals.Aquatics.Seahorse: 
		{
			Animal seahorse = new Seahorse();
			seahorse.decodeFromXml(element);
			return seahorse;
		}

		case Constants.Animals.Insects.Spider: 
		{
			Animal spider = new Spider();
			spider.decodeFromXml(element);
			return spider;
		}

		case Constants.Animals.Mammals.Tiger: 
		{
			Animal tiger = new Tiger();
			tiger.decodeFromXml(element);
			return tiger;
		}

		default: break;
		}
		return null;
	}
}
