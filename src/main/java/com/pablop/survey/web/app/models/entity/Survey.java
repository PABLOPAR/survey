package com.pablop.survey.web.app.models.entity;

import java.util.ArrayList;

import com.pablop.survey.web.app.validation.ArrayNotNull;

public class Survey {


	public  String surveyName;
	
	@ArrayNotNull
	private ArrayList<Question> surveyQuestions;
	
	private Double surveyScore;
	private PeopleAnalyzed friendAnalized; 
	private User user;

	
	public Survey(String surveyName, ArrayList<Question> surveyQuestions, Double surveyScore, PeopleAnalyzed friendAnalized, User user) {
		super();
		this.surveyName = surveyName;
		this.surveyQuestions = surveyQuestions;
		this.surveyScore = surveyScore;
		this.friendAnalized = friendAnalized;
		this.user = user;
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
		return friendAnalized;
	}


	public void setFriendAnalized(PeopleAnalyzed friendAnalized) {
		this.friendAnalized = friendAnalized;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	
}
