package model;

public class Angajat implements AtributiiAngajat
{
	private String nume;
	private String ID;
	private String dataAngajarii;
	private double bonusSalariu;
	
	public Angajat(String nume, String ID, String dataAngajarii, double bonusSalariu)
	{
		this.nume = nume;
		this.ID = ID;
		this.dataAngajarii = dataAngajarii;
		this.bonusSalariu = bonusSalariu;
	}
	
	public String getID() 
	{
		return ID;
	}
	
	public void setID(String iD) 
	{
		ID = iD;
	}
	
	public String getNume() 
	{
		return nume;
	}
	
	public void setNume(String nume) 
	{
		this.nume = nume;
	}
	
	public double getBonusSalariu() 
	{
		return bonusSalariu;
	}
	
	public void setBonusSalariu(double bonusSalariu)
	{
		this.bonusSalariu = bonusSalariu;
	}
	
	public String getDataAngajarii() 
	{
		return dataAngajarii;
	}
	
	public void setDataAngajarii(String dataAngajarii)
	{
		this.dataAngajarii = dataAngajarii;
	}

	@Override
	public void adaugaMedicament(Farmacie f, Medicament m, Integer stoc) 
	{
		f.getMapareMedicamente().put(m, stoc);
	}

	@Override
	public void stergeMedicament(Farmacie f, Medicament m) 
	{
		f.getMapareMedicamente().remove(m);
	}

	@Override
	public void verificaStoc(Farmacie f, Medicament m) 
	{
	   if((f.getMapareAngajati()).containsValue(0))
		   System.out.println("Stoc indisponibil");
	   else
		   System.out.println("Stoc disponibil");
		
	}

	@Override
	public void verificaMedicament(Farmacie f, Medicament m) 
	{
	   if(f.getMapareAngajati().containsKey(m))
		   System.out.println("Medicamentul " + m.getDenumire() + " se vinde la farmacie.");
	   else
		   System.out.println("Medicamentul " + m.getDenumire() + " nu se vinde la farmacie.");
	}

	@Override
	public void modificaStoc(Farmacie f, Medicament m, int stocNou) 
	{
		if((f.getMapareMedicamente()).containsKey(m))
			f.getMapareMedicamente().put(m,(f.getMapareMedicamente()).get(m) + 1);
	}

	@Override
	public void proceseazaReteta(Pacient p) 
	{

	}
}
