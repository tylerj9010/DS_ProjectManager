package com.tylerejohnson.datastructures;

/*Queue Data Structure*/
/*Data Structure #2*/

/*generic queue implementation*/
/*uses arrays and int pointers*/
public class Queue<T> {
	private T[] queue;
	private int count = 0;
	private int rear = 0;
	private int front = 0; 
	private int size;
	
	/*constructor*/
	@SuppressWarnings("unchecked")
	public Queue(int size) {
		this.size = size;
		queue = (T[]) new Object[size];
	}
	
	/*enqueue method
	 *adds item to queue
	 *parameter: generic item to be inserted*/
	public void enqueue(T t) {
		if (isFull())
			throw new IllegalStateException();
		queue[rear++] = t;
		count++;
	}
	
	/*dequeue method
	 *removes item from queue
	 *parameter: generic item to be inserted*/
	public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
	        T t = queue[front];
	        queue[front++] = null;
	        count--;
	        return t;
        
    }
	
	/*views front element*/
	public T peek() {
        if (isEmpty()) 
            throw new IllegalStateException();       
        return queue[front];
    }
    
	/*prints queue*/
    public String printQueue() {
        StringBuilder result = new StringBuilder();
        for (int i = front; i < rear; i++) {
            result.append(queue[i]).append(" ");
        }
        return String.valueOf(result);
    }
    
	/*checks if full*/
	public boolean isFull() {
		return count == size;
	}
	
	/*checks if empty*/
	public Boolean isEmpty() {
        return count <= 0;
    }
	
	/*returns size*/
	public int size() {
        return count;
    }
	
	
}
