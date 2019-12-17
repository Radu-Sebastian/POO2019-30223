package javasmmr.zoowsome.services;
import java.util.Random;
import javasmmr.zoowsome.models.Animal;
import javasmmr.zoowsome.models.Spider;
import javasmmr.zoowsome.models.Butterfly;
import javasmmr.zoowsome.models.Cockroach;

public class InsectFactory extends SpeciesFactory 
{
	public Animal getAnimal(String type) throws Exception
	{
		Random randomizer = new Random();
		
		String[] ButterflyNames = new String[] {"Icky", "Ozzy", "Nacho", "Faraday", "Rufus", "Casper",
				"Melkior", "Leonidas", "Fubini", "Cosmo", "Behemai", "Kelllueth", "Wolperbrai", 
				"Yassox", "Uvilkomp", "Vieren", "Thiacore", "Idusa", "Choomacka"};
		
		String[] SpiderNames = new String[] {"Cauchy", "Weierstrass", "Gauss", "Abel", "Galois", "Lagrange",
				"Riemann", "Goldbach", "Euler", "Euclid", "Eipom", "Asenshoost", "Arachlpups", 
				"Ouroshais", "Vameiz", "Dhimcix", "Yiotrice", "Laalenus", "Dhimcix"};
		
		String[] CockroachNames = new String[] {"Descartes", "Pitagora", "Pascal", "Turing", "Ramanujan", "Eratostene",
				"Fermat", "Leibniz", "Newton", "Hilbert", "Lamayuam", "Cargith", "Mazppe", "Kaushee",
				"Aucabkh", "Ruecorn", "Pubibrea", "Pheton", "Himua", "Calmau"};
		
		int randButterflyName = randomizer.nextInt(ButterflyNames.length);
		int randSpiderName = randomizer.nextInt(SpiderNames.length);
		int randCockroachName = randomizer.nextInt(CockroachNames.length);
		
		Boolean isDangerous = randomizer.nextBoolean();
		Boolean doesFly = randomizer.nextBoolean();
		
		double randDanger = Math.random();
		double randMaintenance = Math.random() * 8;
	    boolean randCareOf = randomizer.nextBoolean();
	    randDanger = Math.floor(randDanger * 100)/100;
	    randMaintenance = Math.floor(randMaintenance * 100)/100;
		
		if(Constants.Animals.Insects.Butterfly.equals(type))
			return new Butterfly(6,ButterflyNames[randButterflyName],doesFly,isDangerous,randCareOf,randMaintenance,randDanger);
		else if (Constants.Animals.Insects.Spider.equals(type))
            return new Spider(8,SpiderNames[randSpiderName],doesFly,isDangerous,randCareOf,randMaintenance,randDanger);
        else if (Constants.Animals.Insects.Cockroach.equals(type))
            return new Cockroach(8,CockroachNames[randCockroachName],doesFly,isDangerous,randCareOf,randMaintenance,randDanger);
        else
        	throw new Exception("Invalid animal exception");
	}
}