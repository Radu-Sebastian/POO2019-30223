import java.util.Iterator;

public class Cards implements Iterable<Character>
{
	private char [] myCards = new char[] {'2','3','4','5','6','7','8','9',
			'X','A','J','Q','K'};
	
	private String suit;
	
	private class CardIterator implements Iterator
	{
		private int poz = 0;
		
		@Override
		public boolean hasNext()
		{
			if(poz < myCards.length)
				return true;
			else
				return false;
		}
		
		@Override
		public Character next() 
		{
			if(this.hasNext())
				return myCards[poz++];
			else return null;
		}
		
		@Override
		public void remove()
		{
			myCards[poz] = '-';
		}
	}
	
	@Override
	public Iterator<Character> iterator()
	{
		return new CardIterator();
	}
	
	public void setSuit(String suit)
	{
		this.suit = suit;
	}
	
	public String getSuit()
	{
		return this.suit;
	}
	
	public static void main(String[] args)
	{
		Cards iteratorPachet = new Cards();
		Iterator<Character> iterator = iteratorPachet.iterator();
		while(iterator.hasNext())
		{
			char nextValue = iterator.next();
			if(nextValue == '4')
				iterator.remove();
			if(nextValue == 'J')
				iterator.remove();
			System.out.println(nextValue);
		}
	}
}