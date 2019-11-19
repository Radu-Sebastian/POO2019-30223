
public class Angajat extends Persoana
{
	private String dataAngajarii;
	private int nrClientiServiti;
	private ClientFidel[] listaClientiServiti;
	
	Angajat(String nume, int ID, String dataAngajarii, int nrClientiServiti)
	{
		super(nume,ID);
		this.dataAngajarii = dataAngajarii;
		this.nrClientiServiti = nrClientiServiti;
	}
	
	public ClientFidel getClientK(int k)
	{
		return listaClientiServiti[k];
	}
	
	public String getDataAngajarii()
	{
		return this.dataAngajarii;
	}
	
	public int getNrClientiSeriviti()
	{
		return this.nrClientiServiti;
	}
	
	public void servesteClient(ClientFidel clientFidel)
	{
		listaClientiServiti[nrClientiServiti] = clientFidel;
		this.nrClientiServiti++;
	}
	
	public void showInfo()
	{
		for(int i=0; i<listaClientiServiti.length; i++)
			listaClientiServiti[i].showInfo();
	}
	
	public int calculSumaTotala(ClientFidel client)
	{
		int s = 0;
		for(int i=0; i<client.getNrProduseCumparate(); i++)
		{
			s = s + (client.produsulK(i).getPret() * client.produsulK(i).getNrExemplare());
		}
		return s;
	}
}
