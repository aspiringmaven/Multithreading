package me.sumitkawatra.java8.concept.collection;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * reducer method to reduce stream in to one value
 * @author sumit
 *
 */
public class Stream5 {
	
	private static final List<Emp> employees = Arrays.asList(
			new Emp[] { 
					new Emp("K", 3, "HR", 300),
					new Emp("B", 2, "IT", 100),
					new Emp("D", 4, "HR", 400),
					new Emp("E", 5, "Finance", 200),
					new Emp("A", 1, "IT", 100)
			});
	
	public static void main(String[] args) {
		
		/**
		 * reduce to find sum of salary
		 */
		Long totalSalary = employees.stream().map(emp -> emp.getSalary()).reduce(0L, (sal1,sal2) -> sal1+sal2);
		System.out.println(employees);
		List<Emp> employees2 = employees.stream().sorted((e1,e2)->{return e1.getName().compareTo(e2.getName());}).collect(Collectors.toList());
		System.out.println(employees2);
		
		System.out.println("totalSalary = " + totalSalary);
		
		/**
		 * reduce to ind 
		 */
		 employees.stream().map(emp -> emp.getSalary()).reduce(Math::max).ifPresent(System.out::println);
	}

}
