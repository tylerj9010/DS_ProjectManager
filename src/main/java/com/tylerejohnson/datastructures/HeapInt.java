/** BASIC INT HEAP **/


package com.tylerejohnson.datastructures;

import java.util.Arrays;

public class HeapInt {
	private int[] heap = new int[10];
	private int size;
	
	public HeapInt() {
		
	}
	
	public void insert(int value) {
		if(isFull())
			resize();
		
		heap[size++] = value;
		bubbleUp();
	}
	
	
	//while current index is > parent and not root, bubble up
	private void bubbleUp() {
		int index = size - 1;
		while (index > 0 && heap[index] > heap[parent(index)]) {
			swap(index, parent(index));
			index = parent(index);
		}
	}
	
	public int remove() {
		if (isEmpty()) {
			throw new IllegalStateException();
		}
		
		int root = heap[0];
		heap[0] = heap[--size];
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
		
		boolean isValid = heap[index] >= leftVal(index);
		if(!hasRight(index))
			isValid &= heap[index] >= rightVal(index);
		
		return isValid;
	}
	
	private int findLargerChild(int index) {
		if(!hasLeft(index))
			return index;
		
		if(!hasRight(index))
			return left(index);
		
		return (leftVal(index) > rightVal(index)) ? left(index) : right(index);
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
	
	private int leftVal(int index) {
		return heap[left(index)];
	}
	
	/**/
	private int rightVal(int index) {
		return heap[right(index)];
	}
	
	private void swap(int first, int second) {
		int temp = heap[first];
		heap[first] = heap[second];
		heap[second] = temp;
	}
	
	private boolean isFull() {
		return heap.length == size;
	}
	private boolean isEmpty() {
		return 0 == size;
	}
	
	private void resize() {
		int[] temp = Arrays.copyOf(heap, size+5);
		heap = temp;
	}
}
