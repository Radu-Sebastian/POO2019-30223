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
		Random r = new Random();
		
		String[] ColibriNames = new String[] { "Rumplesnakeskin", "Merlin", "Marcel", "Laur", "Mutu", "Pomelo",
				"Israel", "Omar", "Hassan", "El Zorab" };
		
		String[] KiwiNames = new String[] { "King", "Shakespeare", "Alduin", "Lodi", "Botezatu", "Grindeanu",
				"Chowder", "Yoda", "Mirel", "Ajax" };
		
		String[] PenguinNames = new String[] { "Snip", "Snap", "Dorian", "Robert", "Varga", "Dexter",
				"Goblin", "Romulus", "Yoshi", "Honda" };
		
		int randColibriName = r.nextInt(ColibriNames.length);
		int randKiwiName = r.nextInt(KiwiNames.length);
		int randPenguinName = r.nextInt(PenguinNames.length);
		
		double randDanger = Math.random();
		double randMaintenance = Math.random() * 8;
	    boolean randCareOf = r.nextBoolean();
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