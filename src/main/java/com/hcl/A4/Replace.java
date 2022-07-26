package com.hcl.A4;

import java.util.LinkedList;

public class Replace {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(2);
		list.add(3);
		list.add(1);
		list.add(5);
		list.add(3);
		list.add(7);

		System.out.println("List before replacing 2s with 9s: " + list.toString());
		replace(list, 2, 9);
		System.out.println("After replacement: " + list.toString());
	}

	static void replace(LinkedList<Integer> list, int el, int newEl) {
		// While the list still contains the value- meaning this will replace all occurrences of value in list.
		while (list.contains(el)) {
			int index = list.indexOf(el);
			list.set(index, newEl);
		}
	}

}
