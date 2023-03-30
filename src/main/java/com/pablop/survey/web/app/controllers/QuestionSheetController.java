package com.pablop.survey.web.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.pablop.survey.web.app.editors.AllQuestionChosenValues;
import com.pablop.survey.web.app.models.entity.Question;
import com.pablop.survey.web.app.services.IQuestionService;

@Controller
@SessionAttributes("questionList")
@RequestMapping ("app/question")
public class QuestionSheetController {
	
	@Autowired
	private IQuestionService iQuestionService;
	
	@Value("${text.QuestionSheetController.showQuestion.title}")
	private String title;
	
	@Value("${text.QuestionSheetController.showQuestion.tab}")
	private String tab;
	
	@Value("${text.QuestionSheetController.showQuestion.option}")
	private String option;
	
	@Value("${text.indexController.analyzedPeople.nothingShow}")
	private String nothingShow;
	
	@ModelAttribute("posibleValues")
	public List<String> posibleValues() {
		ArrayList<String> posibleValues = new ArrayList<String>();
		posibleValues.add("Ever");
		posibleValues.add("Not Sure");
		posibleValues.add("Never");

		return posibleValues;
	};

	

	@GetMapping("/type")
	public String showQuestion(Model model) {
		
		List<Question> questionList= iQuestionService.questionList();
		
		model.addAttribute("questionList", questionList);
		
		
		
		
		AllQuestionChosenValues allQuestionChosenValues= new AllQuestionChosenValues();
		
		model.addAttribute("chosenValuesList",allQuestionChosenValues);
		model.addAttribute("questionList", questionList);
		model.addAttribute("title", title);
		model.addAttribute("tab", tab);		
		model.addAttribute("option", option);		
		model.addAttribute("nothingShow", nothingShow);	

		
		return "questionsheet";
	};
	
	
	
	@PostMapping("/type")
	public String load(@ModelAttribute AllQuestionChosenValues chosenValuesList, SessionStatus status, Model model) {

		
		status.setComplete();
		return "redirect:/type";
	}
	

}
