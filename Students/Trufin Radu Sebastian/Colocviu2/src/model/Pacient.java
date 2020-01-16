package model;

public class Pacient 
{
	private String nume;
	private String prenume;
	private String varsta;
	private String sex;
	private String afectiune;
	private String gradSeveritate;
	
	public Pacient(String nume, String prenume, String varsta, String sex, String afectiune, String gradSeveritate)
	{
		this.nume = nume;
		this.prenume = prenume;
	    this.varsta = varsta;
		this.sex = sex;
		this.afectiune = afectiune;
		this.gradSeveritate = gradSeveritate;
	}
	
	public String getNume() 
	{
		return nume;
	}
	public void setNume(String nume) 
	{
		this.nume = nume;
	}
	
	public String getPrenume() 
	{
		return prenume;
	}
	
	public void setPrenume(String prenume) 
	{
		this.prenume = prenume;
	}
	
	public String getSex() 
	{
		return sex;
	}
	
	public void setSex(String sex) 
	{
		this.sex = sex;
	}
	
	public String getVarsta() 
	{
		return varsta;
	}
	
	public void setVarsta(String varsta) 
	{
		this.varsta = varsta;
	}
	
	public String getAfectiune() 
	{
		return afectiune;
	}
	
	public void setAfectiune(String afectiune) 
	{
		this.afectiune = afectiune;
	}
	
	public String getGradSeveritate() 
	{
		return gradSeveritate;
	}
	
	public void setGradSeveritate(String gradSeveritate) 
	{
		this.gradSeveritate = gradSeveritate;
	}
}
