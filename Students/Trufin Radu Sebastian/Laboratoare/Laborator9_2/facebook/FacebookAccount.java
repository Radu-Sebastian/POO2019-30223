package facebook;
import java.util.ArrayList;

public class FacebookAccount 
{
	private String nume;
	private int varsta;
	private String locatiaCurenta;
	private ArrayList<FacebookAccount> listaPrieteni;
	
	public FacebookAccount(String nume, int varsta, String locatiaCurenta)
	{
		this.nume = nume;
		this.varsta = varsta;
		this.locatiaCurenta = locatiaCurenta;
		listaPrieteni = new ArrayList<FacebookAccount>(5000);
	}
	
	public void addFriend(FacebookAccount newFriend)
	{
		this.listaPrieteni.add(newFriend);
	}
	
	public void removeFriend(FacebookAccount removedFriend)
	{
		for(int i=0; i<this.listaPrieteni.size(); i++)
			if(this.getListaPrieteni().get(i).equals(removedFriend))
		this.getListaPrieteni().remove(i);
	}
	
	public void friendLocation(String locatieData)
	{
		System.out.print("Prietenii lui " + this.getNume() + 
				" din " + locatieData + " sunt : \n");
		for(int i=0; i<this.listaPrieteni.size(); i++)
			if(this.getListaPrieteni().get(i).getLocatiaCurenta().equals(locatieData))
				System.out.print(this.getListaPrieteni().get(i).getNume() + " ; ");
		System.out.println(" ");
	}
	
	public void showFriends()
	{
		if(this.getListaPrieteni().isEmpty())
			System.out.println(this.getNume() + " nu are prieteni :( ");
		else
		{
			System.out.print("Prietenii lui " + this.getNume() + " sunt : \n");
		    for(int i=0; i<this.listaPrieteni.size(); i++)
		    	System.out.print(this.getListaPrieteni().get(i).getNume() + " ; ");
		    System.out.println(" ");
		}
	}
	
	public String getNume() 
	{
		return nume;
	}
	
	public void setNume(String nume) 
	{
		this.nume = nume;
	}
	
	public int getVarsta() 
	{
		return varsta;
	}
	
	public void setVarsta(int varsta) 
	{
		this.varsta = varsta;
	}
	
	public String getLocatiaCurenta() 
	{
		return locatiaCurenta;
	}
	
	public void setLocatiaCurenta(String locatiaCurenta) 
	{
		this.locatiaCurenta = locatiaCurenta;
	}
	
	public ArrayList<FacebookAccount> getListaPrieteni() 
	{
		return this.listaPrieteni;
	}
	
	public void setListaPrieteni(ArrayList<FacebookAccount> listaPrieteni) 
	{
		this.listaPrieteni = listaPrieteni;
	}
}
