package com.pablop.survey.web.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.pablop.survey.web.app.validation.ArrayNotNull;



@Entity(name="surveys")
public class Survey implements Serializable{

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private static final long serialVersionUID = 1L;

	@Column(name="survey_name")
	@NotEmpty
	public  String surveyName;
	
	@ArrayNotNull
	@Column(name="survey_question",length = 1000)
	private ArrayList<Question> surveyQuestions= new ArrayList<Question>();

	@Column(name="survey_score")
	private Double surveyScore;
	
	@Column(name="people_analized")
	private Long idPeopleAnalized; 
	
	@Column (name="category_option_id")
    private Long categoryOptionId;
	
	@Column(name="users")
	private User user;
	
	@Column
	private String type;
	
	@Column(name="is_a_layout")
	private boolean isALayOut; 
	
	
//	public double highestPossibleScore() {
//		double result=0;
//		
//		for(Question question: surveyQuestions) {
//			
//			
//			
//		}
//		
//		
//		
//	}
	
	
	
	
	
	

	
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


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getCategoryOptionId() {
		return categoryOptionId;
	}


	public void setCategoryOptionId(Long categoryOptionId) {
		this.categoryOptionId = categoryOptionId;
	}


	public Long getIdPeopleAnalized() {
		return idPeopleAnalized;
	}


	public void setIdPeopleAnalized(Long idPeopleAnalized) {
		this.idPeopleAnalized = idPeopleAnalized;
	}


	public boolean isALayOut() {
		return isALayOut;
	}


	public void setALayOut(boolean isALayOut) {
		this.isALayOut = isALayOut;
	}


	@Override
	public String toString() {
		return "Survey [id=" + id + ", surveyName=" + surveyName + ", surveyQuestions=" + surveyQuestions
				+ ", surveyScore=" + surveyScore + ", idPeopleAnalized=" + idPeopleAnalized + ", categoryOptionId="
				+ categoryOptionId + ", user=" + user + ", type=" + type + ", isALayOut=" + isALayOut + "]";
	}



	
	
	
	
	
}
