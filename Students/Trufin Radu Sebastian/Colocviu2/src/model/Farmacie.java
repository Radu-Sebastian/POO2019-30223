package model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Farmacie implements Cloneable
{
	private String denumire;
	private String adresa;
	private String nrTelefon;
	private String website;
	public Map<Medicament,Integer> mapareMedicamente;
	public Map<Angajat,Integer> mapareAngajati;
	Set<Angajat> Employee = new HashSet<>();	
	
	public Farmacie()
	{
		this.mapareAngajati = new HashMap<Angajat,Integer>();
		this.mapareMedicamente = new HashMap<Medicament,Integer>();
	}
	
	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}
	
	public String getDenumire() 
	{
		return denumire;
	}
	
	public class MyException extends Exception
	{
		private static final long serialVersionUID = 1L;

		public MyException(String msg)
		{
			super(msg);
		}
	}
	
	public Map<Angajat,Integer> getMapareAngajati() 
	{
		return this.mapareAngajati;
	}
	
	public Map<Medicament,Integer> getMapareMedicamente() 
	{
		return this.mapareMedicamente;
	}
	
	public Farmacie(String denumire, String adresa, String nrTelefon, String website)
	{
		this.mapareAngajati = new HashMap<Angajat,Integer>();
		this.mapareMedicamente = new HashMap<Medicament,Integer>();
		this.denumire = denumire;
		this.adresa = adresa;
		this.nrTelefon = nrTelefon;
		this.website = website;
		this.mapareAngajati = new HashMap<Angajat,Integer>();
		this.mapareMedicamente = new HashMap<Medicament,Integer>();
	}
	
	public void setDenumire(String denumire) 
	{
		this.denumire = denumire;
	}
	
	public String getAdresa() 
	{
		return adresa;
	}
	
	public void setAdresa(String adresa) 
	{
		this.adresa = adresa;
	}
	
	public String getNrTelefon() 
	{
		return nrTelefon;
	}
	
	public void setNrTelefon(String nrTelefon) 
	{
		this.nrTelefon = nrTelefon;
	}
	
	public String getWebsite() 
	{
		return website;
	}
	
	public void setWebsite(String website) 
	{
		this.website = website;
	}
}
