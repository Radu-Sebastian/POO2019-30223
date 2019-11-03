import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Prob45
{
	public static void main(String[] args)
	{
		// vector de frecvente (dorim elemente distincte)
		int a[]= new int[50];
		for(int i=1; i<=49; i++)
			a[i]=0;
		
		Random x = new Random();
		int n;
		for(int i=1; i<=6; i++)
	 {
		n = x.nextInt(48)+1;
		if(a[n] == 1)
			while(a[n] == 1)
				n = x.nextInt(48)+1; 
		a[n] = a[n] + 1;

		System.out.println("Numarul " + i + " este : " + n + " ");
	 }
	}
}
