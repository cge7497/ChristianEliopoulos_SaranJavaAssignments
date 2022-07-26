package com.hcl.A2;

import java.util.Scanner;

public class PrimeNumber {
	
	public static void main(String[] args) {
		int number = 0;
		boolean haveInt = false;

		// Get integer from user. Catch exception and ask again until user inputs integer.
		do {
			try {
				Scanner scanner = new Scanner(System.in);
				System.out.println("Enter number to see if it is prime.");
				number = scanner.nextInt();
				haveInt = true;
				scanner.close();
			} catch (Exception e) {
				System.out.println("Error: Please enter an int");
			}
		} while (!haveInt);

		// Check all factors between 2 and half of the number.
		final int maxFactor= Math.floorDiv(number, 2);
		int f = 2;
		while (f <= maxFactor) {
			// If there is no remainder, it means the number is prime. Exit the function.
			if ((number % f == 0)) {
				System.out.println(String.format("The number %d is NOT prime.", number));
				return;
			}
			f++;
		}
		
		System.out.println(String.format("The number %d IS prime.", number));
		
	}

}
