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
	private static final long serialVersionUID = 1L;
	
	

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
		
	@NotEmpty
	@Column(name="question")
	private String question;
	

	@Max(10)
	@Min(1)
	@Column(name="question_Importance")
	private int questionImportance;
	
	@Column (name="target_people_analyzed")
	private PeopleAnalyzed peopleAnalyzed;
	
	
	@Column (name="survey_id_fk")
	private Long surveyIdFk;
	
	
	@Column  (name="question_selected")
	private boolean selected;
	
	
	@Column (name="value_chosen")
	private Long idValChos;
	
	
	
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



	public boolean isSelected() {
		return selected;
	}


	public void setSelected(boolean selected) {
		this.selected = selected;
	}


	public Long getSurveyIdFk() {
		return surveyIdFk;
	}


	public void setSurveyIdFk(Long surveyIdFk) {
		this.surveyIdFk = surveyIdFk;
	}


	public Long getIdValChos() {
		return idValChos;
	}


	public void setIdValChos(Long idValChos) {
		this.idValChos = idValChos;
	}


	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", questionImportance=" + questionImportance
				+ ", peopleAnalyzed=" + peopleAnalyzed + ", surveyIdFk=" + surveyIdFk + ", selected=" + selected
				+ ", idValChos=" + idValChos + "]";
	}









}
