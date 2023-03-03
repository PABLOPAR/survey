package com.pablop.survey.web.app.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	
	
	@Value("${text.PeopleAnalyzedController.peopleTestedProfile.fieldPeopleTestedEmail}")
	private String fieldPeopleTestedEmail;
	
	@Value("${text.PeopleAnalyzedController.peopleTestedProfile.fieldPeopleTestedBirthday}")
	private String fieldPeopleTestedBirthday;
	
	@Value("${text.PeopleAnalyzedController.peopleTestedProfile.fieldUserProfileFirstName}")
	private String fieldUserProfileFirstName;
	
	@Value("${text.PeopleAnalyzedController.peopleTestedProfile.fieldPeopleTestedCountry}")
	private String fieldPeopleTestedCountry;
	
	
	
	@Autowired
	private PeopleService peopleAnalyzed;
	
	
	@GetMapping ("/peopleTestedProfile/{email}")
	public String peopleTestedProfile(@PathVariable String email, Model model) {
		
		peopleAnalyzed.peopleListAnalized();
		
		PeopleAnalyzed peopleSearched = peopleAnalyzed.analyzedByEmail(email);
		
		
		model.addAttribute("peopleSearched", peopleSearched);	
		model.addAttribute("fieldPeopleTestedEmail", fieldPeopleTestedEmail);
		model.addAttribute("fieldPeopleTestedBirthday", fieldPeopleTestedBirthday);
		model.addAttribute("fieldUserProfileFirstName", fieldUserProfileFirstName);
		model.addAttribute("fieldPeopleTestedCountry", fieldPeopleTestedCountry);
		
		return "peopleTestedProfile";
	}

}
