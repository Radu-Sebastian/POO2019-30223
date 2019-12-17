package javasmmr.zoowsome.services;
import java.util.Random;
import javasmmr.zoowsome.employees.Caretaker;
import javasmmr.zoowsome.employees.Employee;

public class CaretakerFactory extends EmployeeAbstractFactory 
{
	public Employee getEmployeeFactory(String type) throws Exception
	{
        Random randomizer = new Random();
		
		String[] careTakerNames = new String[] { "Dragos I", "Bogdan I", "Petru I", "Latcu", "Petru al II-lea", "Roman I",
				"Stefan I", "Iuga Ologul", "Alexandru cel Bun", "Ilias", "Stefan al II-lea", "Roman al II-lea",
				"Petru al III-lea", "Petru Aron", "Stefan cel Mare", "Petru Rares", "Stefan Lacusta",
				"Alexandru Cornea", "Alexandru Lapusneanu", "Petru Schiopul", "Mihai Viteazul", "Dumitrascu Cantacuzino",
				"Dimitrie Cantemir", "Mihai Racovita", "Constantin Mavrocordat", "Basarab I", "Vladislab I", "Radu I",
				"Mircea cel Batran", "Radu Praznaglava", "Vlad Dracu", "Radu cel Frumos", "Vlad I", "Vlad Tepes",
				"Mircea al II-lea", "Vlad Calugarul", "Mihnea cel Rau", "Neagoe Basarab", "Gavril Movila",
				"Leon Tomsa", "Gabriel Bathory", "Constantin Brancoveanu", "Alexandru Ipsilanti"};
		
		int randCareTakerName = randomizer.nextInt(careTakerNames.length);
		
		double randomSalary = Math.random() * 5000;
		double randomHours = Math.random() * 8;
		boolean randDeath = randomizer.nextBoolean();
		
		return new Caretaker(careTakerNames[randCareTakerName],randDeath,randomSalary,randomHours);
	}
}
