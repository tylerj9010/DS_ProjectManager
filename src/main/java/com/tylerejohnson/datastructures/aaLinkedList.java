package com.tylerejohnson.datastructures;
//package com.tylerejohnson.datastructures;
//
//public class LinkedList<Key extends Comparable<Key>, Value> {
//	private static class Node<Key extends Comparable<Key>, Value> {
//		private Pair<Key, Value> data;
//		private Node<Key, Value> nextAddress;
//		
//		public Node() {}
//		
//	}
//	
//	private Node<Key, Value> first;
//	@SuppressWarnings("unused")
//	private Node<Key, Value> last;
//	public int size = 0;
//	
//	public LinkedList() {
//	}
//	
//	public void insert(Pair<Key, Value> pair) {
//		Node<Key, Value> node = new Node<>();
//		node.data = pair;
//		
//		if (first == null) 
//			first = last = node;
//		else {
//			Node<Key, Value> i = first;
//			while (i != null) {
//				if (pair.getKey().compareTo(i.data.getKey()) < 0) {
//					node.nextAddress = i;
//					first = node;
//					node = i;
//				}
//				if (i.nextAddress == null) {
//					i.nextAddress = node;
//					node.nextAddress = null;
//					break;
//				} else if (pair.getKey().compareTo(i.data.getKey()) > 0) {
//					node.nextAddress = i.nextAddress;
//					i.nextAddress = node;
//					break;
//				}
//				i = i.nextAddress;
//			}
//		}
//		size++;
//	}
//	
//	public Pair<Key, Value> get() {
//		return null;
//		
//	}
//	
//	public void selectionSort() {
//		
//	}
//
//	@Override
//	public String toString() {
//		return "LinkedList [first=" + first + ", last=" + last + ", size=" + size + "]";
//	}
//	
//	
//	
//	
//}
