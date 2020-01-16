package model;

public class WrongAgeFormatException extends Exception 
{
	private static final long serialVersionUID = 1L;

	public WrongAgeFormatException(String msg) 
	{
		super(msg);
		System.out.println("Varsta introdusa gresit");
	}
}