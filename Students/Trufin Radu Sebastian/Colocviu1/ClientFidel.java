
public class ClientFidel extends Client 
{
	private int nrPuncte;
	private int discountAplicat;

	ClientFidel(String nume, int ID, int nrProduseCumparate, int nrPuncte, int discountAplicat)
	{
		super(nume,ID,nrProduseCumparate);
		this.discountAplicat = discountAplicat;
		this.nrPuncte = nrPuncte;
	}
	
	public void setNrPuncte(int nrPuncte)
	{
		this.nrPuncte = nrPuncte;
	}
	
	public void setDiscountAplicat(int discountAplicat)
	{
		this.discountAplicat = discountAplicat;
	}
	
	public int getNrPuncte()
	{
		return this.nrPuncte;
	}
	
	public int getDiscountAplicat()
	{
		return this.discountAplicat;
	}
	
	public void showInfo()
	{
		super.showInfoClient();
		System.out.println( " \n Client fidel cu " + this.nrPuncte
				+ " puncte si discount de " + this.discountAplicat + " lei.");
	}
}
