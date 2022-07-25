package com.hcl.A5;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Employee {
	int id;
	int age;
	int yearOfJoining;
	int salary;
	String name;
	String gender;
	String dept;
}

class SalComparator implements Comparator {
	public int compare(Object o1, Object o2) {
		Employee e1 = (Employee) o1;
		Employee e2 = (Employee) o2;
		if (e1.salary == e2.salary) {
			return 0;
		} else if (e1.salary > e2.salary) {
			return 1;
		} else
			return -1;
	}
}

class AgeComparator implements Comparator {
	public int compare(Object o1, Object o2) {
		Employee e1 = (Employee) o1;
		Employee e2 = (Employee) o2;
		if (e1.age == e2.age) {
			return 0;
		} else if (e1.age > e2.age) {
			return 1;
		} else
			return -1;
	}
}

public class A5 {

	static int totalAge = 0;
	static Employee hightestPaid;
	static Employee mostSenior;

	public static void main(String[] args) {
		Map<Employee, Integer> empMap = new HashMap<>();

		empMap.put(new Employee(1, 35, 2000, 62000, "Katherine", "Female", "R & D"), 10);
		empMap.put(new Employee(2, 32, 2020, 51000, "Anna", "Female", "R & D"), 90);
		empMap.put(new Employee(3, 40, 2001, 60000, "Stephen", "Male", "Maintenance"), 100);
		empMap.put(new Employee(4, 50, 2005, 54000, "Clay", "Male", "Finances"), 80);
		empMap.put(new Employee(5, 48, 2001, 68000, "Hannah", "Female", "Finances"), 40);
		empMap.put(new Employee(6, 50, 2002, 90000, "Cassidy", "Female", "HR"), 30);
		empMap.put(new Employee(7, 25, 2019, 64000, "Christian", "Male", "IT"), 20);
		empMap.put(new Employee(8, 24, 2022, 70000, "Rachid", "Male", "IT"), 50);
		empMap.put(new Employee(9, 62, 2010, 52000, "Isaac", "Male", "Maintenance"), 97);
		empMap.put(new Employee(10, 64, 2001, 65000, "Maria", "Female", "IT"), 32);

		// Prompt 1
		{
			// I got this idea for stream.filter from https://stackoverflow.com/a/51686487
			long maleCount = empMap.keySet().stream().filter(e -> e.gender == "Male").count();
			long femaleCount = empMap.keySet().stream().filter(e -> e.gender == "Female").count();

			System.out.println("There are " + maleCount + " males and " + femaleCount + " female employees.");
		}
		// Prompt 2
		{
			empMap.forEach((emp, val) -> {
				totalAge += emp.age;
			});
			double avgAge = totalAge / empMap.size();
			System.out.println(String.format("The average age is %1.2f", avgAge));
		}
		// Prompt 3
		{
			TreeMap<Employee, Integer> salMap = new TreeMap<Employee, Integer>(new SalComparator());
			salMap.putAll(empMap);
			final Employee highestPaid = salMap.lastKey();
			System.out.println("The highest paid employee is " + highestPaid.name + " who is paid " + highestPaid.salary);
		}
		// Prompt 4
		{
			long employeesSince2015 = empMap.keySet().stream().filter(e -> e.yearOfJoining > 2015).count();
			System.out.println("There have been " + employeesSince2015 + " employees who have joined since 2015.");
		}
		// Prompt 5
		{
			TreeMap<Employee, Integer> ageMap = new TreeMap<Employee, Integer>((e1, e2) -> {
				if (e1.age == e2.age) {
					return 0;
				} else if (e1.age > e2.age) {
					return 1;
				} else
					return -1;
			});
			ageMap.putAll(empMap);

			final Employee oldest = ageMap.lastKey();
			System.out.println("The oldest employee is " + oldest.name + " who is " + oldest.age + " years old.");
		}
		// Prompt 6
		{
			long maintenanceCount = empMap.keySet().stream().filter(e -> e.dept == "Maintenance").count();
			long r_and_d_Count = empMap.keySet().stream().filter(e -> e.dept == "R & D").count();
			long HRCount = empMap.keySet().stream().filter(e -> e.dept == "HR").count();
			long ITCount = empMap.keySet().stream().filter(e -> e.dept == "IT").count();
			System.out.println(String.format("Employees per department: Maintenance: %d, R&D: %d, HR: %d, IT: %d",
					maintenanceCount, r_and_d_Count, HRCount, ITCount));
		}
		// Prompt 7
		{
			long maintenance_Male_Count = empMap.keySet().stream().filter(e -> e.dept == "Maintenance" && e.gender == "Male").count();
			long maintenance_Female_Count = empMap.keySet().stream().filter(e -> e.dept == "Maintenance" && e.gender == "Female").count();
			System.out.println(String.format("Male and Female maintenance employees: %d male, and % female", maintenance_Male_Count, maintenance_Female_Count ));
		}
		// Prompt 8
		{

		}
		// Prompt 9
		{
			empMap.keySet().stream().filter(e -> e.age >= 30);
		}
	}
}
