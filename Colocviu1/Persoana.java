
public class Persoana 
{
	private int ID;
	private String nume;
	
	Persoana()
	{
		this.nume = "<Unknown Name>";
	}
	
	Persoana(String nume, int ID)
	{
		this.nume = nume;
		this.ID = ID;
	}
	
	public void setName(String nume)
	{
		this.nume = nume;
	}
	
	public String getName()
	{
		return this.nume;
	}
	
	public void setID(int ID)
	{
		this.ID = ID;
	}
	
	public int getID()
	{
		return this.ID;
	}
	
	@Override
	public String toString()
	{
		return "Numele " + this.getName();
	}
	
	public void print()
	{
		System.out.println(this.toString());
	}
}
