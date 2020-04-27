package com.tylerejohnson.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.tylerejohnson.beans.Project;
import com.tylerejohnson.beans.Task;
import com.tylerejohnson.beans.TeamMember;
import com.tylerejohnson.exception.ResourceNotFoundException;
import com.tylerejohnson.repository.ProjectRepository;
import com.tylerejohnson.repository.TaskRepository;
import com.tylerejohnson.repository.TeamMemberRepository;

@Controller
public class TaskController {

	@Autowired
	TaskRepository repo;
	@Autowired
	ProjectRepository projectRepo;
	@Autowired
	TeamMemberRepository teamRepo;
	
	@GetMapping("/tasks")
	public String viewAllTasks(Model model) {
		if(repo.findAll().isEmpty()) {
			return "/projects";
		}
		model.addAttribute("tasks", repo.findAll());
		return "results";
	}
	
	@GetMapping("projects/{projectId}/tasks")
	public String viewTasksForCurrentProject(@PathVariable("projectId") long id, Model model) {
		if(repo.findAll().isEmpty()) {
			return inputTask(1,model);
		}
		model.addAttribute("tasks", repo.findAll());
		return "newtask";
	}
	
	@GetMapping("/project/{projectId}/newtask")
	public String inputTask(@PathVariable("projectId") long id, Model model) {
		Task t = new Task();
		if (!projectRepo.existsById(id))
			throw new ResourceNotFoundException("Project with id: " + id + " does not exist");
		Project p = projectRepo.findById(id).orElse(null); 
		t.setProject(p);
		model.addAttribute("newTask", t);
		List<TeamMember> tms = teamRepo.findAll();
		model.addAttribute("teamManagers", tms);
		
		return "newtask";
	}
	
	@PostMapping("/projects/{projectId}/tasks/{id}")
	public RedirectView postTask(@PathVariable("projectId") long projectId, @PathVariable("id") long id,
			@Valid Task t, Model model) {
		if (!projectRepo.existsById(projectId))
			throw new ResourceNotFoundException("Project with id: " + id + " does not exist");
		Project p = projectRepo.findById(projectId).orElse(null); 
		t.setProject(p);
		repo.save(t);
		return new RedirectView("/projects");
	}
	
	@GetMapping("/projects/{projectId}/edittask/{id}")
	public String showTaskToUpdate(@PathVariable("id") long id, Model model) {
		Task t = repo.findById(id).orElse(null);
		model.addAttribute("newTask", t);
		return "";
	}
	
	@GetMapping("/projects/{projectId}/tasks/{id}")
	public String deleteTask(Model model) {
		return null;
	}
}
