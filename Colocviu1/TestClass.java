import java.util.Random;
public class TestClass 
{
	public static void main(String args[])
	{
		Random filler = new Random();
	
	String[] NumePersoane = new String[] { "Odie", "Duke", "Gheorghe", "Mike", "Ralph", "Mordecai",
			"Radu", "Matteo", "Sandor", "Murgu" };
	
	int randomID = filler.nextInt(1000);
	int randomPuncte = filler.nextInt(1000);
	int randomDiscount = filler.nextInt(99);
	int randPersonName = filler.nextInt(NumePersoane.length);
	
	ClientFidel firstClient = new ClientFidel(NumePersoane[randPersonName],randomID,1,randomPuncte,randomDiscount);
	Produs primulProdus = new Produs("Snickers",5,2);
	firstClient.adaugaProdus(primulProdus);
	firstClient.showInfo();
	
	int randomID2 = filler.nextInt(1000);
	int randPersonName2 = filler.nextInt(NumePersoane.length);
	
	Angajat primulAngajat = new Angajat(NumePersoane[randPersonName2],randomID2,"10-10-2010",0);
	// primulAngajat.servesteClient(firstClient);
	}
}
