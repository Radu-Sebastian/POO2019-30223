
public class ExceptieLimiteZi extends Exception 
{
	private static final long serialVersionUID = 1L;

	public ExceptieLimiteZi(String msg) 
	{
		super(msg);
		System.out.println("Ziua intre (0-7) !");
	}

}
