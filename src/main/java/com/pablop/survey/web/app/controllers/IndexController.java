package com.pablop.survey.web.app.controllers;

import java.beans.PropertyEditor;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.pablop.survey.web.app.editors.ICountryEditor;
import com.pablop.survey.web.app.editors.UpperCaseEditor;
import com.pablop.survey.web.app.models.entity.Country;
import com.pablop.survey.web.app.models.entity.PeopleAnalyzed;
import com.pablop.survey.web.app.models.entity.User;
import com.pablop.survey.web.app.services.CountryListService;
import com.pablop.survey.web.app.services.IPeopleService;

@Controller
@RequestMapping("app")
@SessionAttributes("peopleAnalyzed")
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
	
	@Value("${text.indexController.index.showButtonTest}")
	private String showButtonTest;
	
	@Value("${text.indexController.creationDate}")
	private String creationDateText;
	
	@Value("${text.PeopleAnalyzedController.peopleTestedProfile.addNewUser}")
	private String addNewUser;
	
	@Value("${text.indexController.analyzedPeople.edit}")
	private String edit;
	
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


	
	@Autowired
	private CountryListService countryListService;
	
	@ModelAttribute("countryList")
	private List<Country> coutryList() {
		return countryListService.getCountryListObject();
	}

	@Autowired
	private ICountryEditor countryEditor;
	
	@Autowired
	private IPeopleService iPeopleService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Country.class, "country", (PropertyEditor) countryEditor);
		binder.registerCustomEditor(String.class, "firstName", new UpperCaseEditor());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));


	
	}

	@Autowired
	@Qualifier("PeopleAnalyzedDaoJPA")
	private IPeopleService peopleAnalyzedList;

	

	

	@GetMapping(value = { "/index", "home" })
	public String index(Model model) {
		model.addAttribute("head", head);

		model.addAttribute("title", title);
		model.addAttribute("firstAction", firstAction);
		model.addAttribute("firstQuestion", firstQuestion);
		model.addAttribute("secondQuestion", secondQuestion);
		model.addAttribute("showButtonTest", showButtonTest);	
		
		
		
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
		

		return "peopleanalyzed";
	}

	@GetMapping("/peopleanalyzed/edit/{id}")
	public String edit(@PathVariable(value = "id") Long id, Model model) {

		PeopleAnalyzed peopleAnalyzed = null;
		String urlResult="newpeopleanalyzed";

		if (id > 0) {

			peopleAnalyzed = peopleAnalyzedList.findPeopleById(id);
			
			System.out.println("Persona analizada "+ peopleAnalyzed.toString());
			
			
		} else {
			urlResult= "redirect:peopleanalyzed";
		}
		
		model.addAttribute("fieldPeopleTestedEmail", fieldPeopleTestedEmail);
		model.addAttribute("fieldPeopleTestedBirthday", fieldPeopleTestedBirthday);
		model.addAttribute("fieldPeopleProfileFirstName", fieldPeopleProfileFirstName);
		model.addAttribute("fieldPeopleTestedCountry", fieldPeopleTestedCountry);
		model.addAttribute("fieldPeopleTestedLastName", fieldPeopleTestedLastName);
		model.addAttribute("lastName", lastName);
		model.addAttribute("peopleAnalyzed", peopleAnalyzed);
		model.addAttribute("title", edit);
		
		
		return urlResult;
	}


	
	

	
}
	

