public class Prob44 
{
	static double factorial(int n)
	{    
		  if (n == 0)    
		    return 1;    
		  else    
		    return(n*factorial(n-1));    
	}   
	
	static double binomial(int n, int k)
	{
		return factorial(n)/(factorial(n-k)*factorial(k));
	}
	
	public static void main(String[] args)
	{
		double n = binomial(49,6);
		System.out.println("Sansele de castig la lotto (6/49) este de : " + (1/n));
    }
}


