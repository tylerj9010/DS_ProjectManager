package com.tylerejohnson.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.tylerejohnson.repository.TeamMemberRepository;

/*Home controller*/
/*used for mapping '/error' and '/'*/

@Controller
public class HomeController {

	@Autowired
	TeamMemberRepository teamRepo;
	
	@GetMapping("/")
	public RedirectView home(Model model) {
		if (teamRepo.findAll().isEmpty())
			return new RedirectView("/newteammember");
		return new RedirectView("/projects");
	}
	
	@GetMapping("/error")
	public String error(Model model) {
		return "error";
	}
	
	
}
