package com.tylerejohnson.sorting;

import java.util.ArrayList;
import java.util.List;

import com.tylerejohnson.datastructures.Heap;
import com.tylerejohnson.datastructures.Pair;


/*Heap Sort*/
/*Sorting algorithm*/

public class HeapSort<Key extends Comparable<Key>, Value> extends Heap<Key, Value>{

	/*sorting which sorts in ascending order*/
	public List<Value> sortAscending(List<Pair<Key, Value>> list) {
		heapify(list);
		
		List<Value> sortedList = new ArrayList<Value>(); 
		for (int i = 0; i < list.size(); i++)
			sortedList.add(null);
		for (int i = list.size() - 1; i >= 0; i--) 
			sortedList.set(i, this.remove().getValue());
		return sortedList;
	}
	
	/*sorting which sorts in descending order*/
	public List<Value> sortDescending(List<Pair<Key, Value>> list) {
		heapify(list);
		
		List<Value> sortedList = new ArrayList<Value>(); 
		
		for (int i = list.size() - 1; i >= 0; i++) 
			sortedList.add(this.remove().getValue());
		return sortedList;
	}
	
	/*recursive method which takes a list and returns a list that follows heap rules*/
	private void heapify(List<Pair<Key, Value>> list) {
		int lastParent = list.size() / 2 - 1;
		for (int i = lastParent; i >= 0; i--) 
			heapify(list, i);
		heap = list;
		size = heap.size();
	}
	
	private void heapify(List<Pair<Key, Value>> list, int index) {
		int larger = index;
		
		int left = index * 2 + 1;
		if (left < list.size() && compare(list.get(left).getKey(), list.get(larger).getKey()))
			larger = left;
		
		int right = index * 2 + 2;
		if (right < list.size() && compare(list.get(right).getKey(), list.get(larger).getKey()))
			larger = right;
		
		if (index == larger)
			return;
		
		swap(list, index, larger);
		heapify(list, larger);
	}
	
	/*swap method*/
	private void swap(List<Pair<Key, Value>> list, int first, int second) {
		Pair<Key, Value> temp = list.get(first);
		list.set(first, list.get(second));
		list.set(second, temp);
	}
	
	/*compares two keys*/
	private boolean compare(Key key, Key key2) {
		return key.compareTo(key2) > 0;
	}
}
