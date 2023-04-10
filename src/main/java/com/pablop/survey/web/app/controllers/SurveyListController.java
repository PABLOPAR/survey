package com.pablop.survey.web.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pablop.survey.web.app.models.entity.Survey;
import com.pablop.survey.web.app.services.ISurveyServiceCrud;

@Controller
@RequestMapping ("app/survey")
public class SurveyListController {

	@Value("${text.SurveyListController.chooseYourSurvey}")
	private String chooseYourSurvey;
	
	@Value("${text.SurveyListController.Survey}")
	private String survey;
	
	@Value("${text.edit}")
	private String edit; 
	
	@Value("${text.Start}")
	private String start;
	
	@Value("${text.SurveyListController.AddNewSurvey}")
	private String AddNewSurvey;
	
	@Value("${text.SurveyListController.StartTest}")
	private String startTest;
	

	@Autowired
	private ISurveyServiceCrud iSurveyServiceCrud;
	
	@GetMapping("/list")
	public String surveylist(Model model) {
		
		List<Survey> surveyList= (List<Survey>) iSurveyServiceCrud.findAll();
		
		model.addAttribute("chooseYourSurvey", chooseYourSurvey);	
		model.addAttribute("surveyList", surveyList);
		model.addAttribute("survey", survey);		
		model.addAttribute("edit", edit);		
		model.addAttribute("start", start);	
		model.addAttribute("startTest", startTest);			
		model.addAttribute("AddNewSurvey", AddNewSurvey);		

		
		
		return "surveylist";
	}
}
