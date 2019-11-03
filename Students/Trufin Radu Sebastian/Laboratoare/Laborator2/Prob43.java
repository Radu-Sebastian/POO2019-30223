import java.util.Scanner;

public class Prob43 
{
	public static void main(String[] args)
	{
		int cons = 0;
		int  voc = 0;
		System.out.print("Introduceti un cuvant : "); 
	    Scanner n = new Scanner(System.in);
	    String x = n.nextLine();
	 
	    for(int i=0; i<x.length(); i++)
		   if(x.charAt(i) == 'a')
			 voc = voc + 1;
		 else
			 if(x.charAt(i) == 'e')
				 voc = voc + 1;
			 else
				 if(x.charAt(i) == 'i')
					 voc = voc + 1;
				 else
					 if(x.charAt(i) == 'o')
						 voc = voc + 1;
					 else
						 if(x.charAt(i) == 'u')
							 voc = voc + 1;
						 else
							 cons = cons + 1;
	    
	    // din cmd se apeleaza aplicatia 
	    // javac Prob43.java
	    // java Prob43
	    System.out.print("Introduceti o vocala : "); 
	    Scanner m = new Scanner(System.in);
	    char c = m.next().charAt(0);
	    
	    System.out.println("Indicii vocalei " + c + " sunt : " ); 
	    for(int i=0; i<x.length(); i++)
			   if(x.charAt(i) == c)
				 System.out.print(i + " ");
						 
	   System.out.println("Numarul de vocale este " + voc);
	   System.out.println("Numarul de consoane este " + cons);
	}
}
