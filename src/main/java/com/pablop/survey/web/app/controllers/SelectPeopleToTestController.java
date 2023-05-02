package com.pablop.survey.web.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pablop.survey.web.app.models.entity.PeopleAnalyzed;
import com.pablop.survey.web.app.models.entity.PeopleSelectedSurvey;
import com.pablop.survey.web.app.services.IPeopleService;

@Controller
@RequestMapping(value="app/peopleAnalyzed/")
public class SelectPeopleToTestController {

	@Autowired
	private IPeopleService peopleAnalyzedList;
	
	
	@Value("${text.SellectPeopleToTestController.title}")
	private String selectPersontitle;
	
	
	@Value("${text.indexController.analyzedPeople.name}")
	private String name;
	
	
	@Value("${text.select}")
	private String select;
	
	
	
	@GetMapping("select")
	public String selectPeopleToTest(Model model) {
		
		PeopleSelectedSurvey peopleSelectedSurvey=new PeopleSelectedSurvey();
		
	List<PeopleAnalyzed> analyzedList = peopleAnalyzedList.getPeopleAnalyzedList();
	
	model.addAttribute("selectPersontitle", selectPersontitle);
	
	model.addAttribute("analyzedList", analyzedList);
	model.addAttribute("peopleSelectedSurvey", peopleSelectedSurvey);
	model.addAttribute("name", name);
	model.addAttribute("select", select);
	
	
	
	
	
	
	
	
	
	
	return "selectperson";
	}
	
}
