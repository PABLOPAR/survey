package com.pablop.survey.web.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pablop.survey.web.app.models.entity.Question;
import com.pablop.survey.web.app.services.IQuestionService;

@Controller
@RequestMapping("app/survey/question")
public class QuestionController {

	@Autowired
	private IQuestionService iQuestionService;
	
	
	
	@GetMapping("/questionlist")
	public String questionlist(Model model) {
		
		List<Question> questionList= iQuestionService.questionList();
		
		return "questionlist";
	}
}
