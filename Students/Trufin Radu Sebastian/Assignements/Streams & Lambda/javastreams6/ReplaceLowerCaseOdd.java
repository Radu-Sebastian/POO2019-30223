package javastreams6;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReplaceLowerCaseOdd 
{
    public static void main(String[] args) 
    {
        List<String> myList = new ArrayList<>();
        myList.add("Oriented");
        myList.add("Object");
        myList.add("Programming");
        
        myList.removeIf(x -> x.length() % 2 != 1);
        List<String> outputList = myList.stream().map(x -> x.toUpperCase()).collect(Collectors.toList());
        System.out.println(outputList);
    }
}