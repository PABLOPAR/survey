package com.pablop.survey.web.app.editors;

public class QuestionChosenValue {

	private String chosenValue;
	private String question;
	
	
	public String getPosibleValue() {
		return chosenValue;
	}
	public void setPosibleValue(String posibleValue) {
		this.chosenValue = posibleValue;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	
	public QuestionChosenValue(String chosenValue) {
		this.chosenValue=chosenValue;

	}
	
	
	
}
