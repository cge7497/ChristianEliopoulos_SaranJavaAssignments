package com.hcl.A4;

import java.util.LinkedList;

public class Iterate {
	
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		list.add("Aaron");
		list.add("Christian");
		list.add("David");
		list.add("Joseph");
		list.add("Johnny");
		list.add("Bob");
		list.add("George");
		
		int index = 3;
		System.out.println("Iterate through list starting at index " + index);
		iterate(list, index);
	}

	static void iterate(LinkedList<String> list, int startIndex) {
		int size = list.size();
		
		if (startIndex > size - 1) {
			System.out.println("The start index is larger than the size of the list. Please choose a smaller start index.");
		}
		
		for (int i = startIndex; i < size; i++) {
			System.out.println(list.get(i));
		}
	}
}
