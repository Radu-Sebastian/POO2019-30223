package javasmmr.zoowsome.services;
import java.util.Random;
import javasmmr.zoowsome.models.Animal;
import javasmmr.zoowsome.models.Aquatic;
import javasmmr.zoowsome.models.Seahorse;
import javasmmr.zoowsome.models.Salamander;
import javasmmr.zoowsome.models.Clownfish;

public class AquaticFactory extends SpeciesFactory 
{
	public Animal getAnimal(String type) throws Exception
	{
		Random randomizer = new Random();
		
		String[] SeahorseNames = new String[] {"Odie", "Duke", "Gheorghe", "Mike", "Ralph", "Mordecai",
				"Palestina", "Matteo", "Sandor", "Murgu", "Walypus", "Ostooddorsee", "Gaussule", 
				"Vlextile", "Hyenora", "Komadger", "Gixowary", "Mutauxee"};
		
		String[] SalamanderNames = new String[] {"Leonard", "Chronos", "Kepler", "Rutherford", "Zeus", "Pablo",
				"Alberto", "Richarlison", "G.Ioan", "Esteban", "Xusseetsi", "Eaguin", "Pengarak", 
				"Anteato", "Qourruko",  "Krouleosel", "Eaguin", "Glacoorso"};
		
		String[] ClownfishNames = new String[] {"Nemo", "Zalmodegikos", "Oroles", "Decebal", "Burebista", "Thiamarcos",
				"Deceneu", "Coryllus", "Scorilo", "Koson", "Mulatross", "Bamor", "Xeakodo", 
				"Zudopecker", "Xeakodo", "Walenneta", "Skustreana"};
		
		int randSeahorseName = randomizer.nextInt(SeahorseNames.length);
		int randSalamanderName = randomizer.nextInt(SalamanderNames.length);
		int randClownfishName = randomizer.nextInt(ClownfishNames.length);
		
		int swimDepth = randomizer.nextInt(1000);
		Aquatic.waterType wType[] = {Aquatic.waterType.freshwater, Aquatic.waterType.saltwater};
		int typeOfWater = randomizer.nextInt(2);
		
		double randDanger = Math.random();
		double randMaintenance = Math.random() * 8;
	    boolean randCareOf = randomizer.nextBoolean();
	    randDanger = Math.floor(randDanger * 100)/100;
	    randMaintenance = Math.floor(randMaintenance * 100)/100;

		if(Constants.Animals.Aquatics.Seahorse.equals(type))
			return new Seahorse(0,SeahorseNames[randSeahorseName],swimDepth,wType[typeOfWater],randCareOf,randMaintenance,randDanger);
		else if (Constants.Animals.Aquatics.Salamander.equals(type))
            return new Salamander(4,SalamanderNames[randSalamanderName],swimDepth,wType[typeOfWater],randCareOf,randMaintenance,randDanger);
        else if (Constants.Animals.Aquatics.Clownfish.equals(type))
            return new Clownfish(0,ClownfishNames[randClownfishName],swimDepth,wType[typeOfWater],randCareOf,randMaintenance,randDanger);
        else
        	throw new Exception ("Invalid animal exception");
	}
}