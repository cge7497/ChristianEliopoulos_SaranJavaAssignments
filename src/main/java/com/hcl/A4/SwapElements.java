package com.hcl.A4;

import java.util.ArrayList;

public class SwapElements {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Aaron");
		list.add("Christian");
		list.add("David");
		list.add("Joseph");
		System.out.println("Before swapping: " + list.toString());
		swapElements(list, 1, 3);
		System.out.println("After swapping: " + list.toString());
	}

	static void swapElements(ArrayList<String> list, int ind1, int ind2) {
		String temp = list.get(ind1);
		list.set(ind1, list.get(ind2));
		list.set(ind2, temp);
		
	}
}
