public class Prob42bun 
{
	static double f(double a, double b, double c, double x)
	{
		return a*x*x + b*x + c;
	}
	
	static double df(double a, double b, double c, double x)
	{
		return 2*a*x+b;
	}
	
	static void MetodaNewton(double a, double b, double c, double x)
	{
		if( (b*b) - (4*a*c) <0)
		{
		   System.out.println("Solutii compelxe.");
		   return ;
		}
	
		int it = 0;
		final double epsilon = 0.001;
		double r = f(a,b,c,x)/df(a,b,c,x);
		while(Math.abs(r) >= epsilon)
		{
			r = f(a,b,c,x)/df(a,b,c,x);
			x = x - r;  // x_(n+1) = x_(n) - r
			it = it + 1;
		}
		System.out.println("O radacina a ecuatiei " + a + "x^2 + " + b + "x + " + c + " este " + x);
		System.out.println("Numarul de iteratii : " + it);
	}
	
	public static void main(String[] args)
	{
		double x = 0;
		double a = 2;
		double b = -8;
		double c = 8;
		MetodaNewton(a,b,c,x);
	}
}
