package com.hcl.A2_final;

import java.util.Scanner;

public class SumOfInts {
	public static void main(String[] args) {
		int num1 = 0, num2 = 0, sumGuess = 0;
		boolean haveInts = false;

		// Get integer from user. Catch exception and ask again until user inputs
		// integer.
		do {
			try {
				Scanner scanner = new Scanner(System.in);
				System.out.println("Enter first number: ");
				num1 = scanner.nextInt();
				System.out.println("Enter second number: ");
				num2 = scanner.nextInt();
				System.out.println("Enter sum of the two numbers: ");
				sumGuess = scanner.nextInt();
				haveInts = true;
				scanner.close();
			} catch (Exception e) {
				System.out.println("Error: Please enter an int");
			}
		} while (!haveInts);

		final int sum = num1 + num2;

		isSumCorrect(sumGuess, sum);
	}

	static boolean isSumCorrect(int sumGuess, int sum) {
		if (sum == sumGuess) {
			System.out.println("Correct!");
			return true;
		} else {
			System.out.println("Incorrect. The sum is " + sum);
			return false;
		}

	}
}
