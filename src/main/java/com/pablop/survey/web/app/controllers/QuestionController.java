package com.pablop.survey.web.app.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.pablop.survey.web.app.models.entity.Question;
import com.pablop.survey.web.app.services.IQuestionService;


@Controller
@RequestMapping ("app/survey/question")
@SessionAttributes("question")
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
	
	@Value("${text.QuestionController.addYourQuestion}")
	public String addYourQuestion;
	
	@Value("${text.NewQuestionController.valueExplain}")
	public String valueExplain;
	
	@Value("${text.Send}")
	public String send;
	
	@Value("${text.QuestionController.duplicateQuestion}")
	public String duplicateQuestion;
	
	
	
	
	@GetMapping("/questionlist")
	public String questionlist(Model model) {
		
	
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

		Question question=new Question();
		
		model.addAttribute("question", question);
		model.addAttribute("title",title );		
		model.addAttribute("addYourQuestion",addYourQuestion );	
		model.addAttribute("valueExplain",valueExplain );
		model.addAttribute("send",send );
//		model.addAttribute("", );
//		model.addAttribute("", );
//		model.addAttribute("", );
		
		return "newquestion";
	}
	
	
	@PostMapping("/newquestion")
	public String addNewQuestion(@Valid Question question, BindingResult result, Model model, SessionStatus status) {
		model.addAttribute("title", title);

		
		if(result.hasErrors()) {
			model.addAttribute("title",title );		
			model.addAttribute("addYourQuestion",addYourQuestion );	
			model.addAttribute("valueExplain",valueExplain );
			model.addAttribute("send",send );
			
			return "newquestion";
		}
		
		if(iQuestionService.findByQuestionText(question.getQuestion())!=null) {
			model.addAttribute("title",title );		
			model.addAttribute("addYourQuestion",addYourQuestion );	
			model.addAttribute("valueExplain",valueExplain );
			model.addAttribute("send",send );
			model.addAttribute("duplicateQuestion",duplicateQuestion );		
			
			
			return "newquestion";	
			
		
		} else {

			iQuestionService.addQuestion(question);

		}
		return "redirect:/app/survey/question/questionlist";
	}
	
	
}
