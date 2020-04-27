package com.tylerejohnson.datastructures;

import com.tylerejohnson.beans.Task;

public class Queue {
	private Task[] tasks;
	private int count = 0;
	private int rear = 0;
	private int front = 0; 
	private int size;
	
	public Queue(int size) {
		this.size = size;
		this.tasks = new Task[size];
	}
	
	public void enqueue(Task task) {
		if (isFull())
			throw new IllegalStateException();
		tasks[rear++] = task;
		count++;
	}
	
	
	
	public Task dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
	        Task task = tasks[front];
	        tasks[front++] = null;
	        count--;
	        return task;
        
    }
	
	public Task peek() {
        if (isEmpty()) 
            throw new IllegalStateException();       
        return tasks[front];
    }
    
    public String printQueue() {
        StringBuilder result = new StringBuilder();
        for (int i = front; i < rear; i++) {
            result.append(tasks[i]).append(" ");
        }
        return String.valueOf(result);
    }
	
	public boolean isFull() {
		return count == size;
	}
	
	public Boolean isEmpty() {
        return count <= 0;
    }
	
	public int size() {
        return count;
    }
	
	
}
