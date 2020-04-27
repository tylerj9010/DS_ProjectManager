package com.tylerejohnson.sorting;

import java.util.ArrayList;
import java.util.List;

import com.tylerejohnson.beans.Task;
import com.tylerejohnson.datastructures.Pair;

public class HeapSortTaskName extends HeapSort<String, Task> {
	
	public List<Task> sortNameAscending(List<Task> tasks) {
		
		List<Pair<String, Task>> taskPairs = new ArrayList<Pair<String, Task>>();
		
		for (int i = 0; i < tasks.size(); i++) {
			taskPairs.add(new Pair<String, Task>(tasks.get(i).getName().toLowerCase(), tasks.get(i)));
		}

		tasks = this.sortAscending(taskPairs);
		return tasks;
	}
	
	public List<Task> sortNameDescending(List<Task> tasks) {
		
		List<Pair<String, Task>> taskPairs = new ArrayList<Pair<String, Task>>();
		
		for (Task i : tasks) {
			taskPairs.add(new Pair<String, Task>(i.getName().toLowerCase(), i));
		}

		tasks = this.sortDescending(taskPairs);
		return tasks;
	}
	
	
	
	
}
