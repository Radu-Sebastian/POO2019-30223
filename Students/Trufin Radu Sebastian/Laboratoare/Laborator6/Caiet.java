
public class Caiet extends Rechizita 
{
	private String codCaiet;
	
	public String getNume()
	{
		return this.eticheta + " Caiet ";
	}
	
	public Caiet(String codCaiet)
	{
		this.codCaiet = codCaiet;
	}
	
	public void setCodCaiet(String cod)
	{
		this.codCaiet = cod;
	}
	
	public String getCodCaiet()
	{
		return this.codCaiet;
	}
	
	public String toString() 
	{
		return "C " + getNume() + getCodCaiet();
	}

	public final void print() 
	{
		System.out.println(toString());
	}
}
