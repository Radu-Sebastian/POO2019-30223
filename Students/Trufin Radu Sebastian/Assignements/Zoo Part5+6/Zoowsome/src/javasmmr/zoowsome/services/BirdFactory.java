package javasmmr.zoowsome.services;
import java.util.Random;
import javasmmr.zoowsome.models.Animal;
import javasmmr.zoowsome.models.Kiwi;
import javasmmr.zoowsome.models.Penguin;
import javasmmr.zoowsome.models.Colibri;

public class BirdFactory extends SpeciesFactory 
{
	public Animal getAnimal(String type) throws Exception
	{
		Random randomizer = new Random();
		
		String[] ColibriNames = new String[] {"Radu", "Merlin", "Marcel", "Laur", "Mutu", "Pomelo",
				"Israel", "Omar", "Hassan", "El Zorab", "Spiraan", "Stinegat", "Mosqicadea",
				"Soustoon", "Moxoceros", "Darrilla"};
		
		String[] KiwiNames = new String[] {"King", "Shakespeare", "Alduin", "Lodi", "Botezatu", "Grindeanu",
				"Chowder", "Yoda", "Mirel", "Ajax", "Qostetopus", "Luqecea", "Greodoomo", "Alleleon",
				"Buffitar", "Jaguflam", "Hexaurrimea"};
		
		String[] PenguinNames = new String[] {"Snip", "Snap", "Dorian", "Robert", "Varga", "Dexter",
				"Goblin", "Romulus", "Yoshi", "Honda", "Gloxeleon", "Goocsadger", "Wekeabug",
				"Weopecker", "Reastatee", "Kisoc", "Albingo"};
		
		int randColibriName = randomizer.nextInt(ColibriNames.length);
		int randKiwiName = randomizer.nextInt(KiwiNames.length);
		int randPenguinName = randomizer.nextInt(PenguinNames.length);
		
		double randDanger = Math.random();
		double randMaintenance = Math.random() * 8;
	    boolean randCareOf = randomizer.nextBoolean();
	    randDanger = Math.floor(randDanger * 100)/100;
	    randMaintenance = Math.floor(randMaintenance * 100)/100;
	    
		if(Constants.Animals.Birds.Colibri.equals(type))
			return new Colibri(4,ColibriNames[randColibriName],false,100,randCareOf,randMaintenance,randDanger);
		else if (Constants.Animals.Birds.Kiwi.equals(type))
            return new Kiwi(4,KiwiNames[randKiwiName],true,0,randCareOf,randMaintenance,randDanger);
        else if (Constants.Animals.Birds.Penguin.equals(type))
            return new Penguin(4,PenguinNames[randPenguinName],false,0,randCareOf,randMaintenance,randDanger);
        else
        	throw new Exception ("Invalid animal exception");
	}
}