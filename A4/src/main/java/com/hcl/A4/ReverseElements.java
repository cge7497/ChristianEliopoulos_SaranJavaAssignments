package com.hcl.A4;

import java.util.ArrayList;


public class ReverseElements {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		System.out.println("Before reversal: " + list.toString());
		reverseElements(list);
		System.out.println("After reversal: " + list.toString());
	}

	static void reverseElements(ArrayList<Integer> list) {
		int size = list.size();

		// There is also a Collections.reverse() method. I wasn't sure if we were to use it.
		for (int i =0; i < size / 2; i++) {
			int j = size - i - 1;
			int tempInt = list.get(j);
			
			list.set(j, list.get(i));
			list.set(i, tempInt);
		}
	}
}
