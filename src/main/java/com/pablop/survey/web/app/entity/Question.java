package com.pablop.survey.web.app.entity;

public class Question {
	
	private Integer questionId;
	private String question;
	private Integer questionWeighting;
	private String chosenValue;


	public Question(Integer questionId, String question, Integer questionWeighting) {
		super();
		this.questionId = questionId;
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

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
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



}
