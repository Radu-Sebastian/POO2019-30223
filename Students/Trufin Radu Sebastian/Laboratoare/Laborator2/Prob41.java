import java.util.Scanner;

public class Prob41 
{
	// Conjectura : Orice numar întreg par mai mare decât 2 poate fi scris ca suma de doua numere prime
	static int Prime(int nr)
	{
	    if(nr<2)
	    return 0;
	    int d=2;
	    while(d*d<=nr)
	    {
	       if(nr%d==0)
	       return 0;
	       d++;
	    }
	    return 1;
	}
	
	static void Goldbach(int n) 
	{ 
		if(n<=2)
		{
			System.out.println("Invalid.");
			return ;
		}
		
		if(Prime(n)==1)
		{
			System.out.println(n + " Este numar prim.");
		}
		
	    for (int i=1; i<n; i++) 
	    { 
	        if (Prime(i) == 1 && Prime(n-i) == 1) 
	        { 
	        	System.out.println(n + " = " + i + " + " + (n-i));
	            return; 
	        } 
	    } 
	} 
	
	public static void main(String[] args)
	{
		 System.out.print("Cititi marginea inferioara (m) : "); 
		 Scanner m = new Scanner(System.in);
		 int x = m.nextInt();
		 System.out.print("Cititi marginea superioara (n) : ");
		 Scanner n = new Scanner(System.in);
		 int y = n.nextInt();
		 System.out.println("Numerele din intervalul [" + x + "," + y + "] sunt :");
		 for(int i=x;i<=y;i++)
		 Goldbach(i);
	}
}
