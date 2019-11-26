package pr35;
import java.awt.Color;

public class Masina implements Cloneable
{
	private String marca;
	private Color culoare;
	private Boolean posibAltCuloare;
	
	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}
	
	public Masina(String marca, Color culoare, Boolean posibAltCuloare)
	{
		this.marca = marca;
		this.culoare = culoare;
		this.posibAltCuloare = posibAltCuloare;
	}
	
	public String toString()
	{
		return (" marca " + this.getMarca() + " culoarea " + this.getCuloare().toString().substring(14) +
				" posibilitate? " + this.getPosibAltCuloare());
	}
	
	public void print()
	{
		System.out.println(this.toString());
	}
	
	public String getMarca() 
	{
		return marca;
	}
	public void setMarca(String marca) 
	{
		this.marca = marca;
	}
	
	public Boolean getPosibAltCuloare() 
	{
		return posibAltCuloare;
	}
	
	public void setPosibAltCuloare(Boolean posibAltCuloare) 
	{
		this.posibAltCuloare = posibAltCuloare;
	}

	public Color getCuloare() 
	{
		return culoare;
	}
	
	public class MyException extends Exception
	{
		private static final long serialVersionUID = 1L;

		public MyException(String msg)
		{
			super(msg);
		}
	}

	public void setCuloare(Color culoare) 
	{
		try
			{
			   if(this.getPosibAltCuloare() == false)
				   throw new MyException("Eroare");
		    }
		catch(Exception e) {
			System.out.println("Masina nu are posibilitatea de a fi revopsita :( ");
		}
		this.culoare = culoare;
	}
}
