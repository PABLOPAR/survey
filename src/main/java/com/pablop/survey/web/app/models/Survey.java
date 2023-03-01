package com.pablop.survey.web.app.models;

public class Survey {


	public  String surveyName;
	private Question[] surveyQuestions;
	private Double surveyScore;
	private PeopleAnalyzed friendAnalized; 
	private User user;

	
	public Survey(String surveyName, Question[] surveyQuestions, Double surveyScore, PeopleAnalyzed friendAnalized, User user) {
		super();
		this.surveyName = surveyName;
		this.surveyQuestions = surveyQuestions;
		this.surveyScore = surveyScore;
		this.friendAnalized = friendAnalized;
		this.user = user;
	}
	
	
	
	
	
}
