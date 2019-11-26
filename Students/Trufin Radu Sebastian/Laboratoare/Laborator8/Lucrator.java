import java.util.Scanner;

public class Lucrator 
{
	private String nume;
	private CalendarLucru type;
	
	public void lucreaza(String zi)
	{
	    try 
	    {
	    	if(this.getType().getDay(zi).getLucratoare() == false)
	    	    	throw new ExceptieZiNelucratoare("Eroare");
	    } catch(Exception e)
	    	{
	    		 System.out.println("Nu munceste in ziua respectiva");
	    	}
	    System.out.println("Munceste in ziua respectiva");
	}
	
	public Lucrator(String nume) throws NameException
	{
		this.nume = nume;
		this.type = new CalendarLucru();
		if (this.getNume().equals("Gigel")) 
	    {
	      throw new NameException(
	          "Fara Gigel");
	    }
	    if (this.getNume() == null) 
	    {
	      throw new IllegalArgumentException(
	          "name is null");
	    }
	}
	
	public String getNume() 
	{
		return nume;
	}
	
	public void setNume(String nume) 
	{
		this.nume = nume;
	}
	
	public CalendarLucru getType() 
	{
		return this.type;
	}
	
	public void setType(CalendarLucru type) 
	{
		this.type = type;
	}
	
	public void printLucrator()
	{
		System.out.println("Lucratorul " + this.getNume() + "\n");
		for(int i=0; i<7; i++)
			System.out.println(this.getType().getDayRank(i).getNume() + " " + this.getType().getDayRank(i).getLucratoare());
	}
}
