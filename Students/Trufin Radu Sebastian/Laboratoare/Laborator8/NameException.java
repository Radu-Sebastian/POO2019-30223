
public class NameException extends Exception 
{
	private static final long serialVersionUID = 1L;

	public NameException(String msg) 
	{
		super(msg);
		System.out.println("Incercati pana numele nu este Gigel..");
	}
}