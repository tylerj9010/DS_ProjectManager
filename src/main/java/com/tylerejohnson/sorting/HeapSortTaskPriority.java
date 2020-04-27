package com.tylerejohnson.sorting;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tylerejohnson.beans.Task;
import com.tylerejohnson.datastructures.Pair;

public class HeapSortTaskPriority extends HeapSort<Integer, Task>{

	public List<Task> sortPriorityAscending(List<Task> tasks) {
		
		List<Pair<Date, Task>> taskPairs = new ArrayList<Pair<Date, Task>>();
		
		for (Task i : tasks) {
			taskPairs.add(new Pair<Date, Task>(i.getTargetDate(), i));
		}
	
//		tasks = this.sortAscending(taskPairs);
		return tasks;
	}
	
	public List<Task> sortPriorityDescending(List<Task> tasks) {
		
		List<Pair<String, Task>> taskPairs = new ArrayList<Pair<String, Task>>();
		
		for (Task i : tasks) {
			taskPairs.add(new Pair<String, Task>(i.getName().toLowerCase(), i));
		}
	
//		tasks = this.sortDescending(taskPairs);
		return tasks;
	}
}
