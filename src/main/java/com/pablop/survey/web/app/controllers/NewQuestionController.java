package com.pablop.survey.web.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.pablop.survey.web.app.models.entity.Question;
import com.pablop.survey.web.app.services.IQuestionService;
import com.pablop.survey.web.app.validation.ArrayNotNullValidator;
import com.pablop.survey.web.app.validation.ItemsValidator;

@Controller
@SessionAttributes("question")
@RequestMapping("app/survey")
public class NewQuestionController {
	
	
	@Value("${text.NewQuestionController.newQuestion.title}")
	private String title;
	
	@Value("${text.NewQuestionController.newQuestion.addquestion}")
	private String addquestion;
	
	@Value("${text.NewQuestionController.newQuestion.questionWeighting}")
	private String questionWeighting;
	
	@Autowired
	private IQuestionService iQuestionService;
	
	
	@Autowired
	private ItemsValidator validator;
	

	@InitBinder
	public void InitBinder(WebDataBinder binder) {
		binder.addValidators(validator);
	}
	
	
	@GetMapping("/newquestion")
	public String createQuestion(Model model) {
		
		Question question= new Question(); 
		
		model.addAttribute("question", question);
		model.addAttribute("title", title);
		model.addAttribute("addQuestion", addquestion);
		model.addAttribute("questionWeighting", questionWeighting);
		
		return "newquestion";
	}
	
	
	@PostMapping("/newquestion")
	public String loadQuestion(@Valid Question question, BindingResult result, Model model, SessionStatus status) {
		
		
		if(result.hasErrors()) {
			model.addAttribute("title", title);
			model.addAttribute("addQuestion", addquestion);
			model.addAttribute("questionWeighting", questionWeighting);	
						
			return "newquestion";
		}
		
		
//		questionService.addQuestion(question);
		
	
		status.setComplete();

		return "redirect:/app/question/type";
	}
	
	

}
