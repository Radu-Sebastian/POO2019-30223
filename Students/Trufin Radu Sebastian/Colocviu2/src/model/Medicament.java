package model;

public class Medicament 
{
	private String denumire;
	private String producator;
	private String pret;
	private String gramaj;
	
	public Medicament(String denumire)
	{
		this.denumire = denumire;
	}
	
	public String getDenumire() 
	{
		return denumire;
	}
	
	public void setDenumire(String denumire) 
	{
		this.denumire = denumire;
	}

	public String getProducator() 
	{
		return producator;
	}

	public void setProducator(String producator) 
	{
		this.producator = producator;
	}

	public String getPret() 
	{
		return pret;
	}

	public void setPret(String pret) 
	{
		this.pret = pret;
	}

	public String getGramaj() 
	{
		return gramaj;
	}

	public void setGramaj(String gramaj) 
	{
		this.gramaj = gramaj;
	}
}
