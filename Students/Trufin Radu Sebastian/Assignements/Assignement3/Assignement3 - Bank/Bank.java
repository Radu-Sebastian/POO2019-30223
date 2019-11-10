import java.util.Random;

public class Bank 
{
	public int nrOfAccounts = 50;
	Account[] BankAccounts = new Account[100];
	
	public void fillAccounts()
	{
		for (int i=0; i<nrOfAccounts; i++) 
		{
			Random filler = new Random();
			int type = filler.nextInt(3);
			int scalar = filler.nextInt(1000);
			double randomBalance = filler.nextDouble();
			int randomInterest = filler.nextInt(100);
			int randomOverdraft = filler.nextInt(100);

			if (type == 1) 
					BankAccounts[i] = new SavingsAccount(i,randomBalance*scalar,randomInterest) ;
			else if (type == 2)
				    BankAccounts[i] = new CurrentAccount(i,randomBalance*scalar,randomOverdraft) ;
			else  BankAccounts[i] = new Account(i,randomBalance*scalar);
	    }
	}
	
	public void showAccounts()
	{
		for(int i=0; i<nrOfAccounts; i++)
			System.out.printf("%s nr. %d with %.2f balance \n",BankAccounts[i].getClass().getName(),
			BankAccounts[i].getAccountNumber(),BankAccounts[i].getBalance());
	}
	
	public void showLetters()
	{
		for(int i=0; i<nrOfAccounts; i++)
		{
			if(BankAccounts[i].getClass().getName() == "CurrentAccount")
				System.out.println(BankAccounts[i].getAccountNumber() + " has "
						+ ((CurrentAccount) BankAccounts[i]).getLetters() + " letters.");
		}
	}
	
	public void updateBank()
	{
		for (int i=0; i<nrOfAccounts; i++) 
		{
			if(BankAccounts[i].getClass().getName() == "SavingsAccount")
				{
				   int add = ((SavingsAccount) BankAccounts[i]).getInterest();
				   BankAccounts[i].deposit(add);
				}
			else if (BankAccounts[i].getClass().getName() == "CurrentAccount")
			    {
				   if(((CurrentAccount) BankAccounts[i]).getOverdraftLimit() <
						  BankAccounts[i].getBalance())
					   ((CurrentAccount) BankAccounts[i]).sendLetters(1);
			    }	
			else ;
		}
	}
	
	public void openAccount(int number, double balance)
	{
		BankAccounts[nrOfAccounts] =  new Account(number,balance);
		nrOfAccounts = nrOfAccounts + 1;
	}
	
	public void openAccount()
	{
		int index = BankAccounts[nrOfAccounts-1].getAccountNumber();
		BankAccounts[nrOfAccounts] =  new Account(index+1);
		nrOfAccounts = nrOfAccounts + 1;
	}
	
	public void closeAccount(int k)
	{
		for (int i=k; i<nrOfAccounts-1; i++)
			{
			    BankAccounts[i].setAccountNumber(BankAccounts[i+1].getAccountNumber());
			    BankAccounts[i].setBalance(BankAccounts[i+1].getBalance());
			}
		nrOfAccounts = nrOfAccounts - 1;
	}
	
	public void dividentPay(double divident)
	{
		for(int i=0; i<nrOfAccounts; i++)
			BankAccounts[i].withdraw(divident);
	}
}
