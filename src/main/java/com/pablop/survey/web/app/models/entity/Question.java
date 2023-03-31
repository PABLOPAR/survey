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
import javax.validation.constraints.NotNull;

@Entity
@Table(name="questions")
public class Question implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private static final long serialVersionUID = 1L;

	
	@NotEmpty
	@Column(name="question")
	private String question;
	
	@Min(1)
	@Max(10)
	@NotNull
	@Column(name="question_weighting")
	private Integer questionWeighting;
	
	@Column(name="chosen_value")
	private String chosenValue;


	public Question(Integer questionId, String question, Integer questionWeighting) {
		super();
		this.question = question;
		this.questionWeighting = questionWeighting;
	}

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getChosenValue() {
		return chosenValue;
	}
	
	public void setChosenValue(String chosenValue) {
		this.chosenValue = chosenValue;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Integer getQuestionValue() {
		return questionWeighting;
	}

	public void setQuestionValue(Integer questionValue) {
		this.questionWeighting = questionValue;
	}

	public Integer getQuestionWeighting() {
		return questionWeighting;
	}

	public void setQuestionWeighting(Integer questionWeighting) {
		this.questionWeighting = questionWeighting;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



}
