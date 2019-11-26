package pr34;

public class Persoana implements Comparable<Persoana>
{
	private String nume;
	private String prenume;
	private Integer varsta;
	private Boolean type;
	
	Persoana(String nume, String prenume, int varsta, Boolean type)
	{
		this.nume = nume;
		this.prenume = prenume;
		this.varsta = varsta;
		this.type = type;
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
	
	public int getVarsta() 
	{
		return varsta;
	}
	
	public void setVarsta(int varsta) 
	{
		this.varsta = varsta;
	}
	
	@Override
	public int compareTo(Persoana o) 
	{	
		int compareInt;
		
		if(this.type == false)
	        compareInt = this.varsta.compareTo(o.varsta);
		else
		    compareInt = this.nume.compareTo(o.nume);	
		
		if(compareInt < 0)
			return -1;
			
		if(compareInt > 0)
			return 1;	
		
		return 0;
	}
}
