import java.util.Random;

public class Prob46 
{
	long bila = 0;
	Random x = new Random();
	public void simulation() 
	{
		for(int i=0; i<6; i++) 
		{
			int nr= x.nextInt(48)+1;
			if(((bila>>nr)&1)==1) // conditie numere distincte 
				i--;
			else 
			{
				bila|=1L<<nr; // setam bitul nr 
				System.out.print(nr + " ");
			}
		}
		
		System.out.println("\nSortarea numerelor extrase :");
		for(int i=0; i<49; i++) 
		{
			int nr=(int)(bila>>i) & 1;
			if((nr&1)==1)  // verificam daca bitul este setat
				System.out.print(i + " ");
		}
	}
	
	public static void main(String[] args) 
	{
		Prob46 l= new Prob46();
		l.simulation();
	}
}