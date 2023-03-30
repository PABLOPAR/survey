package com.pablop.survey.web.app.models.entity;


import java.io.Serializable;
import java.util.List;

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
	
//	private List<User> userList;
//	private List<Survey> surveyList;
	
	public CoreData() {
		super();
	}

	
	
	
//	public List<User> getUserList() {
//		return userList;
//	}
//
//	public void setUserList(List<User> userList) {
//		this.userList = userList;
//	}
//
//	public List<Survey> getSurveyList() {
//		return surveyList;
//	}
//
//	public void setSurveyList(List<Survey> surveyList) {
//		this.surveyList = surveyList;
//	}
	
	
	
	

}
