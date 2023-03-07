package com.pablop.survey.web.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pablop.survey.web.app.entity.Question;

@Service
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
		questionList.add(new Question(4, "Has he broken his word with you?", 4));
		
		this.questionList=questionList;
			
	}



	@Override
	public List<Question> questionList() {
		
		return questionList;
	}


	@Override
	public Question searchQuestionByID(Integer ID) {

		Question questionSearched = null;
		Integer index = 0;

		if (ID != null) {

			while (questionSearched == null && index < questionList.size()) {
				if (questionList.get(index).getQuestionId() == ID) {
					questionSearched = questionList.get(index);

				} else {
					index++;
				}
			}
		}
		return questionSearched;
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