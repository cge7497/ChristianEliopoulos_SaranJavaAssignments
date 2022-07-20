package com.hcl.A2;

import java.util.Scanner;

public class SumOfInts {
	public static void main(String[] args) {
		int num1 = 0, num2 = 0, sum = 0;
		boolean haveInts = false;

		// Get integer from user. Catch exception and ask again until user inputs integer.
		do {
			try {
				Scanner scanner = new Scanner(System.in);
				System.out.println("Enter the first number: ");
				num1 = scanner.nextInt();
				System.out.println("Enter the second number: ");
				num2 = scanner.nextInt();
				System.out.println("Enter the sum of the two numbers: ");
				sum = scanner.nextInt();
				haveInts = true;
				scanner.close();
			} catch (Exception e) {
				System.out.println("Error: Please enter an int");
			}
		} while (!haveInts);

		
		int correctSum = num1 + num2;
		checkCorrectSum(sum, correctSum);
		
	}
	
	static boolean checkCorrectSum(int sum, int correctSum) {
		if (sum == correctSum) {
			System.out.println("Correct!");
			return true;
		}
		else {
			System.out.println("Incorrect: The sum is " + correctSum);
			return false;
		}
	}

}
