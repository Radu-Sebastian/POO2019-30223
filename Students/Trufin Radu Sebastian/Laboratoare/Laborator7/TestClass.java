
public class TestClass 
{
	public static void main(String args[])
	{
		Complex Gavrea = new Complex(1,1);
		Complex Gavrea2 = (Complex) Gavrea.inmultire(Gavrea, Gavrea);
		Gavrea2.print();
		Fractie Egipteana = new Fractie(3,4);
		Fractie Libaneza = new Fractie(4,6);
		Fractie Sum = (Fractie) Egipteana.inmultire(Egipteana, Libaneza);
		Sum.print();
	}
}
