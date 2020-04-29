package com.tylerejohnson.sorting;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tylerejohnson.beans.Task;
import com.tylerejohnson.datastructures.Pair;

/*Heap Sort subclass*/
/*sorts based on date*/

public class HeapSortTaskDate extends HeapSort<Date, Task>{

public List<Task> sortDateAscending(List<Task> tasks) {
		
		List<Pair<Date, Task>> taskPairs = new ArrayList<Pair<Date, Task>>();
		
		for (Task i : tasks) {
			taskPairs.add(new Pair<Date, Task>(i.getTargetDate(), i));
		}

		tasks = this.sortAscending(taskPairs);
		return tasks;
	}
	
	public List<Task> sortDateDescending(List<Task> tasks) {
		
		List<Pair<Date, Task>> taskPairs = new ArrayList<Pair<Date, Task>>();
		
		for (Task i : tasks) {
			taskPairs.add(new Pair<Date, Task>(i.getTargetDate(), i));
		}

		tasks = this.sortDescending(taskPairs);
		return tasks;
	}
}
