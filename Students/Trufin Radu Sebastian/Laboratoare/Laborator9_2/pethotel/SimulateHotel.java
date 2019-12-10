package pethotel;
import java.util.Map;

public class SimulateHotel 
{
	public static void main(String args[])
	{
		PetHotel pawlines = new PetHotel();
		Dog firstDog = new Dog("Misha", "German Shepherd", 11);
		Dog secondDog = new Dog("Aida", "Saint Bernard", 11);
		Dog thirdDog = new Dog("Puc", "Teckel", 13);
		Room firstRoom = new Room(305, 3, true);
		Room secondRoom = new Room(501, 5, false);
		Room thirdRoom = new Room(402, 4, false);
		
		Map<Room,Dog> dogRegister = pawlines.getDogRegister();
		
		pawlines.addDog(firstDog, firstRoom);
		pawlines.addDog(secondDog, secondRoom);
	
		PetHotel.printRegister(dogRegister);
		System.out.println();
		
		pawlines.printRoom(firstRoom);
		pawlines.printRoom(thirdRoom);
		System.out.println();
		
		pawlines.addDog(thirdDog,firstRoom);
		PetHotel.printRegister(dogRegister);
		System.out.println();
		
		pawlines.freeRoom(secondRoom);
		PetHotel.printRegister(dogRegister);
		System.out.println();
	}
}
