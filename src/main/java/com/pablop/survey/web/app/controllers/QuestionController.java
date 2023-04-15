package com.pablop.survey.web.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pablop.survey.web.app.models.entity.Question;
import com.pablop.survey.web.app.services.IQuestionService;


@Controller
@RequestMapping ("app/survey/question")
public class QuestionController {

	@Autowired
	private IQuestionService iQuestionService;
	
	@Value("${text.QuestionController.QuestionListTitle}")
	public String QuestionListTitle;
	
	@Value("${text.QuestionController.headerTitle}")
	public String headerTitle;
	
	@Value("${text.NoRegistersOnList}")
	public String NoRegistersOnList;
	
	@Value("${text.NewQuestionController.newQuestion.title}")
	public String title;
	
	@Value("${text.NewQuestionController.newQuestion.addNewQuestion}")
	public String addNewQuestion;
//	
//	@Value("${}")
//	public String ;
	
//	@Value("${}")
//	public String ;
//	
//	@Value("${}")
//	public String ;
	
	
	@GetMapping("/questionlist")
	public String questionlist(Model model) {
		
		List<Question> questionList= iQuestionService.questionList();
		
		List<Question> questionsIncluded= iQuestionService.questionList();
		
		model.addAttribute("QuestionListTitle", QuestionListTitle);
		model.addAttribute("headerTitle",headerTitle );
		model.addAttribute("questionsIncluded",questionsIncluded );
		model.addAttribute("NoRegistersOnList",NoRegistersOnList );
		model.addAttribute("addNewQuestion",addNewQuestion );

		
		
		
		return "questionlist";
	}
	
	
	@GetMapping("/newquestion")
	public String newquestion(Model model) {
		model.addAttribute("title", title);

		
		model.addAttribute("title",title );		
//		model.addAttribute("", );	
//		model.addAttribute("", );
//		model.addAttribute("", );
		
		return "newquestion";
	}
	
	
	
	
}
