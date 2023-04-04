package com.pablop.survey.web.app.controllers;

import java.beans.PropertyEditor;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
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

import com.pablop.survey.web.app.editors.ICountryEditor;
import com.pablop.survey.web.app.editors.UpperCaseEditor;
import com.pablop.survey.web.app.models.entity.Country;
import com.pablop.survey.web.app.models.entity.PeopleAnalyzed;
import com.pablop.survey.web.app.services.CountryListService;
import com.pablop.survey.web.app.services.IPeopleService;

@Controller
@SessionAttributes("peopleAnalyzed") 
@RequestMapping("app/peopleanalyzed")
public class NewPeopleAnalyzedController {

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

	@Value("${text.indexController.analyzedPeople.lastName}")
	private String lastName;

	@Value("${text.newPeopleAnalyzed.loadForm.title}")
	private String title;
	
	@Value("${text.newPeopleAnalyzed.loadForm.send}")
	private String send;
	
	@Autowired
	private CountryListService countryListService;
	
	
	@Autowired
	private ICountryEditor countryEditor;
	

	@Autowired
	private IPeopleService iPeopleService;
	
	
	@ModelAttribute("countryList")
	private List<Country> coutryList() {
		return countryListService.getCountryListObject();
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Country.class, "country", (PropertyEditor) countryEditor);
		binder.registerCustomEditor(String.class, "firstName", new UpperCaseEditor());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));

	
	}
	
	

	@GetMapping("/new")
	public String loadForm(Model model) {

		PeopleAnalyzed peopleAnalyzed = new PeopleAnalyzed();

		peopleAnalyzed.setCountry(peopleAnalyzed.getCountry());
		
		model.addAttribute("peopleAnalyzed", peopleAnalyzed);
		model.addAttribute("fieldPeopleTestedEmail", fieldPeopleTestedEmail);
		model.addAttribute("fieldPeopleTestedBirthday", fieldPeopleTestedBirthday);
		model.addAttribute("fieldPeopleProfileFirstName", fieldPeopleProfileFirstName);
		model.addAttribute("fieldPeopleTestedCountry", fieldPeopleTestedCountry);
		model.addAttribute("fieldPeopleTestedLastName", fieldPeopleTestedLastName);
		model.addAttribute("lastName", lastName);		
		model.addAttribute("title", title);
		model.addAttribute("send", send);

		return "newpeopleanalyzed";
	}

	@PostMapping("/new")
	public String loadPeopleAnalyzedData(@Valid PeopleAnalyzed peopleAnalyzed, BindingResult result, Model model,
			SessionStatus status) {


		
		
		if (result.hasErrors()) {
			model.addAttribute("fieldPeopleTestedEmail", fieldPeopleTestedEmail);
			model.addAttribute("fieldPeopleTestedBirthday", fieldPeopleTestedBirthday);
			model.addAttribute("fieldPeopleProfileFirstName", fieldPeopleProfileFirstName);
			model.addAttribute("fieldPeopleTestedCountry", fieldPeopleTestedCountry);
			model.addAttribute("fieldPeopleTestedLastName", fieldPeopleTestedLastName);
			model.addAttribute("lastName", lastName);
			model.addAttribute("title", title);
			return "newpeopleanalyzed";
		}

		iPeopleService.addPeopleAnalyzed(peopleAnalyzed);

		status.setComplete();

		return "redirect:/app/peopleanalyzed";
	}

}
