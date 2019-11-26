
public class TestGhiozdan 
{
	public static void main(String args[])
    {
		Ghiozdan Titan = new Ghiozdan(50);
		Titan.fillGhiozdan();
		System.out.println("Rechizitele din ghiozdan sunt : ");
		Titan.listItems();
		System.out.println("\nNumarul de caiete este : " + Titan.getNrCaiete());
		System.out.println("Numarul de manuale este : " + Titan.getNrManuale() + "\n");
		System.out.println("Caietele sunt : ");
		Titan.listCaiet();
		System.out.println("\nManualele sunt : ");
		Titan.listManual();
	}
}
