package com.tylerejohnson.datastructures;

import java.util.ArrayList;
import java.util.List;

/*Heap Data Structure*/
/*Data Structure #1*/


/*generic heap implementation*/
/*uses a array list of generic pairs*/
/*key = thing to compare and identify value
 *value = object that is being sorted and used*/
public class Heap<Key extends Comparable<Key>, Value> {
	protected List<Pair<Key, Value>> heap = new ArrayList<Pair<Key,Value>>();
	protected int size = 0;
	
	/*constructor*/
	public Heap() {
		
	}
	
	/*insert method
	 *used to insert item into heap
	 *Parameter: generic pair<Key, Value>*/
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
	
	/*bubbleUp method
	 *while current index is > parent and not root, bubble up*/
	private void bubbleUp() {
		int index = size - 1;
		while (index > 0 && heap.get(index).getKey().compareTo(heap.get(parent(index)).getKey()) > 0) {
			swap(index, parent(index));
			index = parent(index);
		}
	}
	
	/*remove method
	 *removes root node*/
	public Pair<Key, Value> remove() {
		if (isEmpty()) {
			throw new IllegalStateException();
		}
		
		Pair<Key, Value> root = heap.get(0);
		heap.set(0, heap.get(--size));
		bubbleDown();
		
		return root;
	}
	
	/*bubbleDown method
	 *pushes nodes down until they are in correct spot*/
	private void bubbleDown() {
		int index = 0;
		
		while(index <= size && !isValidParent(index)) {
			int largerChild = findLargerChild(index);
			swap(index, largerChild);
			index = largerChild;
		}
	}
	
	/*isValidParent method
	 *checks to see if the parent is valid by comparing 
	 	values to left and right children*/
	private boolean isValidParent(int index) {
		if(!hasLeft(index))
			return true;
		
		boolean isValid = heap.get(index).getKey().compareTo(leftVal(index).getKey()) >= 0;
		if(hasRight(index))
			isValid &= heap.get(index).getKey().compareTo(rightVal(index).getKey()) >= 0;
		
		return isValid;
	}
	
	/*findLargerChild method
	 *finds if left or right child is larger*/
	private int findLargerChild(int index) {
		if(!hasLeft(index))
			return index;
		
		if(!hasRight(index))
			return left(index);
		
		return (leftVal(index).getKey().compareTo(rightVal(index).getKey()) > 0) ? left(index) : right(index);
	}
	
	/*hasLeft method
	 *finds if left child exists*/
	private boolean hasLeft(int index) {
		return left(index) <= size;
	}
	
	/*hasRight method
	  *finds if right child exists*/
	private boolean hasRight(int index) {
		return right(index) <= size;
	}
	
	/*returns index of parent using 'x = (index - 1) / 2'*/
	private int parent(int index) {
		return (index - 1) / 2;
	}
	
	/*returns index of left using 'x = index * 2 + 1'*/
	private int left(int index) {
		return index * 2 + 1;
	}
	
	/*returns index of right using 'x = index * 2 + 2'*/
	private int right(int index) {
		return index * 2 + 2; 
	}
	
	/*returns left child value*/
	private Pair<Key, Value> leftVal(int index) {
		return heap.get(left(index));
	}
	
	/*returns right child value*/
	private Pair<Key, Value> rightVal(int index) {
		return heap.get(right(index));
	}
	
	/*swap method
	 *swaps first and second parameters in heap list*/
	private void swap(int first, int second) {
		Pair<Key, Value> temp = heap.get(first);
		heap.set(first, heap.get(second));
		heap.set(second, temp);
	}
	
	/*returns if empty*/
	private boolean isEmpty() {
		return 0 == size;
	}
	

}
