
public class CardPack implements OrderedIterator
{
	private Cards[] Pack = new Cards[4];
	
	public CardPack() 
	{
		for(int i=0; i<Pack.length; i++)
		Pack[i] = new Cards();

		Pack[0].setSuit("Hearts");
		Pack[1].setSuit("Diamonds");
		Pack[2].setSuit("Spades");
		Pack[3].setSuit("Clubs");
	}
	
	@Override
	public String toString()
	{
		return("Tipul " + Pack[0].getSuit());
	}
	
	public final void print() 
	{
		System.out.println(toString());
	}
	
	/*
	@Override
	public int CardComparable(Comparable comp)
	{
		char deComparat;
	}
	*/
	
}
