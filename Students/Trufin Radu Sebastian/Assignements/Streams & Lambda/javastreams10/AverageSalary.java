package javastreams10;
import java.util.*;

public class AverageSalary 
{
    public static void main(String[] args) 
    {
        List<Employee> myList = new ArrayList<>();
        Employee firstEmployee = new Employee("Ivan",20,50);
        Employee secondEmployee = new Employee("Ivanovic",25,100);
        Employee thirdEmployee = new Employee("Ivanovski",30,150);
        myList.add(firstEmployee);
        myList.add(secondEmployee);
        myList.add(thirdEmployee);
        
        myList.stream()
        		.map(Employee::getSalary)
        		.mapToDouble(i -> i)
        	    .average()
        	    .ifPresent(avg -> System.out.println("Average found is " + avg)); 
    }
}