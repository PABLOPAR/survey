package com.pablop.survey.web.app.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pablop.survey.web.app.models.entity.Survey;
import com.pablop.survey.web.app.services.IServiceSurvey;
import com.pablop.survey.web.app.services.IPeopleService;

@Controller
@RequestMapping("admin")
public class AppAdminController {
	
	@Value ("${text.AppAdminController.basicSetUp.title}")
	private String title;
	
	@Value ("${text.AppAdminController.basicSetUp.surveyList}")
	private String surveyList;
	
	@Value ("${text.AppAdminController.basicSetUp.addSurvey}")
	private String addSurvey;
	
	@Value ("${text.AppAdminController.basicSetUp.ViewSurvey}")
	private String ViewSurvey;	
	
	
	@Autowired
	private IPeopleService iPeopleService;
	
	@Autowired
	private IServiceSurvey iServiceSurvey;
	
	
	@GetMapping("/setup")
	public String basicSetUp(Model model) {
		
		ArrayList<Survey> exampleListSurvey= (ArrayList<Survey>) iServiceSurvey.exampleListSurvey();
		
		model.addAttribute("title", title);
		model.addAttribute("surveyList", surveyList);	 
		model.addAttribute("addSurvey", addSurvey);	
		model.addAttribute("ViewSurvey", ViewSurvey);
		model.addAttribute("exampleListSurvey", exampleListSurvey);
		
		
		
		return "basicsetup";
	}

}
