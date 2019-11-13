
public class Produs 
{
	private String nume;
	private int pret;
	private int nrExemplare;
	
	Produs(String nume, int pret, int nrExemplare)
	{
		this.nume = nume;
		this.pret = pret;
		this.nrExemplare = nrExemplare;
	}
	
	public void showProdus()
	{
		System.out.println(nume + " pretul " + pret + " nr exemplare :"
				+ nrExemplare);
	}
	
	public void setPret(int pret)
	{
		this.pret = pret;
	}
	
	public void setNume(String nume)
	{
		this.nume = nume;
	}
	
	public void setNrExemplare(int nrExemplare)
	{
		this.nrExemplare = nrExemplare;
	}
	
	public String getNume()
	{
		return this.nume;
	}
	
	public int getNrExemplare()
	{
		return this.nrExemplare;
	}
	
	public int getPret()
	{
		return this.pret;
	}
}
