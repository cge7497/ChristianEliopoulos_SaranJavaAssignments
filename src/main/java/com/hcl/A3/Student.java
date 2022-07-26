package com.hcl.A3;

public class Student {

	public static void main(String[] args) {
		Student student = new Student();
		student.input("Christian");
		student.average(25, 50.5, 60.25);
		student.average(95.5, 80.2, 90.4);
	}
	
	boolean average(double g1, double g2, double g3) {
		double avg = (g1 + g2 + g3) / 3;
		if (avg > 50) {
			System.out.println("The student has passed with an average of " + avg + "%");
		}
		else {
			System.out.println("The student failed with an average of " + avg + "%");
		}
		return false;
	}
	
	String input(String name) {
		System.out.println("Added student named " + name);
		return name;
	}
}
