package com.pablop.survey.web.app.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.pablop.survey.web.app.models.entity.IdRegister;
import com.pablop.survey.web.app.models.entity.Question;
import com.pablop.survey.web.app.models.entity.QuestionSurveySelected;
import com.pablop.survey.web.app.services.IQuestionService;
import com.pablop.survey.web.app.services.IQuestionSurveySelected;
import com.pablop.survey.web.app.services.ISupportForm;


@Controller
@RequestMapping ("app/survey/question")
@SessionAttributes("question")
public class QuestionController {

	@Autowired
	private IQuestionService iQuestionService;
	
	@Autowired
	private IQuestionSurveySelected iQuestionSurveySelected;
	
	@Autowired
	ISupportForm iSupportForm;
	
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
	
	@Value("${text.indexController.analyzedPeople.edit}")
	private String edit;
	
	@Value("${text.QuestionSheetController.showQuestion.tab}")
	private String questionTitleCard;
	
	@Value("${text.select}")
	public String select;
	
	@Value("${text.QuestionSheetController.QuestionOptionTitle}")
	public String QuestionOptionTitle;
	
//	@Value("${}")
//	public String ;
//	
//	@Value("${}")
//	public String ;
	
//	@Value("${}")
//	public String ;
//	
//	@Value("${}")
//	public String ;
	
	
//	@Value("${}")
//	public String ;
//	
//	@Value("${}")
//	public String ;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
//		binder.registerCustomEditor(Country.class, "country", (PropertyEditor) countryEditor);
	}
	
	
	@GetMapping("/questionlist/{id}")
	public String questionlist(@PathVariable Long id, Model model) {

		List<Question> allQuestionAvailable = iQuestionService.questionList();

		QuestionSurveySelected questionSurveySelected = new QuestionSurveySelected();
		
		questionSurveySelected.setIdSurvey(id);
		


		if (allQuestionAvailable.size() > 0) {

			for (Question question : allQuestionAvailable) {
				question.setSurveyIdFk(id);
				questionSurveySelected.addQuestion(question);

			}
		}
		
		List<Question> questionAsList=questionSurveySelected.getQuestionAsList();


		IdRegister idRegister= new IdRegister();
		
		model.addAttribute("QuestionListTitle", QuestionListTitle);
		model.addAttribute("headerTitle",headerTitle );
		model.addAttribute("questionSurveySelected",questionSurveySelected);
		model.addAttribute("NoRegistersOnList",NoRegistersOnList );
		model.addAttribute("addNewQuestion",addNewQuestion );
		model.addAttribute("edit", edit);	
		model.addAttribute("questionTitleCard", questionTitleCard);		
		model.addAttribute("select",select );
		model.addAttribute("QuestionOptionTitle",QuestionOptionTitle );
		model.addAttribute("QuestionOptionTitle",QuestionOptionTitle );
		model.addAttribute("questionAsList", questionAsList);
		
		
		model.addAttribute("idRegister", idRegister);		
//		model.addAttribute("", );
//		model.addAttribute("", );		
		
		
		return "questionlist";
	}
	
	
	@PostMapping("/questionlist")
	public String saveQuestionSelected(QuestionSurveySelected questionSurveySelected, Model model) {


		
		QuestionSurveySelected questionsToBeAdded= new QuestionSurveySelected();
		questionsToBeAdded.setQuestionAsList(questionSurveySelected.getQuestionAsList());
		questionsToBeAdded.setIdSurvey(questionSurveySelected.getIdSurvey());
		

		iQuestionSurveySelected.QuestionSurveySelectedAdd(questionsToBeAdded);

		return "redirect:/app/survey/list";
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
		return "redirect:/app/survey/list";
	}
	
	
	@GetMapping("/edit/{id}")
	public String editQuestion(@PathVariable Long id, Model model) {

		Question question = new Question();

		if ( id > 0) {

			question = iQuestionService.findQuestionById(id);

			if (question == null) {
				return "redirect:/app/survey/question/questionlist";
			}

			else {

				model.addAttribute("question", question);
				model.addAttribute("title", title);
				model.addAttribute("addYourQuestion", addYourQuestion);
				model.addAttribute("valueExplain", valueExplain);
				model.addAttribute("send", send);
				model.addAttribute("edit", edit);
				model.addAttribute("questionTitleCard", questionTitleCard);



				return "newquestion";
			}

		}

		return "redirect:/app/survey/question/newquestion";
	}
	


	
	
	
}
