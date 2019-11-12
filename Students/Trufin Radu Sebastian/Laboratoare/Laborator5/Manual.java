
public class Manual extends Rechizita 
{
	private String codManual;
	
	public String getNume()
	{
		return this.eticheta + " Manual ";
	}
	
	public Manual(String codManual)
	{
		this.codManual = codManual;
	}
	
	public void setCodManual(String cod)
	{
		this.codManual = cod;
	}
	
	public String getCodManual()
	{
		return this.codManual;
	}
	
	public String toString() 
	{
		return "M " + getNume() + getCodManual();
	}

	public final void print() 
	{
		System.out.println(toString());
	}
}
