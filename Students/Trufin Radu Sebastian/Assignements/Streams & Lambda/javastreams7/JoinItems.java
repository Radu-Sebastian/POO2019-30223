package javastreams7;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JoinItems 
{
	public static void main(String[] args) 
    {
		List<String> myList = new ArrayList<>();
        myList.add("Oriented");
        myList.add("Object");
        myList.add("Programming");
        String result = myList
            .stream()
            .map(s -> s + "-")
            .collect(Collectors.joining());
        System.out.println(result); 
    }
}
	