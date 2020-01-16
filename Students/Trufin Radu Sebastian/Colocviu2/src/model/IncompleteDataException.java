package model;

public class IncompleteDataException extends Exception 
{
	private static final long serialVersionUID = 1L;

	public IncompleteDataException(String msg) 
	{
		super(msg);
		System.out.println("Datele nu sunt complete pentru pacient");
	}
}