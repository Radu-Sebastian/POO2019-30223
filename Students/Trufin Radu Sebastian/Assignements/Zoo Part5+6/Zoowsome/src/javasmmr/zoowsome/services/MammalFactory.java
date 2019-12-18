package javasmmr.zoowsome.services;
import java.util.Random;
import javasmmr.zoowsome.models.Animal;
import javasmmr.zoowsome.models.Cow;
import javasmmr.zoowsome.models.Tiger;
import javasmmr.zoowsome.models.Monkey;

public class MammalFactory extends SpeciesFactory 
{
	public Animal getAnimal(String type) throws Exception
	{
		Random randomizer = new Random();
		
		String[] cowNames = new String[] {"Jiuncutza", "Viorica", "Minodora", "Daisy", "Bumba", "Pamela",
				"Moscova", "Paula", "Pudding", "Esmeralda", "Norrox", "Azovuarr", "Ruajatt", 
				"Khume", "Dawa", "Yeazavo",  "Namaene", "Jothe", "Tuse", "Axinex"};
		
		String[] tigerNames = new String[] {"Pavel", "Ninja", "Sanchez", "Maluma", "Garfield", "Tom",
				"Pisi", "Felix", "Geany", "Catarina", "Smokepaw", "Cinderbelly", "Shortspring", 
				"Hazelstar", "Talon", "Bardon", "Oldrich", "Thistle", "Arausio"};
		
		String[] monkeyNames = new String[] {"Thaddius", "Duras", "Usher", "Salvadore", "Keanu", "Murcielago",
				"Claudiu", "Ashley", "Lukaku", "Desmond", "Bollush", "Millunish", "Anzutom", 
				"Djukkic", "Onokol", "Umus", "Gyomatu", "Erash", "Umars", "Photsihuth"};
		
		int randCowName = randomizer.nextInt(cowNames.length);
		int randTigerName = randomizer.nextInt(tigerNames.length);
		int randMonkeyName = randomizer.nextInt(tigerNames.length);
		
		float bodyTemp = 6 * randomizer.nextFloat() + 35;
		float bodyHairPercent =  100 * randomizer.nextFloat();
		
		double randDanger = randomizer.nextDouble();
		double randMaintenance = Math.random() * 8;
	    boolean randCareOf = randomizer.nextBoolean();
	    randDanger = Math.floor(randDanger * 100)/100;
	    randMaintenance = Math.floor(randMaintenance * 100)/100;
	  
		if(Constants.Animals.Mammals.Cow.equals(type))
			return new Cow(4,cowNames[randCowName],bodyTemp,bodyHairPercent,randCareOf,randMaintenance,randDanger);
		else if (Constants.Animals.Mammals.Tiger.equals(type))
            return new Tiger(2,tigerNames[randTigerName],bodyTemp,bodyHairPercent,randCareOf,randMaintenance,randDanger);
        else if (Constants.Animals.Mammals.Monkey.equals(type))
            return new Monkey(2,monkeyNames[randMonkeyName],bodyTemp,bodyHairPercent,randCareOf,randMaintenance,randDanger);
        else
        	throw new Exception ("Invalid animal exception");
	}
}
