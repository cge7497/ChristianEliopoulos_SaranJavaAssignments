package com.hcl.A2;

import java.util.Scanner;

public class SwapVariables {
	public static void main(String[] args) {
		String val1 = "", val2 = "";
		boolean haveVals = false;

		// Get two integers from user. Catch exception and ask again until user inputs integer.
		do {
			try {
				Scanner scanner = new Scanner(System.in);
				System.out.println("Enter first value: ");
				val1 = scanner.nextLine();
				System.out.println("Enter second value: ");
				val2 = scanner.nextLine();
				scanner.close();
				haveVals = true;
			} catch (Exception e) {
				System.out.println("Error: Please enter a value.");
			}
		} while (!haveVals);

		System.out.println(String.format("First value before swap: " + val1));
		System.out.println(String.format("Second value before swap: " + val2));

		// Swaps the two values, which requires creating a temporary copy of one of them.
		String tempVal1 = val1;
		val1 = val2;
		val2 = tempVal1;
		
		System.out.println(String.format("\nFirst value after swap: " + val1));
		System.out.println(String.format("Second value after swap: " + val2));
		
		
	}
	

}
