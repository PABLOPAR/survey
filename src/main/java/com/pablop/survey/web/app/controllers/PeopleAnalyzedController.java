package com.pablop.survey.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("app/survey")
public class PeopleAnalyzedController {
	
	@GetMapping ("peopleTestedProfile")
	public String peopleTestedProfile(@RequestParam(required=false) String peopleTested, Model model) {
		
		model.addAttribute("peopleTested", peopleTested);
		
		
		return "peopleTestedProfile";
	}

}
