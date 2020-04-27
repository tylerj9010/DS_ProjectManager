package com.tylerejohnson.datastructures;

import java.util.List;

public class MaxHeap {

	public static void heapify(List<String> array) {
		int lastParent = array.size() / 2 - 1;
		for (int i = lastParent; i >= 0; i--) 
			heapify(array, i);
	}
	
	
	private static void heapify(List<String> array, int index) {
		int larger = index;
		
		int left = index * 2 +1;
		if (left < array.size() && compare(array.get(left), array.get(larger))) {
			larger = left;
		}
		
		int right = index * 2 + 2;
		if (right < array.size() && compare(array.get(right), array.get(larger))) {
			
			larger = right;
		}
		
		if (index == larger)
			return;
		
		swap(array, index, larger);
		heapify(array, larger);
	}
	
	private static boolean compare(String s1, String s2) {
		return s1.compareTo(s2) > 0;
	}
	
	private static void swap(List<String> array, int first, int second) {
		String temp = array.get(first);
		array.set(first, array.get(second));
		array.set(second, temp);
	}
}
