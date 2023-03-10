package com.pablop.survey.web.app.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pablop.survey.web.app.models.entity.PeopleAnalyzed;
import com.pablop.survey.web.app.services.PeopleService;

@Controller
@RequestMapping("app/peopleAnalyzed")
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
	
	@Value("${text.newPeopleAnalyzed.loadForm.title}")
	private String title;
	
	@Value("${text.newPeopleAnalyzed.loadForm.send}")
	private String send;
	
	
	@Autowired
	private PeopleService peopleService;
	
	
	@GetMapping("/new")
	public String loadForm(Model model) {
		

		model.addAttribute("fieldPeopleTestedEmail", fieldPeopleTestedEmail);
		model.addAttribute("fieldPeopleTestedBirthday", fieldPeopleTestedBirthday);
		model.addAttribute("fieldPeopleProfileFirstName", fieldPeopleProfileFirstName);
		model.addAttribute("fieldPeopleTestedCountry", fieldPeopleTestedCountry);
		model.addAttribute("fieldPeopleTestedLastName", fieldPeopleTestedLastName);	
		model.addAttribute("title", title);			
		model.addAttribute("send", send);	
		
		
		return "newPeopleAnalyzed";
	}
	
	@PostMapping("/new")
	public String loadPeopleAnalyzedData(Model model, @RequestParam String firstName, @RequestParam String email, @RequestParam String country,
			@RequestParam String birthday) {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
		
		ZoneId defaultZoneId = ZoneId.systemDefault();
		LocalDate date1 = LocalDate.of(1000, 1, 1);	
		Date date = Date.from(date1.atStartOfDay(defaultZoneId).toInstant());
		

		try {
			date = formatter.parse(birthday);
		} catch (ParseException e) {
		}
		
		PeopleAnalyzed peopleAdded=new PeopleAnalyzed(country, date, firstName,email);
		
		
		peopleService.addPeopleAnalyzed(peopleAdded);
		

		return "redirect:/app/peopleAnalyzed";
	}
	
}
