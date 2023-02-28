package com.pablop.survey.web.app.models;

public class Question {
	
	private Integer questionId;
	private String question;
	private Integer questionValue;
	
	public Question(Integer questionId, String question, Integer questionValue) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.questionValue = questionValue;
	}
	public Question() {
		super();
		// TODO Auto-generated constructor stub
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
		return questionValue;
	}
	public void setQuestionValue(Integer questionValue) {
		this.questionValue = questionValue;
	}


	
}
