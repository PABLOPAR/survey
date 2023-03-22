package com.pablop.survey.web.app.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.pablop.survey.web.app.models.entity.Country;
import com.pablop.survey.web.app.models.entity.PeopleAnalyzed;
import com.pablop.survey.web.app.models.entity.User;
import com.pablop.survey.web.app.services.PeopleService;

@Controller
@RequestMapping("app")
@SessionAttributes("AnalyzedList")
public class IndexController {

	public String head = "TRUST";

	@Value("${text.indexController.index.title}")
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

	@Value("${text.indexController.analyzedPeople.peopleAnalyzed}")
	private String peopleAnalyzed;

	@Value("${text.indexController.analyzedPeople.nothingShow}")
	private String nothingShow;

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
	
	
	
	
	@Autowired
	@Qualifier("peopleImplementationLocale")
	private PeopleService peopleAnalyzedList;

//	@ModelAttribute("AnalyzedList")
//	public List<PeopleAnalyzed> analyzedList() {
//		return this.peopleAnalyzedList.getPeopleAnalyzedList();
//	}

	@GetMapping(value = { "/index", "home" })
	public String index(Model model) {
		model.addAttribute("head", head);

		model.addAttribute("title", title);
		model.addAttribute("firstAction", firstAction);
		model.addAttribute("firstQuestion", firstQuestion);
		model.addAttribute("secondQuestion", secondQuestion);
		return "index";

	}

	@GetMapping("/userprofile")
	public String userProfile(Model model) {

		Date paulBirthay = new Date(07 / 02 / 1975);
		model.addAttribute("titleUserProfile", titleUserProfile);
		model.addAttribute("incomplete", incomplete);
		model.addAttribute("fieldUserProfileFirstName", fieldUserProfileFirstName);
		model.addAttribute("fieldUserProfileLastName", fieldUserProfileLastName);
		model.addAttribute("fieldUserProfileEmail", fieldUserProfileEmail);
		model.addAttribute("fieldUserProfileBirthday", fieldUserProfileBirthday);
		model.addAttribute("fieldUserProfileCountry", country);	
		
		
		
	    Country countryUser= new Country ("Antarctica");
	    

		User user = new User(paulBirthay, "Paul", "paul@gmail.com");
		user.setCountry(countryUser);
		user.setEmail("paul@gmail.com");
		user.setLastName("Smith");

		model.addAttribute("user", user);
		return "userprofile";
	}

	@GetMapping("/peopleanalyzed")
	public String analyzedPeople(Model model) {

		List<PeopleAnalyzed> AnalyzedList = peopleAnalyzedList.getPeopleAnalyzedList();
		System.out.println("Ver aca:"+AnalyzedList.toString() );

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
		
		

		return "peopleanalyzed";
	}

}
