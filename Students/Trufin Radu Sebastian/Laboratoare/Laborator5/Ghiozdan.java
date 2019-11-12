import java.util.Random;

public class Ghiozdan 
{
	private int nrRechizite;
	private Rechizita[] listaRechizite;
	
	Ghiozdan(int k)
	{
		nrRechizite = k;
		listaRechizite = new Rechizita[k];
	}

	public void fillGhiozdan()
	{
		for (int i=0; i<nrRechizite; i++) 
		{
			Random filler = new Random();
			int type = filler.nextInt(2);
			
			String[] numeManuale = new String[] {"Matematica Cls.5", "Fizica Cls.6", 
			"Comunicare in lb. romana", "Explorarea mediului", 
			"Matematici speciale de Ioan Gavrea", 
			"Algebra liniara si geometrie analitica de Vasile Pop",
			"Introduction to algorithms by Varga Robert", 
			"Probleme usoare CAN de Adrian Peculea", 
			"PSN cu Octavian Cret si Vacariu Lucia"};
			
			String[] numeCaiete = new String[] {"Hannah Montana", "Spiderman",
					"Dictando ", "Xtreme", "Ben10", "Pigna Animal",
					"Angry Birds", "One Colour", "Chic Girl"};
			
			int randNumeRechizita = filler.nextInt(numeManuale.length);
			
			if (type == 1) 
				listaRechizite[i] = new Manual(numeManuale[randNumeRechizita]);
			else 
				listaRechizite[i] = new Caiet(numeCaiete[randNumeRechizita]);
		}
	}
	
	public void add(Caiet caiet)
	{
		listaRechizite[nrRechizite] = caiet;
		nrRechizite++;
	}
	
	public void add(Manual manual)
	{
		listaRechizite[nrRechizite] = manual;
		nrRechizite++;
	}
	
	public void listItems()
	{
		for(int i=0; i<nrRechizite; i++)
			System.out.println(listaRechizite[i]);
	}
	
	public void listManual()
	{
		for(int i=0; i<nrRechizite; i++)
		{
			if(listaRechizite[i].getClass().getName() == "Manual")
			((Manual) listaRechizite[i]).print();
		}
	}
	
	public void listCaiet()
	{
		for(int i=0; i<nrRechizite; i++)
		{
			if(listaRechizite[i].getClass().getName() == "Caiet")
			((Caiet) listaRechizite[i]).print();
		}
	}
	
	public int getNrRechizite()
	{
		return this.nrRechizite;
	}
	
	public int getNrManuale()
	{
		int nr = 0;
		for(int i=0; i<nrRechizite; i++)
		{
			if(listaRechizite[i].getClass().getName() == "Manual")
			nr++;
		}
		return nr;
	}
	
	public int getNrCaiete()
	{
		int nr = 0;
		for(int i=0; i<nrRechizite; i++)
		{
			if(listaRechizite[i].getClass().getName() == "Caiet")
			nr++;
		}
		return nr;
	}
}
