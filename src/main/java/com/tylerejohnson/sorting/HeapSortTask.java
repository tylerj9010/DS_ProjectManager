package com.tylerejohnson.sorting;

import java.util.ArrayList;
import java.util.List;

import com.tylerejohnson.beans.Task;
import com.tylerejohnson.datastructures.Pair;

public class HeapSortTask extends HeapSort<String, Task> {
	
	public List<Task> sortName(List<Task> tasks) {
		
		List<Pair<String, Task>> taskPairs = new ArrayList<Pair<String, Task>>();
		
		for (Task i : tasks) {
			taskPairs.add(new Pair<String, Task>(i.getName().toLowerCase(), i));
		}

		tasks = this.sort(taskPairs);
		return tasks;
	}
}
