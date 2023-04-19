package com.pablop.survey.web.app.controllers;

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
import com.pablop.survey.web.app.services.IQuestionService;
import com.pablop.survey.web.app.services.IServiceSurvey;

@Controller
@RequestMapping ("app/survey")
public class SurveyListController {

	@Autowired
	private IQuestionService iQuestionService;
	
	
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
	
	
	
	@Value("${text.NoRegistersOnList}")
	public String NoRegistersOnList;
	
	@Value("${text.select}")
	public String select;
//	
//	
//	@Value("${}")
//	public String ;
//	
//	@Value("${}")
//	public String ;
	
	
	
	
		
	@Autowired
	private IServiceSurvey iServiceSurvey;
	
	@GetMapping("/list")
	public String surveylist(Model model) {
		
		List<Survey> surveyList= (List<Survey>) iServiceSurvey.findSurveyList();
		
		model.addAttribute("chooseYourSurvey", chooseYourSurvey);	
		model.addAttribute("surveyList", surveyList);
		model.addAttribute("survey", survey);		
		model.addAttribute("edit", edit);		
		model.addAttribute("AddQuestions", AddQuestions);	
		model.addAttribute("startTest", startTest);			
		model.addAttribute("AddNewSurvey", AddNewSurvey);		
		model.addAttribute("delete", delete);		
		model.addAttribute("listQuest", listQuest);	
		
		
		
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
	public String surveyList(@PathVariable Long id, Model model){
		
		Survey survey = iServiceSurvey.surveyfindById(id);
		
		List<Question> surveyQuestion= survey.getSurveyQuestions();
		
		model.addAttribute("surveyQuestion", surveyQuestion);
		model.addAttribute("titleListQuest",titleListQuest );	
		model.addAttribute("addQuestionToTest",addQuestionToTest );
		model.addAttribute("NoRegistersOnList",NoRegistersOnList );	
		model.addAttribute("select",select );
//		model.addAttribute("", );
//		model.addAttribute("", );
//		model.addAttribute("", );
		
		return "questionlistsurvey";
	}
	
	
	
}
