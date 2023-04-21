package com.pablop.survey.web.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class QuestionSurveySelected implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private ArrayList<Question> questionAsList;


	public QuestionSurveySelected() {
		super();
		questionAsList= new ArrayList<Question> ();
	}
	

	
	public void addQuestion(Question question) {
		questionAsList.add(question);
	
	
}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ArrayList<Question> getQuestionAsList() {
		return questionAsList;
	}

	public void setQuestionAsList(ArrayList<Question> questionAsList) {
		this.questionAsList = questionAsList;
	}



	@Override
	public String toString() {
		return "QuestionSurveySelected [id=" + id + ", questionAsList=" + questionAsList + "]";
	}

	


}
