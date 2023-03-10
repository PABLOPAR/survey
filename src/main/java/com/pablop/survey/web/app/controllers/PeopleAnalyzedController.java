package com.pablop.survey.web.app.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pablop.survey.web.app.models.entity.PeopleAnalyzed;
import com.pablop.survey.web.app.services.PeopleService;

@Controller
@RequestMapping("app/survey")
public class PeopleAnalyzedController {
	
	
	@Value("${text.PeopleAnalyzedController.peopleTestedProfile.fieldPeopleTestedEmail}")
	private String fieldPeopleTestedEmail;
	
	@Value("${text.PeopleAnalyzedController.peopleTestedProfile.fieldPeopleTestedBirthday}")
	private String fieldPeopleTestedBirthday;
	
	@Value("${text.PeopleAnalyzedController.peopleTestedProfile.fieldPeopleProfileFirstName}")
	private String fieldPeopleProfileFirstName;
	
	@Value("${text.PeopleAnalyzedController.peopleTestedProfile.fieldPeopleTestedCountry}")
	private String fieldPeopleTestedCountry;
	
	@Value("${text.PeopleAnalyzedController.peopleTestedProfile.fieldPeopleTestedLastName}")
	private String fieldPeopleTestedLastName;
	
	@Value("${text.PeopleAnalyzedController.peopleTestedProfile.incompleteField}")
	private String incompleteField;
	
	
	
	@Autowired
	private PeopleService peopleAnalyzed;
	
	
	@GetMapping ("/peopleTestedProfile/{email}")
	public String peopleTestedProfile(@PathVariable String email, Model model) {
		
		PeopleAnalyzed peopleSearched = peopleAnalyzed.analyzedByEmail(email);
		
		
		model.addAttribute("peopleSearched", peopleSearched);	
		model.addAttribute("fieldPeopleTestedEmail", fieldPeopleTestedEmail);
		model.addAttribute("fieldPeopleTestedBirthday", fieldPeopleTestedBirthday);
		model.addAttribute("fieldPeopleProfileFirstName", fieldPeopleProfileFirstName);
		model.addAttribute("fieldPeopleTestedCountry", fieldPeopleTestedCountry);
		model.addAttribute("fieldPeopleTestedLastName", fieldPeopleTestedLastName);	
		model.addAttribute("incompleteField", incompleteField);		
		
		
		
		
		return "peopleTestedProfile";
	}

}
