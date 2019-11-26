
public class Fractie implements Numeric
{
	private double numarator;
	private double numitor;
	
	public Fractie(double numarator, double numitor)
	{
		this.numarator = numarator;
		this.numitor = numitor;
	}
	
	public static double greatestCommonDivizor(double a, double b)
	{
		if(b != 0)
			return greatestCommonDivizor(b,a%b);
		else
			return a;
	}
	
	public Object adunare(Object o1, Object o2)
	{
		Fractie f1 = (Fractie) o1;
		Fractie f2 = (Fractie) o2;
		
		double newNum = f1.numarator * f2.numitor + f1.numitor * f2.numarator;
		double newNumi = f1.numitor * f2.numitor;
		double GCD = greatestCommonDivizor(newNum,newNumi);
		
		Fractie newFrac = new Fractie(newNum / GCD, newNumi / GCD);
		return newFrac;
	}
	
	public Object scadere(Object o1, Object o2)
	{
		Fractie f1 = (Fractie) o1;
		Fractie f2 = (Fractie) o2;
		
		double newNum = f1.numarator * f2.numitor - f1.numitor * f2.numarator;
		double newNumi = f1.numitor * f2.numitor;
		double GCD = greatestCommonDivizor(newNum,newNumi);
		
		Fractie newFrac = new Fractie(newNum / GCD, newNumi / GCD);
		return newFrac;
	}
	
	public Object inmultire(Object o1, Object o2)
	{
		Fractie f1 = (Fractie) o1;
		Fractie f2 = (Fractie) o2;
		
		double newNum = f1.numarator * f2.numarator;
		double newNumi = f1.numitor * f2.numitor;
		double GCD = greatestCommonDivizor(newNum,newNumi);
		
		Fractie newFrac = new Fractie(newNum / GCD, newNumi / GCD);
		return newFrac;
	}
	
	@Override
	public String toString()
	{
		return this.numarator + " / " + this.numitor;
	}
	
	public void print()
	{
		System.out.println(this.toString());
	}
}

