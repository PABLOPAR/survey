package com.pablop.survey.web.app.models.entity;


import java.io.Serializable;
import java.util.ArrayList;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CoreData")
public class CoreData implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private ArrayList<User> userList;
	private ArrayList<Survey> surveyList;
	
	public CoreData() {
		super();
		userList= new ArrayList<User>();
		surveyList= new ArrayList<Survey>();
		
	}

	
	public ArrayList<User> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}

	public ArrayList<Survey> getSurveyList() {
		return surveyList;
	}

	public void setSurveyList(ArrayList<Survey> surveyList) {
		this.surveyList = surveyList;
	}
	
	
	
	

}
