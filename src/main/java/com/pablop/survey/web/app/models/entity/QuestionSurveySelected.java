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

	@Column(length = 3000)
	private ArrayList<Question> questionAsList;

	@Column(name = "id_survey")
	private Long idSurvey;
	
	
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



	public Long getIdSurvey() {
		return idSurvey;
	}



	public void setIdSurvey(Long idSurvey) {
		this.idSurvey = idSurvey;
	}



	@Override
	public String toString() {
		return "QuestionSurveySelected [id=" + id + ", questionAsList=" + questionAsList + ", idSurvey=" + idSurvey
				+ "]";
	}

	


}
