package com.tylerejohnson.sorting;

import java.util.ArrayList;
import java.util.List;

import com.tylerejohnson.beans.Task;
import com.tylerejohnson.datastructures.Pair;

/*Heap Sort subclass*/
/*sorts based on priority*/

public class HeapSortTaskPriority extends HeapSort<Integer, Task>{

	public List<Task> sortPriorityAscending(List<Task> tasks) {
		
		List<Pair<Integer, Task>> taskPairs = new ArrayList<Pair<Integer, Task>>();
		
		for (Task i : tasks) {
			String j = i.getPriority().toLowerCase();
			int x = 0;
			if (j.contains("high"))
				x = 1;
			else if (j.contains("medium"))
				x = 2;
			else if (j.contains("low"))
				x = 3;
			else x = 9;
			taskPairs.add(new Pair<Integer, Task>(x, i));
		}
	
		tasks = this.sortAscending(taskPairs);
		return tasks;
	}
	
//	public List<Task> sortPriorityDescending(List<Task> tasks) {
//		
//		List<Pair<Integer, Task>> taskPairs = new ArrayList<Pair<Integer, Task>>();
//		
//		for (Task i : tasks) {
//			taskPairs.add(new Pair<Integer, Task>(i.getName().toLowerCase(), i));
//		}
//	
//		tasks = this.sortDescending(taskPairs);
//		return tasks;
//	}
}
