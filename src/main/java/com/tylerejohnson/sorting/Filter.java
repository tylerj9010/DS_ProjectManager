package com.tylerejohnson.sorting;

import java.util.ArrayList;
import java.util.List;

import com.tylerejohnson.beans.Task;
import com.tylerejohnson.datastructures.Queue;

public class Filter {

	public static List<Task> filter(List<Task> tasks, String searchTerm) {
		String filter = searchTerm.toLowerCase();
		Queue q = new Queue(tasks.size());
		List<Task> filteredTasks = new ArrayList<>();
		
		
		for (Task t : tasks) {
			if (compareFilter(t, filter)) {
				q.enqueue(t);
			}
		}	
		
		while (q.size() != 0)
			filteredTasks.add(q.dequeue());
		
		return filteredTasks;
	}
	
	private static boolean compareFilter(Task t, String filter) {
		return t.getName().toLowerCase().contains(filter) ||
				t.getTeamMember().getFirstName().toLowerCase().contains(filter) ||
				t.getTeamMember().getLastName().toLowerCase().contains(filter);
	}
}
