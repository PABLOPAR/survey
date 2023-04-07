package com.pablop.survey.web.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="questions")
public class Question implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private static final long serialVersionUID = 1L;

	
	@NotEmpty
	@Column(name="question")
	private String question;
	
	@NotNull
	@Column(name = "chosen_value")
	private QuestionOption chosenValue;

	
	@Column(name="question_weighting")
	private ArrayList<QuestionOption> options;
	
	@Column (name="target_people_analyzed")
	private PeopleAnalyzed peopleAnalyzed;
	
	
	@Column (name="survey_name")
	private Survey surveyName;
	
	@Column (name="researcher_user")
	private Survey researcherUser;
	
	
	
	
	
	
	public Question(Integer questionId, String question) {
		super();
		this.question = question;

	}

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<QuestionOption> getOptiones() {
		return options;
	}

	public void setOptiones(List<QuestionOption> optiones) {
		this.options = options;
	}

	public QuestionOption getChosenValue() {
		return chosenValue;
	}

	public void setChosenValue(QuestionOption chosenValue) {
		this.chosenValue = chosenValue;
	}



}
