package javastreams8;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Infinite2PowerSeries 
{
	public static void main(String[] args) 
    {
		Stream<Integer> infiniteStream = Stream.iterate(1, x -> x * 2);
		 
		List<Integer> collect = infiniteStream
		  .limit(31)
		  .collect(Collectors.toList());
		 
		System.out.println(collect);
    }
}
	