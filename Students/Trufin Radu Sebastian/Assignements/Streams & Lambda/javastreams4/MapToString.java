package javastreams4;

import java.util.*;
import java.util.stream.*;
public class MapToString
{
    public static void main(String[] args) throws Exception 
    {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Oriented");
        map.put(2, "Object");
        map.put(3, "Programming");
        String rez = map.entrySet()
            .stream()
            .map(entry -> entry.getKey() + " - " + entry.getValue())
            .collect(Collectors.joining(", "));
        System.out.println(rez);
    }
}