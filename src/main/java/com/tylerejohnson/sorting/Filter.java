package com.tylerejohnson.sorting;

import java.util.ArrayList;
import java.util.List;

import com.tylerejohnson.beans.Project;
import com.tylerejohnson.beans.Task;
import com.tylerejohnson.datastructures.Queue;


/*filter class used in search implementation*/

public class Filter {

	public static List<Task> filterTasks(List<Task> tasks, String searchTerm) {
		String filter = searchTerm.toLowerCase();
		Queue<Task> q = new Queue<>(tasks.size());
		List<Task> filteredTasks = new ArrayList<>();
		
		System.out.println("HERE");
		
		for (Task t : tasks) {
			if (compareFilterTasks(t, filter)) {
				q.enqueue(t);
			}
		}	
		
		while (q.size() != 0)
			filteredTasks.add(q.dequeue());
		
		return filteredTasks;
	}
	
	private static boolean compareFilterTasks(Task t, String filter) {
		return t.getName().toLowerCase().contains(filter) ||
				t.getTeamMember().getFirstName().toLowerCase().contains(filter) ||
				t.getTeamMember().getLastName().toLowerCase().contains(filter);
	}
	
	public static List<Project> filterProjects(List<Project> projects, String searchTerm) {
		String filter = searchTerm.toLowerCase();
		Queue<Project> q = new Queue<>(projects.size());
		List<Project> filteredProjects = new ArrayList<>();
		
		
		for (Project p : projects) {
			if (compareFilterProjects(p, filter)) {
				q.enqueue(p);
			}
		}	
		
		while (q.size() != 0)
			filteredProjects.add(q.dequeue());
		
		return filteredProjects;
	}
	
	private static boolean compareFilterProjects(Project t, String filter) {
		return t.getName().toLowerCase().contains(filter);
	}
	
	public static List<Task> filterTasksFinished(List<Task> tasks) {
		Queue<Task> q = new Queue<>(tasks.size());
		List<Task> filteredTasks = new ArrayList<>();
		
		
		for (Task t : tasks) {
			if (t.getFinished()) {
				q.enqueue(t);
			}
		}	
		
		while (q.size() != 0)
			filteredTasks.add(q.dequeue());
		
		return filteredTasks;
	}
	
	public static List<Task> filterTasksUnfinished(List<Task> tasks) {
		Queue<Task> q = new Queue<>(tasks.size());
		List<Task> filteredTasks = new ArrayList<>();
		
		
		for (Task t : tasks) {
			
			if (t.getFinished() == null || !t.getFinished() ) {
				q.enqueue(t);
			}
		}	
		
		while (q.size() != 0)
			filteredTasks.add(q.dequeue());
		
		return filteredTasks;
	}
	
	
}
