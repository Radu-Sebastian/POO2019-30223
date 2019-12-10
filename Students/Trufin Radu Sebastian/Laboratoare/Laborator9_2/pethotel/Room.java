package pethotel;

public class Room 
{
	private int id;
	private int floor;
	private boolean hasBiscuits;
	
	public Room(int id, int floor, boolean hasBiscuits)
	{
		this.id = id;
		this.floor = floor;
		this.hasBiscuits = hasBiscuits;
	}
	
	public int getFloor() 
	{
		return floor;
	}
	
	public void setFloor(int floor) 
	{
		this.floor = floor;
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public boolean doesHaveBiscuits() 
	{
		return hasBiscuits;
	}

	public void setHasBiscuits(boolean hasBiscuits) 
	{
		this.hasBiscuits = hasBiscuits;
	}
}
