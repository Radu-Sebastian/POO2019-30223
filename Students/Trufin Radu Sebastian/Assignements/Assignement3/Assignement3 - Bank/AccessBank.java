public class AccessBank 
{
   public static void main(String args[])
   {
	   Bank Transilvania = new Bank();
	   Transilvania.fillAccounts();
	   Transilvania.closeAccount(20);
	   Transilvania.closeAccount(14);
	   Transilvania.openAccount(50, 220.65);
	   Transilvania.openAccount();
	   Transilvania.showAccounts(); 
	   Transilvania.showLetters();
	   Transilvania.updateBank();
	   System.out.println("Bank updated.");
	   Transilvania.showLetters();
	   Transilvania.dividentPay(5.0);
	   System.out.println("Divident payed.");
	   Transilvania.showAccounts();
   }
}
