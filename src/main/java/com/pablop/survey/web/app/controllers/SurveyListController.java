package com.pablop.survey.web.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pablop.survey.web.app.models.entity.Question;
import com.pablop.survey.web.app.models.entity.Survey;
import com.pablop.survey.web.app.services.IQuestionSurveySelected;
import com.pablop.survey.web.app.services.IServiceSurvey;

@Controller
@RequestMapping ("app/survey")
public class SurveyListController {

	
	@Autowired
	private IQuestionSurveySelected iQuestionSurveySelected;
	
	@Autowired
	private IServiceSurvey iServiceSurvey;
	
	
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
	
	@Value("${text.delete}")
	private String delete;
	
	@Value("${text.SurveyListController.listQuest}")
	private String listQuest;
	
	@Value("${text.SurveyListController.AddQuestions}")
	private String AddQuestions;
	
	
	@Value("${text.NewQuestionController.newQuestion.title}")
	public String title;
	
	@Value("${text.SurveyListController.title}")
	public String titleListQuest;
	
	
	@Value("${text.SurveyListController.addQuestionToTest}")
	public String addQuestionToTest;
	
	
	@Value("${text.SurveyListController.AddQuestionHeader}")
	public String AddQuestionHeader;
	
//	@Value("${text.SurveyListController.CreateQuestionHeader}")
//	public String CreateQuestionHeader;

	
	@Value("${text.back}")
	public String back;
	
	@Value("${text.NoRegistersOnList}")
	public String NoRegistersOnList;
	
	@Value("${text.select}")
	public String select;
	
	
	@Value("${text.SurveyListController.personToTest}")
	public String personToTest;
	
	@Value("${text.new}")
	public String newTest;
	
	@Value("${text.SurveyListController.viewMySurveys}")
	public String viewMySurveys;
	
	@Value("${text.indexController.analyzedPeople.nothingShow}")
	public String nothingShow;

	@Value("${text.SurveyListController.viewResult}")
	public String viewResult;
	
	@Value("${text.SurveyListController.addNewQuestion}")
	public String addNewQuestion;
	
	
	


	
	@GetMapping("/list")
	public String surveylist(Model model) {
		
		ArrayList<Survey> surveyList= (ArrayList<Survey>) iServiceSurvey.findSurveyList();
		
		model.addAttribute("chooseYourSurvey", chooseYourSurvey);	
		model.addAttribute("surveyList", surveyList);
		model.addAttribute("survey", survey);		
		model.addAttribute("edit", edit);		
		model.addAttribute("AddQuestions", AddQuestions);	
		model.addAttribute("startTest", startTest);			
		model.addAttribute("AddNewSurvey", AddNewSurvey);		
		model.addAttribute("delete", delete);		
		model.addAttribute("listQuest", listQuest);	
		model.addAttribute("AddQuestionHeader", AddQuestionHeader);		
//		model.addAttribute("CreateQuestionHeader", CreateQuestionHeader);	
		model.addAttribute("personToTest", personToTest);			
		model.addAttribute("select", select);
		model.addAttribute("newTest", newTest);	
		model.addAttribute("viewMySurveys", viewMySurveys);	
		model.addAttribute("viewMySurveys", viewMySurveys);	
		model.addAttribute("viewMySurveys", viewMySurveys);		
		
		
		
		return "surveylist";
	}
	
	
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {

		if (survey != null) {

			Survey surveyRegister = iServiceSurvey.surveyfindById(id);

			if (surveyRegister != null) {

				iServiceSurvey.deleteSurveyById(id);
			}
		}

		return "redirect:/app/survey/list";
	}

	
	
	@GetMapping("/surveyquestions/{id}")
	public String surveyList(@PathVariable Long id, Model model) {

		Survey surveyAnalyzed= iServiceSurvey.surveyfindById(id);
		List<Question> questionIncluded=surveyAnalyzed.getSurveyQuestions();

		model.addAttribute("surveyId", id);
		model.addAttribute("surveyQuestions", questionIncluded);
		model.addAttribute("titleListQuest", titleListQuest);
		model.addAttribute("addQuestionToTest", addQuestionToTest);
		model.addAttribute("NoRegistersOnList", NoRegistersOnList);
		model.addAttribute("select", select);
		model.addAttribute("back", back);
		model.addAttribute("addNewQuestion", addNewQuestion);
		
		
		

		return "questionlistsurvey";
	}
	
	
	@GetMapping("/startnewtest/{id}")
	public String startNewTest(@PathVariable Long id, Model model) {
		
		Survey survModel= iServiceSurvey.surveyfindById(id);
		
		Survey currentSurvey= survModel;
		
		
		
		
		Survey survey= new Survey();
		
		iServiceSurvey.save(survey);
		
		
		

		return "redirect:/app/survey/list";
	}
	
	
	@GetMapping("/list/onprocess")
	public String surveyListOnProcess(Model model) {
		
ArrayList<Survey> surveyList= (ArrayList<Survey>) iServiceSurvey.findSurveyList();
System.out.println("surveyList SUR-LIS-CONT"+surveyList);
		
		model.addAttribute("chooseYourSurvey", chooseYourSurvey);	
		model.addAttribute("surveyList", surveyList);
		model.addAttribute("survey", survey);		
		model.addAttribute("edit", edit);		
		model.addAttribute("AddQuestions", AddQuestions);	
		model.addAttribute("startTest", startTest);			
		model.addAttribute("AddNewSurvey", AddNewSurvey);		
		model.addAttribute("delete", delete);		
		model.addAttribute("listQuest", listQuest);	
		model.addAttribute("AddQuestionHeader", AddQuestionHeader);		
//		model.addAttribute("CreateQuestionHeader", CreateQuestionHeader);	
		model.addAttribute("personToTest", personToTest);			
		model.addAttribute("select", select);
		model.addAttribute("newTest", newTest);	
		model.addAttribute("nothingShow", nothingShow);		
		model.addAttribute("back", back);
		model.addAttribute("viewResult", viewResult);		
		
		
		
		return "surveyonprocess";}
	
	
	
}
