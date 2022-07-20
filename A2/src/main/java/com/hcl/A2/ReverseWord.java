package com.hcl.A2;

import java.util.Scanner;

public class ReverseWord {
	
	public static void main(String[] args) {
		String string = "";
		boolean hasString = false;
		
		// Get two integers from user. Catch exception and ask again until user inputs integer.
		do {
			try {
				Scanner scanner = new Scanner(System.in);
				System.out.println("Enter first value: ");
				string = scanner.nextLine();
				scanner.close();
				hasString = true;
			} catch (Exception e) {
				System.out.println("Error: Please enter a value.");
			}
		} while (!hasString);


		char[] string_char = string.toCharArray();
		final int length = string_char.length;
		char[] reversed_array = new char[length];
		
		// Sets the reversed_Arrays values, which is the string_char values looped through in reverse.
		for (int i =0; i< length; i++) {
			reversed_array[i] = string_char[length - i - 1];
		}
		
		String reversed_String = new String(reversed_array);
		System.out.println("Reversed string: " + reversed_String);
	}
	
}
