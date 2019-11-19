
public class Supermarket 
{
	private Angajat[] listaAngajati;
	
	public void showFidelSort()
	{
		int mx = 0;
		for(int i=0; i<listaAngajati.length - 1; i++)
		{
			int maxx = 0;
			for(int k=0; k<listaAngajati[i].getNrClientiSeriviti(); k++)
               if(listaAngajati[i].calculSumaTotala(listaAngajati[i].getClientK(k)) > maxx)
            	   maxx = listaAngajati[i].calculSumaTotala(listaAngajati[i].getClientK(k));
			if(maxx > mx)
				mx = maxx;
	    }
		System.out.printf("maxx = %d",mx);
	}
	
	public void addClientFidel(Angajat angajat, ClientFidel clientFidel)
	{
		for(int i=0; i<listaAngajati.length; i++)
			if(angajat.getID() == listaAngajati[i].getID())
				listaAngajati[i].servesteClient(clientFidel);
	}
	
	public void addAngajat(Angajat angajat)
	{
		listaAngajati[listaAngajati.length] = angajat;
	}
	
	public void showStats()
	{
		int nrProduseFidel = 0;
		int nrProduseSimplu = 0;
		
		for(int i=0; i<listaAngajati.length; i++)
		{
			for(int j=0; j<listaAngajati[i].getNrClientiSeriviti(); j++)
				if(listaAngajati[i].getClientK(j).getClass().getName() == "ClientFidel")
					nrProduseFidel = nrProduseFidel + listaAngajati[i].getClientK(j).getNrProduseCumparate();
				else
					nrProduseSimplu = nrProduseSimplu + listaAngajati[i].getClientK(j).getNrProduseCumparate();
		}
		System.out.println("Numarul produselor vandute clientilor fideli este : " + nrProduseFidel );
		System.out.println("Numarul produselor vandute celorlalti clienti este : " + nrProduseSimplu );
	}
	
}
