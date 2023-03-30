package com.pablop.survey.web.app.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.pablop.survey.web.app.editors.CountryPropertyEditor;
import com.pablop.survey.web.app.models.entity.Country;
import com.pablop.survey.web.app.models.entity.User;
import com.pablop.survey.web.app.services.CountryListService;
import com.pablop.survey.web.app.services.IMainAppService;

@Controller
@RequestMapping("app/user")
@SessionAttributes("user")
public class NewUserController {

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

	@Value("${text.indexController.userProfile.fieldUserProfileCountry}")
	private String countryText;

	@Value("${text.NewUserController.title}")
	private String title;

	@Value("${text.duplicateUserException.title1}")
	private String title1;
	
	@Value("${text.duplicateUserException.title2}")
	private String title2;
	
	
	@Autowired
	private IMainAppService iMainAppService;
	
	@Autowired
	private CountryListService countryListService;
	
	@Autowired
	private CountryPropertyEditor countryEditor;
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Country.class, "country", countryEditor);
	}
	
	

	@ModelAttribute("countryList")
	private List<Country> coutryList() {
		return countryListService.getCountryListObject();
	}

	@GetMapping("/newuser")
	public String newUser(Model model) {

		User user = new User();
		model.addAttribute("title", title);
		model.addAttribute("incomplete", incomplete);
		model.addAttribute("fieldUserProfileFirstName", fieldUserProfileFirstName);
		model.addAttribute("fieldUserProfileLastName", fieldUserProfileLastName);
		model.addAttribute("fieldUserProfileEmail", fieldUserProfileEmail);
		model.addAttribute("fieldUserProfileBirthday", fieldUserProfileBirthday);
		model.addAttribute("countryText", countryText);
		model.addAttribute("user", user);

		return "newuser";
	}

	@PostMapping("/newuser")
	public String loadUser(@Valid User user, BindingResult result, Model model, SessionStatus status) {

		if (result.hasErrors()) {
			model.addAttribute("title", title);
			model.addAttribute("incomplete", incomplete);
			model.addAttribute("fieldUserProfileFirstName", fieldUserProfileFirstName);
			model.addAttribute("fieldUserProfileLastName", fieldUserProfileLastName);
			model.addAttribute("fieldUserProfileEmail", fieldUserProfileEmail);
			model.addAttribute("fieldUserProfileBirthday", fieldUserProfileBirthday);
			model.addAttribute("countryText", countryText);
			return "newuser";
		}

		
		if(iMainAppService.addUser(user)!=true) {
			model.addAttribute("title", title);
			model.addAttribute("incomplete", incomplete);
			model.addAttribute("fieldUserProfileFirstName", fieldUserProfileFirstName);
			model.addAttribute("fieldUserProfileLastName", fieldUserProfileLastName);
			model.addAttribute("fieldUserProfileEmail", fieldUserProfileEmail);
			model.addAttribute("fieldUserProfileBirthday", fieldUserProfileBirthday);
			model.addAttribute("duplicateEmail", "duplicateEmail");
			model.addAttribute("title1", title1);	
			model.addAttribute("title2", title2);
			model.addAttribute("email", user.getEmail());			
			model.addAttribute("countryText", countryText);
			return "newuser";
		};

		status.setComplete();

		return "redirect:/app/index";
	}

}
