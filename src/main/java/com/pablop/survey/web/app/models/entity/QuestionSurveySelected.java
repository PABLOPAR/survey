package com.pablop.survey.web.app.models.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pablop.survey.web.app.services.IQuestionService;

public class QuestionSurveySelected {

//	@Autowired
//	private IQuestionService iQuestionService;

	private List<Question> questionListSurvey;


	public QuestionSurveySelected() {
		questionListSurvey = new ArrayList<Question>();
//System.out.println("para aca??");
//		loadAllQuestionPossibilities();
//System.out.println("O para aca??");
	}

//	public void loadAllQuestionPossibilities() {
//		if (iQuestionService.questionList() != null) {
//			if (iQuestionService.questionList().size() > 0) {
//				for (Question question : iQuestionService.questionList()) {
//					questionListSurvey.add(question);
//				}
//			}
//		}
//	}

	public void addQuestion(Question question) {
		this.questionListSurvey.add(question);
	}



	public List<Question> getQuestionListSurvey() {
		return questionListSurvey;
	}

	public void setQuestionListSurvey(List<Question> questionListSurvey) {
		this.questionListSurvey = questionListSurvey;
	}

	@Override
	public String toString() {
		return "QuestionSurveySelected [questionListSurvey=" + questionListSurvey + "]";
	}







	
	
}
