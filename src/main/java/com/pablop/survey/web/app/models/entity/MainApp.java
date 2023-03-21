package com.pablop.survey.web.app.models.entity;

import java.util.ArrayList;

public class MainApp {

	private ArrayList<Survey> surveyList;
	private ArrayList<User> userList;
	
	
	public MainApp() {
		super();
		surveyList= new ArrayList<Survey>();
		userList= new ArrayList<User>();
	}


	public ArrayList<Survey> getSurveyList() {
		return surveyList;
	}


	public void setSurveyList(ArrayList<Survey> surveyList) {
		this.surveyList = surveyList;
	}


	public ArrayList<User> getUserList() {
		return userList;
	}


	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}
	
	
	
	
	
}
