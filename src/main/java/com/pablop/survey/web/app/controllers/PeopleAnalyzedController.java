package com.pablop.survey.web.app.controllers;


import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.pablop.survey.web.app.models.entity.PeopleAnalyzed;
import com.pablop.survey.web.app.services.IPeopleService;

@Controller
@SessionAttributes("peopleAnalyzed") 
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

	@Value("${text.indexController.userProfile.peopleTestedProfile.title}")
	private String titlePeopleTested;

	@Value("${text.PeopleAnalyzedController.peopleTestedProfile.back}")
	private String back;

	@Value("${text.indexController.analyzedPeople.nothingShow}")
	private String nothingShow;
	
	@Value("${text.indexController.userProfile.peopleTestedProfile.title}")
	private String title;

	@Value("${text.indexController.index.firstAction}")
	private String firstAction;

	@Value("${text.indexController.index.firstQuestion}")
	private String firstQuestion;

	@Value("${text.indexController.index.secondQuestion}")
	private String secondQuestion;

	@Value("${text.indexController.userProfile.titleUserProfile}")
	private String titleUserProfile;

	@Value("${text.indexController.userProfile.fieldUserProfileFirstName}")
	private String fieldUserProfileFirstName;

	@Value("${text.indexController.userProfile.fieldUserProfileEmail}")
	private String fieldUserProfileEmail;

	@Value("${text.indexController.userProfile.fieldUserProfileBirthday}")
	private String fieldUserProfileBirthday;

	@Value("${text.indexController.userProfile.fieldUserProfileLastName}")
	private String fieldUserProfileLastName;

	@Value("${text.indexController.userProfile.incomplete}")
	private String incomplete;

	@Value("${text.indexController.analyzedPeople.name}")
	private String analyzedPeople;

	@Value("${text.indexController.analyzedPeople.birthday}")
	private String birthday;

	@Value("${text.indexController.analyzedPeople.country}")
	private String country;

	@Value("${text.indexController.analyzedPeople.email}")
	private String email;

	@Value("${text.indexController.analyzedPeople.lastName}")
	private String lastName;

	@Value("${text.indexController.analyzedPeople.name}")
	private String name;

	@Value("${text.PeopleAnalyzedController.peopleTestedProfile.incompleteField}")
	private String noData;

	@Value("${text.indexController.analyzedPeople.textTimeSpent}")
	private String TextSpentTime;
	
	@Value("${text.indexController.index.showButtonTest}")
	private String showButtonTest;
	
	@Value("${text.indexController.creationDate}")
	private String creationDateText;
	
	@Value("${text.PeopleAnalyzedController.peopleTestedProfile.addNewUser}")
	private String addNewUser;
	
	@Value("${text.indexController.analyzedPeople.edit}")
	private String edit;
	
	@Value("${text.delete}")
	private String delete;
	
	@Value("${text.deleteConfirmation}")
	private String deleteConfirmation;
	
	
	
	@Autowired
	private IPeopleService peopleAnalyzedList;
	
	
	@Autowired
	private IPeopleService peopleAnalyzed;

	@GetMapping("/peopletestedprofile/{email}")
	public String peopleTestedProfile(@PathVariable String email, Model model) {
		model.addAttribute("titlePeopleTested", titlePeopleTested);
		PeopleAnalyzed peopleSearched = peopleAnalyzed.analyzedByEmail(email);

		model.addAttribute("peopleSearched", peopleSearched);
		model.addAttribute("fieldPeopleTestedEmail", fieldPeopleTestedEmail);
		model.addAttribute("fieldPeopleTestedBirthday", fieldPeopleTestedBirthday);
		model.addAttribute("fieldPeopleProfileFirstName", fieldPeopleProfileFirstName);
		model.addAttribute("fieldPeopleProfileFirstName", fieldPeopleProfileFirstName);
		model.addAttribute("fieldPeopleTestedCountry", fieldPeopleTestedCountry);
		model.addAttribute("fieldPeopleTestedLastName", fieldPeopleTestedLastName);
		model.addAttribute("incompleteField", incompleteField);
		model.addAttribute("back", back);
		model.addAttribute("nothingShow", nothingShow);
		

		return "peopletestedprofile";
	}

	
//	@GetMapping("/peopleanalyzed/{id}")	
	@GetMapping("/peopleanalyzed")
	public String analyzedPeople(Model model) {

		List<PeopleAnalyzed> AnalyzedList = peopleAnalyzedList.getPeopleAnalyzedList();
		
		Collections.sort(AnalyzedList);
		
		
		
		model.addAttribute("peopleAnalyzed", peopleAnalyzed);
		model.addAttribute("nothingShow", nothingShow);
		model.addAttribute("name", name);
		model.addAttribute("birthday", birthday);
		model.addAttribute("country", country);
		model.addAttribute("email", email);
		model.addAttribute("lastName", lastName);
		model.addAttribute("noData", noData);
		model.addAttribute("AnalyzedList", AnalyzedList);
		model.addAttribute("TextSpentTime", TextSpentTime);	
		model.addAttribute("creationDateText", creationDateText);		
		model.addAttribute("addNewUser", addNewUser);	
		model.addAttribute("edit", edit);		
		model.addAttribute("title", title);		
		model.addAttribute("delete", delete);		
		model.addAttribute("deleteConfirmation", deleteConfirmation);		
		
		

		return "peopleanalyzed";
	}
	
	
	@GetMapping(value = "/peopleAnalyzed/delete/{id}")
	public String deleteById(@PathVariable Long id, Model model) {

		if (id > 0) {

			peopleAnalyzedList.deletePeopleAnalyzedById(id);
		}
		
		return "redirect:/app/survey/peopleanalyzed";
	}
	
}
