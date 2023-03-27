package com.pablop.survey.web.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.pablop.survey.web.app.validation.ArrayNotNull;



@Entity
@Table(name="surveys")
public class Survey implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private static final long serialVersionUID = 1L;

	@Column(name="survey_names")
	public  String surveyName;
	
	@ArrayNotNull
	@Column(name="survey_questions")
	private ArrayList<Question> surveyQuestions;

	@Column(name="survey_scores")
	private Double surveyScore;
	
	@Column(name="people_analized")
	private PeopleAnalyzed peopleAnalized; 
	
	@Column(name="users")
	private User user;
	
	private String type;

	
	public Survey(String surveyName, PeopleAnalyzed peopleAnalized) {
		super();
		this.surveyName = surveyName;
		this.peopleAnalized = peopleAnalized;
		surveyQuestions= new ArrayList<Question>();
	}

	
	public Survey() {
		super();
	}


	public String getSurveyName() {
		return surveyName;
	}


	public void setSurveyName(String surveyName) {
		this.surveyName = surveyName;
	}


	public ArrayList<Question> getSurveyQuestions() {
		return surveyQuestions;
	}


	public void setSurveyQuestions(ArrayList<Question> surveyQuestions) {
		this.surveyQuestions = surveyQuestions;
	}


	public Double getSurveyScore() {
		return surveyScore;
	}


	public void setSurveyScore(Double surveyScore) {
		this.surveyScore = surveyScore;
	}


	public PeopleAnalyzed getFriendAnalized() {
		return peopleAnalized;
	}


	public void setFriendAnalized(PeopleAnalyzed friendAnalized) {
		this.peopleAnalized = friendAnalized;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}
	
	
	
	
	
}
