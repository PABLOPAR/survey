package com.pablop.survey.web.app.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;



@Entity(name="questions")
public class Question implements Serializable{
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private static final long serialVersionUID = 1L;

		
	@NotEmpty
	@Column(name="question")
	private String question;
	

//	@Column(name = "chosen_value")
//	private QuestionOption chosenValue;

	@Max(10)
	@Min(1)
	@Column(name="question_Importance")
	private int questionImportance;
	
	@Column (name="target_people_analyzed")
	private PeopleAnalyzed peopleAnalyzed;
	
	
	@Column (name="survey_name")
	private Survey surveyName;
	
	@Column (name="researcher_user")
	private Survey researcherUser;
	
	
	
	public Question() {
		super();

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



//	public QuestionOption getChosenValue() {
//		return chosenValue;
//	}
//
//	public void setChosenValue(QuestionOption chosenValue) {
//		this.chosenValue = chosenValue;
//	}

	public int getQuestionImportance() {
		return questionImportance;
	}

	public void setQuestionImportance(int questionImportance) {
		this.questionImportance = questionImportance;
	}

	public PeopleAnalyzed getPeopleAnalyzed() {
		return peopleAnalyzed;
	}

	public void setPeopleAnalyzed(PeopleAnalyzed peopleAnalyzed) {
		this.peopleAnalyzed = peopleAnalyzed;
	}

	public Survey getSurveyName() {
		return surveyName;
	}

	public void setSurveyName(Survey surveyName) {
		this.surveyName = surveyName;
	}

	public Survey getResearcherUser() {
		return researcherUser;
	}

	public void setResearcherUser(Survey researcherUser) {
		this.researcherUser = researcherUser;
	}



}
