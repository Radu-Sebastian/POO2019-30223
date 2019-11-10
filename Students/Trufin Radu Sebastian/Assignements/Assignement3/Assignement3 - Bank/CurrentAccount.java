
public class CurrentAccount extends Account 
{
	private int overdraftLimit;
	private int letters;
	
	public CurrentAccount(int number, double balance, int overdraftLimit)
	{
		super(number,balance);
		this.overdraftLimit = overdraftLimit;
		this.letters = 0;
	}
	
	public int getOverdraftLimit()
	{
		return this.overdraftLimit;
	}
	
	public void sendLetters(int nrOfLetters)
	{
		this.letters = this.letters + nrOfLetters;
	}
	
	public int getLetters()
	{
		return this.letters;
	}
	
	public void setOverdraftLimit(int overdraftLimit)
	{
		this.overdraftLimit = overdraftLimit;
	}
}
