
public class SavingsAccount extends Account 
{
	private int interest;
	
	public SavingsAccount(int number, double balance, int interest)
	{
		super(number,balance);
		this.interest = interest;
	}
	
	public void addInterest()
	{
		this.balance = this.getBalance() + this.getInterest();
	}
	
	public int getInterest()
	{
		return this.interest;
	}
	
	public void setInteset(int interest)
	{
		this.interest = interest;
	}

}
