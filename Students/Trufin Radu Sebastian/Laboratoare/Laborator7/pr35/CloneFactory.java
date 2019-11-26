package pr35;
import java.awt.Color;

public class CloneFactory 
{
	public static void main(String args[]) throws CloneNotSupportedException
	{
		Masina myCar = new Masina("Wolkswagen",Color.black,true);
		
	    Student firstStudent = new Student("Radu","Sebastian",myCar);
	    Student clonedStudent = (Student) firstStudent.clone();
	    
	    clonedStudent.getCar().setCuloare(Color.white);
	
	    firstStudent.print();
	    System.out.println("Cloned student ");
	    clonedStudent.print();
	    
	    Masina newCar = new Masina("Lexus",Color.yellow,false);
	    Student secondStudent = new Student("Mos","Craciun",newCar);
	    secondStudent.getCar().setCuloare(Color.magenta);
	}
}
