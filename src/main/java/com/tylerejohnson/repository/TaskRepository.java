package com.tylerejohnson.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tylerejohnson.beans.Project;
import com.tylerejohnson.beans.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{
	List<Task> findByProject(Project project);
}
