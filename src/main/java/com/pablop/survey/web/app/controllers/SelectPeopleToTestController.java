package com.pablop.survey.web.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pablop.survey.web.app.models.entity.PeopleAnalyzed;
import com.pablop.survey.web.app.models.entity.PeopleSelectedSurvey;
import com.pablop.survey.web.app.models.entity.Survey;
import com.pablop.survey.web.app.services.IPeopleService;
import com.pablop.survey.web.app.services.IServiceSurvey;

@Controller
@RequestMapping(value="app/peopleAnalyzed/")
public class SelectPeopleToTestController {

	@Autowired
	private IPeopleService peopleAnalyzedList;
	
	@Autowired
	private IServiceSurvey iServiceSurvey;
	
	
	@Value("${text.SellectPeopleToTestController.title}")
	private String selectPersontitle;
	
	
	@Value("${text.indexController.analyzedPeople.name}")
	private String name;
	
	
	@Value("${text.select}")
	private String select;
	
	
	
	@GetMapping("select/{id}")
	public String selectPersonToTest(@PathVariable Long id, Model model) {
		
		PeopleSelectedSurvey peopleSelectedSurvey = new PeopleSelectedSurvey();
		
		List<PeopleAnalyzed> analyzedList = peopleAnalyzedList.getPeopleAnalyzedList();

		model.addAttribute("selectPersontitle", selectPersontitle);
		model.addAttribute("surveyId", id);

		model.addAttribute("analyzedList", analyzedList);
		model.addAttribute("peopleSelectedSurvey", peopleSelectedSurvey);
		model.addAttribute("name", name);
		model.addAttribute("select", select);
	
		
	return "selectperson";
	}
	
	
	@PostMapping("select/{id}")
	public String savePerson(@PathVariable Long id, PeopleSelectedSurvey peopleSelectedSurvey, Model model) {
		
		Long idPersonSelected= peopleSelectedSurvey.getIdPeopleSelected();
		
		PeopleAnalyzed personSearched= peopleAnalyzedList.findPeopleById(idPersonSelected);
		
		
		Long surveyId=peopleSelectedSurvey.getSurveyId();
System.out.println("idSurvey SELECPEOPCONTR "+ surveyId);
		
		Survey modelSurvey=iServiceSurvey.surveyfindById(id);
System.out.println("Survey MODEL SELECPEOPCONTR "+modelSurvey);
		
		
		String newNameSurvey=modelSurvey.getSurveyName() + " (" +personSearched.getFirstName()+")";
				
		Survey currentSurvey= new Survey();
		currentSurvey.setSurveyName(newNameSurvey);
		currentSurvey.setCategoryOptionId(modelSurvey.getCategoryOptionId());
		currentSurvey.setSurveyQuestions(modelSurvey.getSurveyQuestions());
		currentSurvey.setIdPeopleAnalized(idPersonSelected);
		
		currentSurvey.setALayOut(true);
		
		iServiceSurvey.save(currentSurvey);
		
System.out.println("Survey con person y ID SELPEOPCONT "+currentSurvey.toString());
		
		
		
		
		return "redirect:/app/survey/list/onprocess";
	}
}
