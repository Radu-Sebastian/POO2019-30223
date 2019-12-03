package javasmmr.zoowsome.controllers;
import javasmmr.zoowsome.models.*;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Random;
import javasmmr.zoowsome.employees.Caretaker;
import javasmmr.zoowsome.employees.Employee;
import javasmmr.zoowsome.models.Aquatic;
import javasmmr.zoowsome.models.Bird;
import javasmmr.zoowsome.models.Insect;
import javasmmr.zoowsome.models.Mammal;
import javasmmr.zoowsome.models.Reptile;
import javasmmr.zoowsome.models.interfaces.XML_Parsable;
import javasmmr.zoowsome.repositories.AnimalRepository;
import javasmmr.zoowsome.repositories.EmployeeRepository;
import javasmmr.zoowsome.services.AnimalFactory;
import javasmmr.zoowsome.services.Constants;
import javasmmr.zoowsome.services.EmployeeAbstractFactory;
import javasmmr.zoowsome.services.EmployeeFactory;
import javasmmr.zoowsome.services.SpeciesFactory;

public class MainController <T extends XML_Parsable> 
{
	public static void main(String[] args) throws Exception 
	{
		AnimalFactory abstractFactory = new AnimalFactory();
		EmployeeFactory abstractEmployeeFactory = new EmployeeFactory();

		int caretakerCount = 10;
		int zooCount = 50;
		
		Mammal[] zooMammals = new Mammal[zooCount];
		Bird[] zooBirds = new Bird[zooCount];
		Aquatic[] zooAquatics = new Aquatic[zooCount];
		Reptile[] zooReptiles = new Reptile[zooCount];
		Insect[] zooInsects = new Insect[zooCount];
		Caretaker[] zooCaretakers = new Caretaker[caretakerCount];
		
		int mammalPopulation = 0;
		int birdPopulation = 0;
		int aquaticPopulation = 0;
		int reptilePopulation = 0;
		int insectPopulation = 0;
		int caretakerPopulation = 0;
		
		SpeciesFactory speciesFactoryMammals = abstractFactory.getSpeciesFactory(Constants.Species.Mammals);
		SpeciesFactory speciesFactoryBirds = abstractFactory.getSpeciesFactory(Constants.Species.Birds);
		SpeciesFactory speciesFactoryAquatics = abstractFactory.getSpeciesFactory(Constants.Species.Aquatics);
		SpeciesFactory speciesFactoryReptiles = abstractFactory.getSpeciesFactory(Constants.Species.Reptiles);
		SpeciesFactory speciesFactoryInsects = abstractFactory.getSpeciesFactory(Constants.Species.Insects);
		EmployeeAbstractFactory employeeFactory = abstractEmployeeFactory.getEmployeeFactory(Constants.EmployeeTypes.Caretakers);
		
		for(int i=0; i<caretakerCount; i++)
		{
			zooCaretakers[caretakerPopulation] = (Caretaker) employeeFactory.getEmployeeFactory(Constants.EmployeeTypes.Caretakers);
			caretakerPopulation++;
		}

		for (int i=0; i<zooCount; i++) 
		{
			Random S = new Random();
			Random A = new Random();
			int sType = S.nextInt(5);
			int aType = A.nextInt(3);

			if (sType == 0) 
			{
				if (aType == 0) 
				{
					zooMammals[mammalPopulation] = (Mammal) speciesFactoryMammals.getAnimal(Constants.Animals.Mammals.Cow);
					mammalPopulation++;
				} 
				else if (aType == 1)
				{
			        zooMammals[mammalPopulation] = (Mammal) speciesFactoryMammals.getAnimal(Constants.Animals.Mammals.Tiger);
			        mammalPopulation++;
				} 
				else if (aType == 2) 
				{
					zooMammals[mammalPopulation] = (Mammal) speciesFactoryMammals.getAnimal(Constants.Animals.Mammals.Monkey);
					mammalPopulation++;
				}
			} 
			else if (sType == 1) 
			{
				if (aType == 0) 
				{
					zooBirds[birdPopulation] = (Bird) speciesFactoryBirds.getAnimal(Constants.Animals.Birds.Colibri);
					birdPopulation++;
				} 
				else if (aType == 1) 
				{
					zooBirds[birdPopulation] = (Bird) speciesFactoryBirds.getAnimal(Constants.Animals.Birds.Kiwi);
					birdPopulation++;
				} 
				else if (aType == 2) 
				{
					zooBirds[birdPopulation] = (Bird) speciesFactoryBirds.getAnimal(Constants.Animals.Birds.Penguin);
					birdPopulation++;
				}
			} 
			else if (sType == 2) 
			{
				if (aType == 0) 
				{
					zooAquatics[aquaticPopulation] = (Aquatic) speciesFactoryAquatics.getAnimal(Constants.Animals.Aquatics.Clownfish);
					aquaticPopulation++;
				} 
				else if (aType == 1)
				{
					zooAquatics[aquaticPopulation] = (Aquatic) speciesFactoryAquatics.getAnimal(Constants.Animals.Aquatics.Seahorse);
					aquaticPopulation++;
				} 
				else if (aType == 2) 
				{
					zooAquatics[aquaticPopulation] = (Aquatic) speciesFactoryAquatics.getAnimal(Constants.Animals.Aquatics.Salamander);
					aquaticPopulation++;
				}
			} 
			else if (sType == 3) 
			{
				if (aType == 0) 
				{
					zooReptiles[reptilePopulation] = (Reptile) speciesFactoryReptiles.getAnimal(Constants.Animals.Reptiles.Chameleon);
					reptilePopulation++;
				} 
				else if (aType == 1) 
				{
					zooReptiles[reptilePopulation] = (Reptile) speciesFactoryReptiles.getAnimal(Constants.Animals.Reptiles.Gecko);
					reptilePopulation++;
				} 
				else if (aType == 2) 
				{
					zooReptiles[reptilePopulation] = (Reptile) speciesFactoryReptiles.getAnimal(Constants.Animals.Reptiles.Iguana);
					reptilePopulation++;
				}
			} 
			else if (sType == 4) 
			{
				if (aType == 0) 
				{
					zooInsects[insectPopulation] = (Insect) speciesFactoryInsects.getAnimal(Constants.Animals.Insects.Butterfly);
					insectPopulation++;
				} 
				else if (aType == 1) 
				{
					zooInsects[insectPopulation] = (Insect) speciesFactoryInsects.getAnimal(Constants.Animals.Insects.Cockroach);
					insectPopulation++;
				} 
				else if (aType == 2) 
				{
					zooInsects[insectPopulation] = (Insect) speciesFactoryInsects.getAnimal(Constants.Animals.Insects.Spider);
					insectPopulation++;
				}
			}
		}
	
		System.out.println(" \n Mamiferele \n ");
		for(int i=0; i<mammalPopulation; i++)
		{
			String numeClasa = new String(zooMammals[i].getClass().getName());
			System.out.print(numeClasa.substring(25,numeClasa.length()) + " ");
			System.out.printf("%s , %.2f°C \n",zooMammals[i].getName(),zooMammals[i].getNormalBodyTemperature(),zooMammals[i]);
		}
		
		System.out.println(" \n Insectele \n ");
		for(int i=0; i<insectPopulation; i++)
		{
			String numeClasa = new String(zooInsects[i].getClass().getName());
		    System.out.print(numeClasa.substring(25,numeClasa.length()) + " " + zooInsects[i].getName() + "\n"  );
		}
		
		System.out.println(" \n Pasarile \n ");
		for(int i=0; i<birdPopulation; i++)
		{
			String numeClasa = new String(zooBirds[i].getClass().getName());
		    System.out.print(numeClasa.substring(25,numeClasa.length()) + " " + zooBirds[i].getName() + "\n"  );
		}
		
		System.out.println(" \n Reptilele \n ");
		for(int i=0; i<reptilePopulation; i++)
		{
			String numeClasa = new String(zooReptiles[i].getClass().getName());
		    System.out.print(numeClasa.substring(25,numeClasa.length()) + " " + zooReptiles[i].getName() + "\n"  );
		}
		
		System.out.println(" \n Acvaticele \n ");
		for(int i=0; i<aquaticPopulation; i++)
		{
			String numeClasa = new String(zooAquatics[i].getClass().getName());
		    System.out.print(numeClasa.substring(25,numeClasa.length()) + " " + zooAquatics[i].getName() + "\n"  );
		}
		
		int j=0;
		for(int i=0; i<caretakerPopulation; i++)
		{
			while(j<mammalPopulation)
			{
				if(zooCaretakers[i].getDeath() == false && zooMammals[j].getTakenCareOf() == false)
				{
					String result = zooCaretakers[i].takeCareOf(zooMammals[j]);
					if(result.contentEquals(Constants.Employees.Caretakers.TCO_KILLED))
					{
						zooCaretakers[i].setDeath(true);
					}
					else if(result.equals(Constants.Employees.Caretakers.TCO_NO_TIME))
					{
						j++;
					}
					else zooMammals[i].setTakenCareOf(true);
				}
				j++;
			}
		}
		
		System.out.println("\n Caretakers  \n ");
		for(int i=0; i<caretakerPopulation; i++)
		{
			zooCaretakers[i].print();
		}
		
		for(int i=0; i<mammalPopulation; i++)
		{
			String formatDanger = String.format("%.02f",zooMammals[i].getDangerPerc());
			zooMammals[i].setDangerPerc(Math.floor(zooMammals[i].getDangerPerc()*100)/100);
			if(zooMammals[i].getTakenCareOf() == true)
				System.out.println(zooMammals[i].name + " is taken of and the "
						+ "danger rate is : " + formatDanger);
		}
		
		System.out.println();
		for(int i=0; i<mammalPopulation; i++)
		{
			String formatDanger = String.format("%.02f",zooMammals[i].getDangerPerc());
			String formatPredisposition = String.format("%.02f",zooMammals[i].getPredisposition());
			if(zooMammals[i] instanceof Tiger)
				{
				    System.out.println("Tiger " + zooMammals[i].getName() + " has danger percentage of "
					+ formatDanger + " in the other cases and " + formatPredisposition
					+ " now. ");
				}
		}
		
		ArrayList<Animal> myAnimals = new ArrayList<Animal>(zooCount);
		for(int i=0; i<mammalPopulation; i++)
		{
			zooMammals[i].setDangerPerc(Math.floor(zooMammals[i].getDangerPerc()*100)/100);
			myAnimals.add(zooMammals[i]);
		}
		
		for(int i=0; i<birdPopulation; i++)
			myAnimals.add(zooBirds[i]);
		for(int i=0; i<aquaticPopulation; i++)
			myAnimals.add(zooAquatics[i]);
		for(int i=0; i<insectPopulation; i++)
			myAnimals.add(zooInsects[i]);
		for(int i=0; i<reptilePopulation; i++)
			myAnimals.add(zooReptiles[i]);
		
		AnimalRepository myAnimalRepository = new AnimalRepository("AnimalsGeneric.xml",Constants.XML_TAGS.ANIMAL);
		myAnimalRepository.save(myAnimals);
		myAnimalRepository.load();
		
		ArrayList<Employee> myEmployees = new ArrayList<Employee>(caretakerPopulation);
		
		for(int i=0; i<caretakerPopulation; i++)
			myEmployees.add(zooCaretakers[i]);
		
		EmployeeRepository myEmployeeRepository = new EmployeeRepository("EmployeesGeneric.xml",Constants.XML_TAGS.EMPLOYEE);
		myEmployeeRepository.save(myEmployees);
	    myEmployeeRepository.load();
	}
}
