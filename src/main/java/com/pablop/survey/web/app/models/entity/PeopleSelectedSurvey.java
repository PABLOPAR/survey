package com.pablop.survey.web.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PeopleSelectedSurvey  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Long idPeopleSelected;
	
	private Long surveyId;
	
	

	public PeopleSelectedSurvey(Long idPeopleSelected) {
		super();
		this.idPeopleSelected = idPeopleSelected;
	}

	public PeopleSelectedSurvey() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdPeopleSelected() {
		return idPeopleSelected;
	}

	public void setIdPeopleSelected(Long idPeopleSelected) {
		this.idPeopleSelected = idPeopleSelected;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(Long surveyId) {
		this.surveyId = surveyId;
	}

	@Override
	public String toString() {
		return "PeopleSelectedSurvey [id=" + id + ", idPeopleSelected=" + idPeopleSelected + ", surveyId=" + surveyId
				+ "]";
	}
	
	
	
	
}
