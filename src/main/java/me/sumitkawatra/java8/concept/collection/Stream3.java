package me.sumitkawatra.java8.concept.collection;

import java.util.Arrays;
import java.util.List;

public class Stream3 {

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
		 * Distinct departments
		 */
		System.out.println("Distict departments\n");
		employees.stream().map(Emp::getDept).distinct().forEach(System.out::println);
		
		System.out.println("");
		/**
		 * Only HR Employees in sorted per name
		 */
		employees.stream().filter(emp->"HR".equals(emp.getDept())).sorted((e1,e2)->e1.getName().compareTo(e2.getName())).forEach(System.out::println);
		
		System.out.println("");
		
		/**
		 * Only IT Emp sorted by Id
		 */
		employees.stream().filter(emp->"IT".equals(emp.getDept())).sorted((e1,e2)->e1.getId() - e2.getId()).forEach(System.out::println);
		
		
		/**
		 * Total expense
		 */
		Long totalExpense = employees.stream().map(emp->emp.getSalary()).reduce(0L, (e1,e2)-> e1+e2);
		
		System.out.println("totalExpense > " + totalExpense);
		
		
		/**
		 * Max salary
		 */
		employees.stream().map(emp->emp.getSalary()).reduce(Long::max).ifPresent(System.out::println);;
		
		
		/**
		 * Total Employee
		 */
		System.out.println("Total emp = " + employees.stream().count());
		
		
		
	}

}

class Emp {

	private String name;
	private int id;
	private String dept;
	private long salary;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Emp [name=" + name + ", id=" + id + ", dept=" + dept + ", salary=" + salary + "]";
	}

	public Emp(String name, int id, String dept, long salary) {
		super();
		this.name = name;
		this.id = id;
		this.dept = dept;
		this.salary = salary;
	}

}
