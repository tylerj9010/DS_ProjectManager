package com.tylerejohnson.sorting;

import java.util.ArrayList;
import java.util.List;

import com.tylerejohnson.beans.Task;
import com.tylerejohnson.datastructures.Pair;

/*Heap Sort subclass*/
/*sorts based on owner name*/

public class HeapSortTaskOwner extends HeapSort<String, Task>{

	public List<Task> sortOwnerAscending(List<Task> tasks) {
		
		List<Pair<String, Task>> taskPairs = new ArrayList<Pair<String, Task>>();
		
		for (Task i : tasks) {
			taskPairs.add(new Pair<String, Task>(i.getTeamMember().getLastName().toLowerCase(), i));
		}

		tasks = this.sortAscending(taskPairs);
		return tasks;
	}
	
	public List<Task> sortOwnerDescending(List<Task> tasks) {
		
		List<Pair<String, Task>> taskPairs = new ArrayList<Pair<String, Task>>();
		
		for (Task i : tasks) {
			taskPairs.add(new Pair<String, Task>(i.getTeamMember().getLastName().toLowerCase(), i));
		}

		tasks = this.sortDescending(taskPairs);
		return tasks;
	}
}
