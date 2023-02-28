package com.pablop.survey.web.app.controllers;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pablop.survey.web.app.models.User;


@Controller
@RequestMapping ("app")
public class IndexController {
	
	public String head = "TRUST";
	public String title = "WHOM TO TRUST?";
	public String firstAction = "CHOOSE A TEST THAT YOU WANT TO DO";
	public String firstQuestion= "Can I trust in my friend?";
	public String secondQuestion= "Can I trust my girlfriend/ boyfriend?";
	
	

	@GetMapping(value={"/index", "/", "home"})
	public String index(Model model) {
		model.addAttribute("head", head);
		model.addAttribute("title", title);
		model.addAttribute("firstAction", firstAction);
		model.addAttribute("firstQuestion", firstQuestion);
		model.addAttribute("secondQuestion", secondQuestion);
		return "index";

	}

	@GetMapping("/userProfile")
	public String userProfile(Model model) {

		Date paulBirthay = new Date(07 / 02 / 1975);

		User user = new User("Spain", paulBirthay, "Paul");
		user.setEmail("paul@gmail.com");
		user.setLastName("Smith");

		model.addAttribute("firstName", user.getFirstName());
		model.addAttribute("lastName", user.getLastName());
		return "userProfile";
	}
	
	
}
