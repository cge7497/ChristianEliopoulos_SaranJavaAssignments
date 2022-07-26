package com.hcl.A4;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetToArray {
	
	public static void main(String[] args) {
		HashSet<Integer> hs = new HashSet<Integer>();
		hs.add(1);
		hs.add(2);
		hs.add(3);
		hs.add(4);
		hs.add(5);
		hs.add(6);
		hs.add(7);
		hs.add(8);
		hs.add(9);
		System.out.println("Hash set: " + hs.toString());
			
		int[] array = convertHashSetToArray(hs);
		
		// Prints out contents of array/
		System.out.print("Array: " + array[0]);
		for (int i =1; i < array.length; i++) {
			System.out.print(", " + array[i]);
		}
	}
	
	static int[] convertHashSetToArray(HashSet<Integer> hs) {
		
		int[] array = new int[hs.size()];

		Iterator<Integer> it = hs.iterator();
		int c = 0;
		
		// Iterates through each element of the hash set. Cannot do a for loop, as hash set does not have indices.
		while(it.hasNext()) {
			array[c] = it.next();
			c++; // increment the array index in tandem with next hash set value.
		}
		
		return array;
	}
}
