import java.util.Random;
import java.util.Scanner;

public class MainClass 
{
	public static void catchNull(Lucrator firstWorker)
	{
		try {
			System.out.println(firstWorker.getNume());
			} catch(NullPointerException e)
			{
				System.out.println("Null Worker!");
			}
	}
	
	public static void f(Lucrator[] Workers, int nrLucratori)
	{
		System.out.println("Aflati informatii despre ziua i : ");
		
		try 
		{
			Scanner scan = new Scanner(System.in);
			int n = scan.nextInt();
			if(n < 0 || n > 7 )
			{
				throw new ExceptieLimiteZi("Eroare.."); 
			}
			for(int i=0; i<nrLucratori; i++)
			{
				System.out.print(Workers[i].getNume() + " ");
				if(Workers[i].getType().getDayRank(n).getLucratoare() == true)
					System.out.println("Lucratoare");
				else
					System.out.println("Nelucratoare");
			}
		} catch(Exception e)
		{
			System.out.println("Scuze, trebuie sa introduci un numar valid.");
		}
	}
	
	public static void g(int a, int b)
	{
		try 
    	{ 
            System.out.println ("Result = " + a/b); 
        } 
        catch(ArithmeticException e) 
    	{ 
            System.out.println ("Can't divide a number by 0"); 
        } 
    	finally
    	{
    		System.out.println("You made it here..");
        } 
	}
	
	public static void printN(Lucrator[] Workers, int n)
	{
		try 
		{
			System.out.println(Workers[n].getNume());
		} catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Array out of bounds!");
		}
	}
	
	public static void main(String args[]) throws NameException
	{
		int nrLucratori = 10;
        Random r = new Random();
        Lucrator[] Workers = new Lucrator[nrLucratori];
		
		String[] RandNames = new String[] { "Zalmoxis ", "Gebeleizis ", "Bendis", "Derzelas", "Dionysos", "Kotys",
				"Pleistoros", "Sabazios", "Seirenes", "Sylvanus", "Gigel", "Aurelian",
				"Traian", "Augustin", "Cornelius"};
		
		for(int i=0; i<nrLucratori; i++)
		{
			   int randWorkerName = r.nextInt(RandNames.length);
			   Workers[i] = new Lucrator(RandNames[randWorkerName]);
			   
			   for(int j=0; j<7; j++)
			   {
				   boolean randWork = r.nextBoolean();
				   if(randWork == true)
				   Workers[i].getType().Schedule[j].setLucratoare();
				   else
					   Workers[i].getType().Schedule[j].setNelucratoare();
			   }
		}
		
		for(int i=0; i<nrLucratori; i++)
			{
			   Workers[i].printLucrator();	
			   System.out.println();
			}
		
		Lucrator firstWorker = null;
		catchNull(firstWorker);
		printN(Workers,11);
		g(100,0);
		f(Workers,nrLucratori);
   }
}
