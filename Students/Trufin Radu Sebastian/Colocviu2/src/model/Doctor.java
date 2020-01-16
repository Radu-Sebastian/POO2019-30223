package model;

public class Doctor 
{
	private String nume;

	public String getNume() 
	{
		return nume;
	}

	public void setNume(String nume) 
	{
		this.nume = nume;
	}
	
	public void consultatie(Pacient p)
	{
		System.out.println(p.getNume() + " " + p.getPrenume() + " a fost consultat de catre doctorul " +
	    this.getNume());
	}
	
	public void creareReteta()
	{
		
	}
}
