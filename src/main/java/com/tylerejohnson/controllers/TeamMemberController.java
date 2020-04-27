package com.tylerejohnson.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.tylerejohnson.beans.TeamMember;
import com.tylerejohnson.repository.TeamMemberRepository;

@Controller
public class TeamMemberController {

	@Autowired
	TeamMemberRepository repo;
	
	@GetMapping({"/viewAllTeamMembers"})
	public String viewAllTeamMembers(Model model) {
		if(repo.findAll().isEmpty()) {
			return inputTeamMember(model);
		}
		model.addAttribute("teamMembers", repo.findAll());
		return "results";
	}
	
	@GetMapping("/inputTeamMember")
	public String inputTeamMember(Model model) {
		TeamMember tm = new TeamMember();
		model.addAttribute("newTeamMember", tm);
		return "createteammember";
	}
	
//	@PostMapping("/inputTeamMember")
//	public String createTeamMember(@ModelAttribute TeamMember tm, Model model) {
//		repo.save(tm);
//		return viewAllTeamMembers(model);
//	}
	
	@GetMapping("/editTeamMember/{id}")
	public String showTeamMemberToUpdate(@PathVariable("id") long id, Model model) {
		TeamMember tm = repo.findById(id).orElse(null);
		model.addAttribute("newTeamMember", tm);
		return "input";
	}
	
	@PostMapping("/updateTeamMember/{id}")
	public RedirectView updateTeamMember(@PathVariable("id") long id, @Valid TeamMember tm, Model model) {
		repo.save(tm);
		return new RedirectView("/");
	}
	
	@GetMapping("/deleteTeamMember/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		TeamMember tm = repo.findById(id).orElse(null);
	    repo.delete(tm);
	    return viewAllTeamMembers(model);
	}
}

