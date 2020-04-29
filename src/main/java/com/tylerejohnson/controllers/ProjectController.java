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
import org.springframework.web.bind.annotation.RequestParam;

import com.tylerejohnson.beans.Project;
import com.tylerejohnson.beans.Task;
import com.tylerejohnson.beans.TeamMember;
import com.tylerejohnson.repository.ProjectRepository;
import com.tylerejohnson.repository.TaskRepository;
import com.tylerejohnson.repository.TeamMemberRepository;
import com.tylerejohnson.sorting.HeapSortTaskName;
import com.tylerejohnson.sorting.HeapSortTaskOwner;
import com.tylerejohnson.sorting.HeapSortTaskPriority;
import com.tylerejohnson.sorting.Filter;
import com.tylerejohnson.sorting.HeapSortTaskDate;

/*Project Controller*/

@Controller
public class ProjectController {

	/*Auto wired repositories for accessing DB*/
	
	@Autowired
	ProjectRepository repo;
	@Autowired
	TeamMemberRepository teamRepo;
	@Autowired
	TaskRepository taskRepo;
	
	/*controller methods for CRUD operations which use '@GetMapping' in order 
	 	to route to proper method and HTML page*/
	
	/*routes to page showing first project in DB*/
	@GetMapping("/projects")
	public String viewAllProjects(Model model) {
		if(repo.findAll().isEmpty()) {
			return createProject(model);
		}
		List<Project> l = new LinkedList<>();
		l = repo.findAll();
		long id = l.get(0).getProjectId();
		
		return viewProject(id, model, null);
	}
	
	/*uses path variable to show the correct project
	 *has optional path variable for search implementation of projects
	 *sorts tasks based on if finished or not and add lists to model
	 *returns user to project dashboard*/
	@GetMapping("/project/{projectId}")
	public String viewProject(@PathVariable("projectId") long id, Model model,
			@RequestParam (value = "search", required = false) String s) {
		
		if(!repo.existsById(id)) {
			return createProject(model);
		}
		
		Project p = repo.findById(id).orElse(null);
		model.addAttribute("project", p);
		
		List<Project> ps = repo.findAll();
		List<Task> tu = taskRepo.findByProject(p);
		List<Task> tf = taskRepo.findByProject(p);
		
		tu = Filter.filterTasksUnfinished(tu);
		tf = Filter.filterTasksFinished(tf);
		
		ps.remove(p);
		
		if(s != null)
			ps = Filter.filterProjects(ps, s);
		
		model.addAttribute("projects", ps);
		model.addAttribute("tasksUn", tu);
		model.addAttribute("tasksF", tf);
		return "projectDashboard";
	}
	
	/*uses path variable to show the correct project
	 *very similar to last method but used for searching for tasks instead of projects
	 *has optional path variable for search implementation of tasks
	 *sorts tasks based on if finished or not and add lists to model
	 *returns user to project dashboard*/
	@GetMapping("/project/{projectId}/tasks")
	public String viewProjectTasks(@PathVariable("projectId") long id, Model model,
			@RequestParam (value = "search", required = false) String st) {
		
		System.out.println("HERE");
		
		if(!repo.existsById(id)) {
			return createProject(model);
		}
		
		Project p = repo.findById(id).orElse(null);
		model.addAttribute("project", p);
		
		List<Project> ps = repo.findAll();
		List<Task> tu = taskRepo.findByProject(p);
		List<Task> tf = taskRepo.findByProject(p);
		
		tu = Filter.filterTasksUnfinished(tu);
		tf = Filter.filterTasksFinished(tf);
		
		ps.remove(p);
		if(st != null) {
			tu = Filter.filterTasks(tu, st);
			tf = Filter.filterTasks(tf, st);
		}
		
		
		model.addAttribute("projects", ps);
		model.addAttribute("tasksUn", tu);
		model.addAttribute("tasksF", tf);
		return "projectDashboard";
	}
	
	/*uses path variable to show the correct project
	 *uses path variable to sort tasks
	 *sorts tasks based on if finished or not and add lists to model
	 *returns user to project dashboard*/
	@GetMapping("/project/{projectId}/sort/{sortState}")
	public String viewProjectSort(@PathVariable("projectId") long id,
			@PathVariable("sortState") String sortState, Model model) {
		if(!repo.existsById(id)) {
			return createProject(model);
		}
		
		Project p = repo.findById(id).orElse(null);
		List<Project> ps = repo.findAll();
		
		ps.remove(p);
		model.addAttribute("project", p);
		model.addAttribute("projects", ps);
		
		List<Task> tu = taskRepo.findByProject(p);
		List<Task> tf = taskRepo.findByProject(p);
		
		tu = Filter.filterTasksUnfinished(tu);
		tf = Filter.filterTasksFinished(tf);
		
		/*sort switch*/
		/*based on path variable a method is called to sort using heap sort*/
		switch (sortState) {
			case "name": sortName(model, tu, tf);
				break;
			case "owner": sortOwner(model, tu, tf);
				break;
			case "duedate": sortDueDate(model, tu, tf);
				break;
			case "priority": sortPriority(model, tu, tf);
				break;
			default: return viewProject(id, model, null);
		}
		
		return "projectDashboard";
	}
	
	/*next four private methods are used to create instance of a heap sort subclass used to sort passed on given parameter*/
	
	private void sortName(Model model, List<Task> tu,  List<Task> tf) {
		HeapSortTaskName heap = new HeapSortTaskName();
		tu = heap.sortNameAscending(tu);
		tf = heap.sortNameAscending(tf);
		
		model.addAttribute("tasksUn", tu);
		model.addAttribute("tasksF", tf);
	}
	
	private void sortOwner(Model model, List<Task> tu,  List<Task> tf) {
		HeapSortTaskOwner heap = new HeapSortTaskOwner();
		tu = heap.sortOwnerAscending(tu);
		tf = heap.sortOwnerAscending(tf);
		
		model.addAttribute("tasksUn", tu);
		model.addAttribute("tasksF", tf);
	}
	
	private void sortDueDate(Model model, List<Task> tu,  List<Task> tf) {
		HeapSortTaskDate heap = new HeapSortTaskDate();
		tu = heap.sortDateAscending(tu);
		tf = heap.sortDateAscending(tf);
		
		model.addAttribute("tasksUn", tu);
		model.addAttribute("tasksF", tf);
	}
	
	private void sortPriority(Model model, List<Task> tu,  List<Task> tf) {
		HeapSortTaskPriority heap = new HeapSortTaskPriority();
		tu = heap.sortPriorityAscending(tu);
		tf = heap.sortPriorityAscending(tf);
		
		model.addAttribute("tasksUn", tu);
		model.addAttribute("tasksF", tf);
	}
	
	/*basic CRUD operations*/
	
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
}
