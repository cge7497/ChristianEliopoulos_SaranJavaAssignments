package com.hcl.A2;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class Fibonacci {
	public static void main(String[] args) {
		int number = 0;
		boolean haveInt = false;

		// Get integer from user. Catch exception and ask again until user inputs integer.
		do {
			try {
				Scanner scanner = new Scanner(System.in);
				System.out.println("Enter number to see it Fibonacci sequence");
				number = scanner.nextInt();
				haveInt = true;
				scanner.close();
			} catch (Exception e) {
				System.out.println("Error: Please enter an int");
			}
		} while (!haveInt);

		
		int c = 0;
		int prevNumber1 = 0, prevNumber2 = 0, fNumber = 1;
		
		System.out.print(String.format("Fibonacci Sequence of %d: 0", number));
		while (number > c) {
			System.out.print(", " + fNumber);
			prevNumber2 = prevNumber1;
			prevNumber1 = fNumber;
			fNumber = prevNumber1 + prevNumber2;
			c++;
		}
		
	}
}
