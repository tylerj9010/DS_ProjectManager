package com.tylerejohnson.controllers;

import java.util.LinkedList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tylerejohnson.beans.Project;
import com.tylerejohnson.beans.Task;
import com.tylerejohnson.beans.TeamMember;
import com.tylerejohnson.repository.ProjectRepository;
import com.tylerejohnson.repository.TaskRepository;
import com.tylerejohnson.repository.TeamMemberRepository;
import com.tylerejohnson.sorting.HeapSortTask;

//TODO create projects and assign team members 
@Controller
public class ProjectController {

	@Autowired
	ProjectRepository repo;
	@Autowired
	TeamMemberRepository teamRepo;
	@Autowired
	TaskRepository taskRepo;
	
	@GetMapping("/projects")
	public String viewAllProjects(Model model) {
		if(repo.findAll().isEmpty()) {
			return createProject(model);
		}
		List<Project> l = new LinkedList<>();
		l = repo.findAll();
		long id = l.get(0).getProjectId();
		
		return viewProject(id, model);
	}

	
	@GetMapping("/project/{projectId}")
	public String viewProject(@PathVariable("projectId") long id, Model model) {
		if(!repo.existsById(id)) {
			return createProject(model);
		}
		
		Project p = repo.findById(id).orElse(null);
		model.addAttribute("project", p);
		List<Project> ps = repo.findAll();
		ps.remove(p);
		model.addAttribute("projects", ps);
		List<Task> t = taskRepo.findByProject(p);
		HeapSortTask heap = new HeapSortTask();
		t = heap.sortName(t);
		
		model.addAttribute("tasks", t);
		return "projectDashboard";
	}
	
	
	@GetMapping("/newproject")
	public String createProject(Model model) {
		Project p = new Project();
		List<TeamMember> tms = teamRepo.findAll();
		model.addAttribute("newProject", p);
		model.addAttribute("teamManagers", tms);
		return "createProject";
	}
	
	@GetMapping("/editproject/{id}")
	public String showProjectToUpdate(@PathVariable("id") long id, Model model) {
		Project p = repo.findById(id).orElse(null);
		List<TeamMember> tms = teamRepo.findAll();
		model.addAttribute("newProject", p);
		model.addAttribute("teamManagers", tms);
		return "editproject";
	}
	
	@PostMapping("/newproject/{projectId}")
	public String postProject(@PathVariable("projectId") long id, @Valid Project p, Model model) {
		repo.save(p);
		return viewAllProjects(model);
	}
	
	@GetMapping("/deleteproject/{id}")
	public String deleteProject(@PathVariable("id") long id, Model model) {
		Project p = repo.findById(id).orElse(null);
		repo.delete(p);
		return viewAllProjects(model);
	}
	@GetMapping("/project/2?search=22")
	public String search() {
		return "";
	}
}
