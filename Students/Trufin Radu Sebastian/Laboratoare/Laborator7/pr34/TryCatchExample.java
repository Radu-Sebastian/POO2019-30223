package pr34;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatchExample 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Dati un numar : ");
		
		try {
			//int[] numere = {1,2,3,4,5};
			//System.out.println(numere[5]);
			double nr = input.nextDouble();
			System.out.println(nr);
		} catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println(e);
		} catch(InputMismatchException e)
		{
			System.out.println("Invalid input");
		}
	}
	

}
