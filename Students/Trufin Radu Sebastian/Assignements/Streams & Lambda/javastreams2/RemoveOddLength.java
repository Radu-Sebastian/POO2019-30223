package javastreams2;
import java.util.*;

public class RemoveOddLength 
{
    public static void main(String[] args) 
    {
        List<String> myList = new ArrayList<>();
        myList.add("Oriented");
        myList.add("Object");
        myList.add("Programming");
        myList.forEach(x -> System.out.println(x));
        myList.removeIf(x -> x.length() % 2 == 1);
        System.out.println(" \nOdd removed \n");
        myList.forEach(x -> System.out.println(x));
    }
}