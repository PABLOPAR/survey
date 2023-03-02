package com.pablop.survey.web.app.controllers;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pablop.survey.web.app.models.PeopleAnalyzed;
import com.pablop.survey.web.app.models.User;
import com.pablop.survey.web.app.services.PeopleService;


@Controller
@RequestMapping("app")
public class IndexController {

	public String head = "TRUST";
	public String title = "WHOM TO TRUST?";
	public String firstAction = "CHOOSE A TEST THAT YOU WANT TO DO";
	public String firstQuestion = "Can I trust my friend?";
	public String secondQuestion = "Can I trust my girlfriend/ boyfriend?";
	public String titleUserProfile = "USER PROFILE";
	public String fieldUserProfileFirstName = "User first name: ";
	public String fieldUserProfileEmail = "User email: ";
	public String fieldUserProfileLastName = "User last name: ";
	public String fieldUserProfileBirthday = "User Birthday: ";
	public String incomplete = "Incomplete";
	public String peopleAnalyzed = "People Analized";
	public String nothingShow = "Nothing to Show";
	public String name = "Name";
	public String birthday = "Birthday";
	public String country = "Country";
	public String email = "Email";

	@Autowired
	private PeopleService peopleAnalyzedList;
	
	@ModelAttribute("AnalyzedList")
	public List<PeopleAnalyzed> analyzedList() {
		return this.peopleAnalyzedList.peopleListAnalized();
	}

	@GetMapping(value = { "/index", "/", "home" })
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
		model.addAttribute("titleUserProfile", titleUserProfile);
		model.addAttribute("incomplete", incomplete);
		model.addAttribute("fieldUserProfileFirstName", fieldUserProfileFirstName);
		model.addAttribute("fieldUserProfileLastName", fieldUserProfileLastName);
		model.addAttribute("fieldUserProfileEmail", fieldUserProfileEmail);
		model.addAttribute("fieldUserProfileBirthday", fieldUserProfileBirthday);


		User user = new User("Spain", paulBirthay, "Paul", "paul@gmail.com");
		user.setEmail("paul@gmail.com");
		user.setLastName("Smith");
		

		model.addAttribute("user", user);
		return "userProfile";
	}


	@GetMapping("/peopleAnalyzed")
	public String analyzedPeople(Model model) {

		model.addAttribute("peopleAnalyzed", peopleAnalyzed);
		model.addAttribute("nothingShow", nothingShow);
		model.addAttribute("name", name);
		model.addAttribute("birthday", birthday);
		model.addAttribute("country", country);
		model.addAttribute("email", email);


		return "peopleAnalyzed";
	}

	
	
	
}
