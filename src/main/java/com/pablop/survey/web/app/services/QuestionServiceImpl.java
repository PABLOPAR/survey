package com.pablop.survey.web.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import com.pablop.survey.web.app.models.entity.Question;

@Service("QuestionServiceImpl")
@RequestScope
@Primary
public class QuestionServiceImpl implements QuestionService{

	private Double pointsEarned;
	
	private List<Question> questionList;
	
	
	public QuestionServiceImpl() {
		List<Question> questionList = new ArrayList<Question>();
		questionList.add(new Question(1, "Would you lend him your house for his vacations?", 3));
		questionList.add(new Question(2,
				"Would you lend him money so that he returns it to you on a date that you will surely need it?", 4));
		questionList.add(
				new Question(3, "Would you entrust your favorite person to take care of it while you are gone?", 5));
		questionList.add(new Question(4, "Would you tell him some of your most intimate secrets?", 4));
		questionList.add(new Question(5, "Has he broken his word with you?", 4));
		
		this.questionList=questionList;
			
	}


	@Override
	public List<Question> questionList() {
		
		return questionList;
	}


	public void addQuestion(Question question) {

		questionList.add(question);

	}

	public Double getPointsEarned() {
		return pointsEarned;
	}



	public void setPointsEarned(Double pointsEarned) {
		this.pointsEarned = pointsEarned;
	}



	public List<Question> getQuestionList() {
		return questionList;
	}



	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}
		
	

}
