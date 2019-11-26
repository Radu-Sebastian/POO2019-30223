public class Zi 
{
	private String nume;
	private boolean esteLucratoare;
	
	public Zi()
	{
		this.nume = "<Unknown Day>";
		this.esteLucratoare = true;
	}
	
	public String getNume() 
	{
		return nume;
	}
	
	public void setNume(String nume) 
	{
		this.nume = nume;	
	}

	public void setNelucratoare() 
	{
		this.esteLucratoare = false;	
	}
	
	public void setLucratoare() 
	{
		this.esteLucratoare = true;	
	}

	public boolean getLucratoare() 
	{
		return this.esteLucratoare;
	}
}
