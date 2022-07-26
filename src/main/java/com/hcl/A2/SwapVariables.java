package com.hcl.A2;

import java.util.Scanner;

public class SwapVariables {
	public static void main(String[] args) {
		String val1 = "", val2 = "";
		boolean haveVals = false;

		// Get integer from user. Catch exception and ask again until user inputs integer.
		do {
			try {
				Scanner scanner = new Scanner(System.in);
				System.out.println("Enter first value");
				val1 = scanner.nextLine();
				System.out.println("Enter second value");
				val2 = scanner.nextLine();
				haveVals = true;
				scanner.close();
			} catch (Exception e) {
				System.out.println("Error: Please enter a value.");
			}
		} while (!haveVals);

		System.out.println("First value before swap: " + val1);
		System.out.println("Second value before swap: " + val2);


		// Swaps the values, which requires making a temporary copy of val1.
		String tempVal = val1;
		val1 = val2;
		val2 = tempVal;
		
		System.out.println("First value after swap: " + val1);
		System.out.println("Second value after swap: " + val2);
		
	}

}

