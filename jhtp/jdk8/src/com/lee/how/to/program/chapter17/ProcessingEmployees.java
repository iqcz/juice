package com.lee.how.to.program.chapter17;

//Fig. 17.10: ProcessingEmployees.java
// Processing streams of Employee objects.
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProcessingEmployees {
	public static void main(String[] args) {
		// initialize array of Employees
		Employee[] employees = { 
				new Employee("Jason", "Red", 5000, "IT"), 
				new Employee("Ashley", "Green", 7600, "IT"),
				new Employee("Matthew", "Indigo", 3587.5, "Sales"),
				new Employee("James", "Indigo", 4700.77, "Marketing"), 
				new Employee("Luke", "Indigo", 6200, "IT"),
				new Employee("Jason", "Blue", 3200, "Sales"), 
				new Employee("Wendy", "Brown", 4236.4, "Marketing") 
		};

		// get List view of the Employees
		List<Employee> list = Arrays.asList(employees);

		// display all Employees
		System.out.println("Complete Employee list:");
		list.stream().forEach(System.out::println);
		
		System.out.println("========================");
		
		Predicate<Employee> four2sixthousand = e -> e.getSalary() >= 4000 && e.getSalary() <= 6000;
		
		list.stream().filter(four2sixthousand).sorted(Comparator.comparing(Employee::getSalary)).forEach(System.out::println);
		System.out.println("========================");
		
		Stream<Employee> sortedList = list.stream().filter(four2sixthousand).sorted(Comparator.comparing(Employee::getSalary));
		Iterator<Employee> iter = sortedList.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println("========================");
		
		
		// get first element.
		Employee e = list.stream().filter(four2sixthousand).sorted(Comparator.comparing(Employee::getSalary)).findFirst().get();
		System.out.println(e);
		System.out.println("========================");

		Function<Employee, String> byFirstName = Employee::getFirstName;
		Function<Employee, String> byLastName = Employee::getLastName;
		
		Comparator<Employee> lastThenFist = Comparator.comparing(byLastName).thenComparing(byFirstName);
		
		// sort employees by last name, then first name
		System.out.printf("%nEmployees in ascending order by last name then first:%n");
		
		List<String> lowSalaryEmployeeName = list.parallelStream()
				.filter(d -> d.getSalary() < 4000)
				.sorted(Comparator.comparing(Employee::getSalary))
				.map(Employee::getName)
				.collect(Collectors.toList());
		
		
		System.out.println(lowSalaryEmployeeName);
		
		// TODO for others operations. 
		
	}
}
