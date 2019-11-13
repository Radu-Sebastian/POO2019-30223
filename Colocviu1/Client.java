
public class Client extends Persoana 
{
	private int nrProduseCumparate;
	private Produs[] listaProduseCumparate;

	Client(String nume, int ID, int nrProduseCumparate)
	{
		super(nume,ID);
		this.nrProduseCumparate = nrProduseCumparate;
		listaProduseCumparate = new Produs[100];
	}
	
	public Produs produsulK(int k)
	{
		return listaProduseCumparate[k];
	}
	
	public int getNrProduseCumparate()
	{
		return this.nrProduseCumparate;
	}
	
	public void adaugaProdus(Produs produs)
	{
		this.listaProduseCumparate[nrProduseCumparate++] = produs;
	}
	
	public void showInfoClient()
	{
		System.out.println("Clientul " + this.getName() + " are " +
	    this.nrProduseCumparate + " produse cumparate. \n ");
		 //for(int i=0; i<listaProduseCumparate.length; i++)
		//	System.out.print(produsulK(i).getNume() + " ");
	}
}
