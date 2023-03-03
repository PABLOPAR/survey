package com.pablop.survey.web.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pablop.survey.web.app.entity.PeopleAnalyzed;
import com.pablop.survey.web.app.services.PeopleService;

@Controller
@RequestMapping("app/survey")
public class PeopleAnalyzedController {
	
	@Autowired
	private PeopleService peopleAnalyzed;
	
	
	@GetMapping ("/peopleTestedProfile/{email}")
	public String peopleTestedProfile(@PathVariable String email, Model model) {
		
		peopleAnalyzed.peopleListAnalized();
		
		PeopleAnalyzed peopleSearched = peopleAnalyzed.analyzedByEmail(email);
		
		
		
		model.addAttribute("peopleSearched", peopleSearched);
		
		
		return "peopleTestedProfile";
	}

}
