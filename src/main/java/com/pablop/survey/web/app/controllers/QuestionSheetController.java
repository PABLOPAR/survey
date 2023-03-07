package com.pablop.survey.web.app.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pablop.survey.web.app.entity.Question;
import com.pablop.survey.web.app.services.QuestionService;

@Controller
@RequestMapping ("app/question")
public class QuestionSheetController {
	
	@Autowired
	private QuestionService questionService;
	
	@Value("${text.QuestionSheetController.showQuestion.title}")
	private String title;
	
	@Value("${text.QuestionSheetController.showQuestion.tab}")
	private String tab;
	
	@Value("${text.QuestionSheetController.showQuestion.option}")
	private String option;
	
	@Value("${text.indexController.analyzedPeople.nothingShow}")
	private String nothingShow;
	
	@ModelAttribute("posibleValues")
	public Map<String,String> posibleValues() {
		Map<String,String> posibleValues= new HashMap<String, String>();
		posibleValues.put("Ever","Ever");		
		posibleValues.put("NotSure","Not Sure");
		posibleValues.put("Never","Never");
		return posibleValues;
	};
	
	
	@GetMapping("/type")
	public String showQuestion(Model model) {
		
		List<Question> questionList= questionService.questionList();
		
		
		model.addAttribute("questionList", questionList);
		model.addAttribute("title", title);
		model.addAttribute("tab", tab);		
		model.addAttribute("option", option);		
		model.addAttribute("nothingShow", nothingShow);	

		
		return "questionSheet";
	};
	
	
	
	@PostMapping("/type")
	public String load(Model model, @RequestParam List<Question> questionList) {

		return "redirect:/type";
	}
	

}
