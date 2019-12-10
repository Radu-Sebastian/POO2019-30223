package pethotel;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class PetHotel 
{
	public Map<Room,Dog> map;
	
	public PetHotel()
	{
		this.map = new HashMap<Room,Dog>();
	}
	
	public Map<Room,Dog> getDogRegister() 
	{
		return this.map;
	}
	
	public void addDog(Dog dog, Room room)
	{
		this.getDogRegister().put(room, dog);
	}
	
	public void freeRoom(Room room)
	{
		this.getDogRegister().remove(room);
	}
	
	public boolean isFree(Room room)
	{
		if (this.getDogRegister().containsKey(room) == true)
			return false;
		else
			return true;
	}
	
	public void printRoom(Room room)
	{
		System.out.println(this.isFree(room));
	}
	
	public static void printRegister(Map<Room,Dog> register) 
	{
		for (Entry<Room, Dog> item : register.entrySet()) 
		    System.out.print(item.getKey().getId() + " " + item.getValue().getName() + "\n");
	}
}
