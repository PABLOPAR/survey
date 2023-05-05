package com.pablop.survey.web.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pablop.survey.web.app.editors.StringToNumberEditorImpl;
import com.pablop.survey.web.app.models.entity.Category;
import com.pablop.survey.web.app.models.entity.OptionQuestionCategory;
import com.pablop.survey.web.app.models.entity.Question;
import com.pablop.survey.web.app.models.entity.QuestionSurveySelected;
import com.pablop.survey.web.app.models.entity.Survey;
import com.pablop.survey.web.app.services.ICategoryService;
import com.pablop.survey.web.app.services.IQuestionOptionService;
import com.pablop.survey.web.app.services.IQuestionService;
import com.pablop.survey.web.app.services.IQuestionSurveySelected;
import com.pablop.survey.web.app.services.IServiceSurvey;

@Controller
@RequestMapping ("app/survey/test")
public class SurveyQuestionController {

	@Autowired
	private IQuestionService iQuestionService;
	
	@Autowired
	private IQuestionSurveySelected iQuestionSurveySelected;
	
	@Autowired
	private IServiceSurvey iServiceSurvey;
	
	@Autowired
	private ICategoryService iCategoryService;
	
	@Autowired
	private IQuestionOptionService iQuestionOptionService;
	
	@Autowired
	StringToNumberEditorImpl stringToNumberEditorImpl;
	
	
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
	
	@Value("${text.SurveyListController.CreateQuestionHeader}")
	public String CreateQuestionHeader;

	
	@Value("${text.back}")
	public String back;
	
	
	@Value("${text.Options}")
	public String Options;
	
	@Value("${text.SurveyQuestionController.Questions}")
	public String Questions;
	
	
	@Value("${text.SurveyQuestionController.FillInTitle}")
	public String FillInTitle;
	
	
	
	
	
	@Value("${text.NoRegistersOnList}")
	public String NoRegistersOnList;
	
	@Value("${text.select}")
	public String select;
	
	
	
	
	
	
	
	@GetMapping("/start/{id}")
	public String surveyTest(@PathVariable Long id, Model model) {

		QuestionSurveySelected questionSurveySelected = new QuestionSurveySelected();
		
		Survey survey=iServiceSurvey.surveyfindById(id);
		
		
		List<OptionQuestionCategory> optionListSelected = null;
		
		
		ArrayList<Question> questionAsList = survey.getSurveyQuestions();

		questionSurveySelected.setQuestionAsList(questionAsList);
		questionSurveySelected.setIdSurvey(id);

		Long idCategorySurveyImplemented = survey.getCategoryOptionId();

		Category categoryImplemented = iCategoryService.findCategoryById(idCategorySurveyImplemented);

		if (categoryImplemented != null) {

			Long idForThisCategory = categoryImplemented.getId();

			if (idForThisCategory > 0) {

				optionListSelected = new ArrayList<OptionQuestionCategory>();

				List<OptionQuestionCategory> allOptionsAvailable = iQuestionOptionService.getOptionQuestionList();

				for (OptionQuestionCategory option : allOptionsAvailable) {
					if (option.getCategoryOptionId().equals(idForThisCategory)) {

						optionListSelected.add(option);
					}
				}
			}

		}
		
		
		
		model.addAttribute("questionAsList", questionAsList);
		model.addAttribute("survey", survey);
		model.addAttribute("FillInTitle", FillInTitle);
		model.addAttribute("Questions", Questions);
		model.addAttribute("NoRegistersOnList", NoRegistersOnList);
		model.addAttribute("Options", Options);
		model.addAttribute("back", back);
		model.addAttribute("optionListSelected", optionListSelected);
		model.addAttribute("questionSurveySelected", questionSurveySelected);
		

		return "surveytest";
		
	}

	
	@PostMapping("/start/{id}")
	public String saveRecords(@PathVariable Long id, QuestionSurveySelected questionSurveySelected, Model model) {
		
		List<Question> questionWithChosenValues=questionSurveySelected.getQuestionAsList();
		
		Survey surveyAnalized= iServiceSurvey.surveyfindById(id);
		
		surveyAnalized.setSurveyQuestions((ArrayList<Question>) questionWithChosenValues);
		
		
		
		iServiceSurvey.save(surveyAnalized);
	
System.out.println("surveyAnalyzed SURVQUESTCONTR "  + surveyAnalized);	
	


		
		return "redirect:/app/survey/results/{id}";
	}
}
