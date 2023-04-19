package com.pablop.survey.web.app.models.entity;

import java.util.ArrayList;

import com.pablop.survey.web.app.validation.ArrayNotNull;

public class Survey {


	public  String surveyName;
	
	@ArrayNotNull
	private ArrayList<Question> surveyQuestions;
	
	private Double surveyScore;
	
	private PeopleAnalyzed peopleAnalized; 
	
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
