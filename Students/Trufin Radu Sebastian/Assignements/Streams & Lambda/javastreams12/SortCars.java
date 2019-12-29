package javastreams12;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortCars 
{
    public static void main(String[] args) 
    {
        List<Car> myList = new ArrayList<>();
        Car firstCar = new Car("Dacia Papuc",1980,"Grey",1500.55);
        Car secondCar = new Car("Tesla Cybertruck",2019,"Black",50000.85);
        Car thirdCar = new Car("Toy Car",2018,"Pink",50.95);
        myList.add(firstCar);
        myList.add(secondCar);
        myList.add(thirdCar);
        
        Collections.sort(myList, (a, b) -> (a.price).compareTo(b.price));
        Collections.reverse(myList);
        System.out.println(myList);
    }
}