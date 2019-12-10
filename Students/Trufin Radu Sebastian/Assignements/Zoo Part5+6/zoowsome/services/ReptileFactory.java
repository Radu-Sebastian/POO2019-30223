package javasmmr.zoowsome.services;
import java.util.Random;
import javasmmr.zoowsome.models.Animal;
import javasmmr.zoowsome.models.Chameleon;
import javasmmr.zoowsome.models.Gecko;
import javasmmr.zoowsome.models.Iguana;

public class ReptileFactory extends SpeciesFactory 
{
	public Animal getAnimal(String type) throws Exception
	{
		Random r = new Random();
		
		String[] ChameleonNames = new String[] { "Rumplesnakeskin", "Merlin", "Marcel", "Laur", "Mutu", "Pomelo",
				"Israel", "Omar", "Hassan", "El Zorab" };
		
		String[] GeckoNames = new String[] { "King", "Shakespeare", "Alduin", "Lodi", "Botezatu", "Grindeanu",
				"Chowder", "Yoda", "Mirel", "Ajax" };
		
		String[] IguanaNames = new String[] { "Snip", "Snap", "Dorian", "Robert", "Varga", "Dexter",
				"Goblin", "Romulus", "Yoshi", "Honda" };
		
		int randChameleonName = r.nextInt(ChameleonNames.length);
		int randGeckoName = r.nextInt(GeckoNames.length);
		int randIguanaName = r.nextInt(IguanaNames.length);
		
		double randDanger = Math.random();
		double randMaintenance = Math.random() * 8;
	    boolean randCareOf = r.nextBoolean();
	    randDanger = Math.floor(randDanger * 100)/100;
	    randMaintenance = Math.floor(randMaintenance * 100)/100;
		
		if(Constants.Animals.Reptiles.Chameleon.equals(type))
			return new Chameleon(4,ChameleonNames[randChameleonName],true,randCareOf,randMaintenance,randDanger);
		else if (Constants.Animals.Reptiles.Gecko.equals(type))
            return new Gecko(4,GeckoNames[randGeckoName],true,randCareOf,randMaintenance,randDanger);
        else if (Constants.Animals.Reptiles.Iguana.equals(type))
            return new Iguana(4,IguanaNames[randIguanaName],true,randCareOf,randMaintenance,randDanger);
        else
        	throw new Exception ("Invalid animal exception");
	}
}