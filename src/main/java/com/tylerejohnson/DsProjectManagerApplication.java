package com.tylerejohnson;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.tylerejohnson.beans.Task;
import com.tylerejohnson.sorting.HeapSortTaskName;

@SpringBootApplication
@EnableJpaAuditing
public class DsProjectManagerApplication {

	public static void main(String[] args) {
//		tester();
		SpringApplication.run(DsProjectManagerApplication.class, args);
	}
	
	public static void tester() {
		
		Task task1 = new Task(5, "a");
		Task task2 = new Task(3, "d");
		Task task3 = new Task(8, "b");
		Task task4 = new Task(4, "f");
		Task task5 = new Task(1, "c");
		Task task6 = new Task(2, "e");
		
		List<Task> tasks = new ArrayList<>();
		tasks.add(task1);
		tasks.add(task2);
		tasks.add(task3);
		tasks.add(task4);
		tasks.add(task5);
		tasks.add(task6);
		
		/*REPO ENDS*/

		
		
		HeapSortTaskName heap = new HeapSortTaskName();
		
		tasks = heap.sortNameAscending(tasks);
		System.out.println(tasks.toString());
		
		
		
	}
	
}


