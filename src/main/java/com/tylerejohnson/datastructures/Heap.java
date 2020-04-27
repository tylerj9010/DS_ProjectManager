package com.tylerejohnson.datastructures;

import java.util.ArrayList;
import java.util.List;

public class Heap<Key extends Comparable<Key>, Value> {
	protected List<Pair<Key, Value>> heap = new ArrayList<Pair<Key,Value>>();
//	private Integer[] heap = new Integer[10];
	protected int size = 0;
	
	public Heap() {
		
	}
	

	
	
	public void insert(Pair<Key, Value> pair) {
		
		if (heap.size() <= size) {
			heap.add(pair);
		}
		else {		
			heap.set(size, pair);
		}
		size++;
		bubbleUp();
	}
	
	
	//while current index is > parent and not root, bubble up
	private void bubbleUp() {
		int index = size - 1;
		while (index > 0 && heap.get(index).getKey().compareTo(heap.get(parent(index)).getKey()) > 0) {
			swap(index, parent(index));
			index = parent(index);
		}
	}
	
	public Pair<Key, Value> remove() {
		if (isEmpty()) {
			throw new IllegalStateException();
		}
		
		Pair<Key, Value> root = heap.get(0);
		heap.set(0, heap.get(--size));
		bubbleDown();
		
		return root;
	}
	
	private void bubbleDown() {
		int index = 0;
		
		while(index <= size && !isValidParent(index)) {
			int largerChild = findLargerChild(index);
			swap(index, largerChild);
			index = largerChild;
		}
	}
	
	private boolean isValidParent(int index) {
		if(!hasLeft(index))
			return true;
		
		boolean isValid = heap.get(index).getKey().compareTo(leftVal(index).getKey()) >= 0;
		if(hasRight(index))
			isValid &= heap.get(index).getKey().compareTo(rightVal(index).getKey()) >= 0;
		
		return isValid;
	}
	
	private int findLargerChild(int index) {
		if(!hasLeft(index))
			return index;
		
		if(!hasRight(index))
			return left(index);
		
		return (leftVal(index).getKey().compareTo(rightVal(index).getKey()) > 0) ? left(index) : right(index);
	}
	
	private boolean hasLeft(int index) {
		return left(index) <= size;
	}
	
	private boolean hasRight(int index) {
		return right(index) <= size;
	}
	
	/*returns index of parent using 'x = (index - 1) / 2'*/
	private int parent(int index) {
		return (index - 1) / 2;
	}
	
	/**/
	private int left(int index) {
		return index * 2 + 1;
	}
	
	/**/
	private int right(int index) {
		return index * 2 + 2; 
	}
	
	private Pair<Key, Value> leftVal(int index) {
		return heap.get(left(index));
	}
	
	/**/
	private Pair<Key, Value> rightVal(int index) {
		return heap.get(right(index));
	}
	
	private void swap(int first, int second) {
		Pair<Key, Value> temp = heap.get(first);
		heap.set(first, heap.get(second));
		heap.set(second, temp);
	}
	
//	private boolean isFull() {
//		return heap.length == size;
//	}
	private boolean isEmpty() {
		return 0 == size;
	}
	

}
