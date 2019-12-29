package javastreams1;
import java.util.*;
import java.util.stream.*;

public class FirstLetterString 
{
    public static void main(String[] args) 
    {
        List<String> myList = new ArrayList<>();
        myList.add("Oriented");
        myList.add("Object");
        myList.add("Programming");
        String result = myList
            .stream()
            .map(s -> s.substring(0,1))
            .collect(Collectors.joining());
        System.out.println(result); 
    }
}