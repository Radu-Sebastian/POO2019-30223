package javasmmr.zoowsome.services;
import java.util.Random;
import javasmmr.zoowsome.employees.Caretaker;
import javasmmr.zoowsome.employees.Employee;

public class CaretakerFactory extends EmployeeAbstractFactory 
{
	public Employee getEmployeeFactory(String type) throws Exception
	{
        Random r = new Random();
		
		String[] careTakerNames = new String[] { "Diaconu", "Gavrea", "Vasile", "Juhasz", "Laur", "Dorofte",
				"Tariceanu", "Nastase", "Silvica", "Graur", "Barna", "Viorel" };
		
		int randCareTakerName = r.nextInt(careTakerNames.length);
		
		double randomSalary = Math.random() * 5000;
		double randomHours = Math.random() * 8;
		boolean randDeath = r.nextBoolean();
		
		return new Caretaker(careTakerNames[randCareTakerName],randDeath,randomSalary,randomHours);
	}
}
