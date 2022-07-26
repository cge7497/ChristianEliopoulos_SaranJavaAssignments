package com.hcl.A2;

import java.util.Scanner;

public class ReverseString {

	public static void main(String[] args) {
		String string = "";
		boolean haveVal = false;

		// Get integer from user. Catch exception and ask again until user inputs integer.
		do {
			try {
				Scanner scanner = new Scanner(System.in);
				System.out.println("Enter string: ");
				string = scanner.nextLine();
				haveVal = true;
				scanner.close();
			} catch (Exception e) {
				System.out.println("Error: Please enter a string.");
			}
		} while (!haveVal);

		
		final int length = string.length();
		char[] charArray = string.toCharArray();
		char[] reverseCharArray = new char[length];
		for (int i=0; i < length; i++) {
			reverseCharArray[i] = charArray[length - i - 1];
		}
		
		String reverseString = new String(reverseCharArray);
		System.out.println("Reversed String: " + reverseString);
	}
}

