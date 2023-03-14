package com.pablop.survey.web.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.pablop.survey.web.app.models.entity.PeopleAnalyzed;
import com.pablop.survey.web.app.services.PeopleService;

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

	@Value("${text.newPeopleAnalyzed.loadForm.title}")
	private String title;

	@Value("${text.newPeopleAnalyzed.loadForm.send}")
	private String send;

	@Autowired
	private PeopleService peopleService;

	@GetMapping("/new")
	public String loadForm(Model model) {

		PeopleAnalyzed peopleAnalyzed = new PeopleAnalyzed();
		peopleAnalyzed.setCountry("Angola");
		peopleAnalyzed.setFirstName("Diego");
		model.addAttribute("peopleAnalyzed", peopleAnalyzed);
		model.addAttribute("fieldPeopleTestedEmail", fieldPeopleTestedEmail);
		model.addAttribute("fieldPeopleTestedBirthday", fieldPeopleTestedBirthday);
		model.addAttribute("fieldPeopleProfileFirstName", fieldPeopleProfileFirstName);
		model.addAttribute("fieldPeopleTestedCountry", fieldPeopleTestedCountry);
		model.addAttribute("fieldPeopleTestedLastName", fieldPeopleTestedLastName);
		model.addAttribute("title", title);
		model.addAttribute("send", send);

		return "newpeopleanalyzed";
	}

	@PostMapping("/new")
	public String loadPeopleAnalyzedData(@Valid PeopleAnalyzed peopleAnalyzed, BindingResult result, Model model, SessionStatus status) {

		if (result.hasErrors()) {
			model.addAttribute("fieldPeopleTestedEmail", fieldPeopleTestedEmail);
			model.addAttribute("fieldPeopleTestedBirthday", fieldPeopleTestedBirthday);
			model.addAttribute("fieldPeopleProfileFirstName", fieldPeopleProfileFirstName);
			model.addAttribute("fieldPeopleTestedCountry", fieldPeopleTestedCountry);
			model.addAttribute("fieldPeopleTestedLastName", fieldPeopleTestedLastName);
			model.addAttribute("title", title);
			return "newpeopleanalyzed";
		}

		peopleService.addPeopleAnalyzed(peopleAnalyzed);

		System.out.println("Mirar ACA: " + peopleAnalyzed.toString());
		System.out.println("Mirar ACA 3: " + peopleService.getPeopleAnalyzedList().toString());
		System.out.println("Mirar aca 5: Size " + peopleService.getPeopleAnalyzedList().size());

		status.setComplete();
		
		return "redirect:/app/peopleanalyzed";
	}

}
