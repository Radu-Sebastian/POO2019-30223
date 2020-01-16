package main;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import controller.FarmacieController;
import model.Angajat;
import model.Farmacie;
import model.IncompleteDataException;
import model.Medicament;
import model.Pacient;
import view.FarmacieView;

public class MainMVC 
{
	public static void main(String args[]) throws FileNotFoundException, IncompleteDataException 
	{
		File file = new File("D:\\Eclipse\\Colocviu2TrufinRadu\\src\\input.txt");
		Scanner s = new Scanner(file);
		String s1 = s.nextLine();
		String[] pacientParts = s1.split(" ");
		for(int i=0; i<pacientParts.length; i++)
			System.out.println(pacientParts[i]);
		
		try 
		{
			Pacient myPacient = new Pacient(pacientParts[0],pacientParts[1],pacientParts[2],pacientParts[3],pacientParts[4],pacientParts[5]);
		}
		catch(Exception e)
		{
			System.out.println("Oops");
		}
		
		s1 = s.next();
		String[] medicamentParts = s1.split(" ");
		
		if(pacientParts.length != 6)
		{
			throw new IncompleteDataException("Oops");
		}
		
		for(int i=0; i<medicamentParts.length; i++)
			System.out.println(medicamentParts[i]);
		
		Medicament myMedicament = new Medicament(medicamentParts[0]);
		Angajat myAngajat = new Angajat("Radu","100","15-1-2020",125.0);
		Farmacie myApothecary = new Farmacie("Catena","Str Calea Bucovinei Nr.67","0755667788","www.catena.ro");
		
		Map<Angajat,Integer> myAngajatMap = myApothecary.getMapareAngajati();
		Map<Medicament,Integer> myMedicamentMap = myApothecary.getMapareMedicamente();
		
		myAngajatMap.put(myAngajat, 100);
		myMedicamentMap.put(myMedicament, 50);
		
		FarmacieView view = new FarmacieView();
	    new FarmacieController(view,myAngajat); 
	    view.setVisible(true);
	}
}
