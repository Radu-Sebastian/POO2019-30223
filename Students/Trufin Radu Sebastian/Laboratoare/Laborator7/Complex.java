
public class Complex implements Numeric
{
	private double re;
	private double im;
	
	public Complex(double re, double im)
	{
		this.re = re;
		this.im = im;
	}
	
	@Override
	public Object adunare(Object o1, Object o2)
	{
		Complex z1 = (Complex) o1;
		Complex z2 = (Complex) o2;
		Complex z = new Complex(z1.re + z2.re, z1.im + z2.im);
		return z;
	}
	
	public Object scadere(Object o1, Object o2)
	{
		Complex z1 = (Complex) o1;
		Complex z2 = (Complex) o2;
		Complex z = new Complex(z1.re - z2.re, z1.im - z2.im);
		return z;
	}
	
	public Object inmultire(Object o1, Object o2)
	{
		Complex z1 = (Complex) o1;
		Complex z2 = (Complex) o2;
		Complex z = new Complex(z1.re * z2.re - z1.im * z2.im, z1.re * z2.im + z1.im * z2.re);
		return z;
	}
	
	@Override
	public String toString()
	{
		return "Re = " + this.re + " Im = " + this.im;
	}
	
	public void print()
	{
		System.out.println(this.toString());
	}
}
