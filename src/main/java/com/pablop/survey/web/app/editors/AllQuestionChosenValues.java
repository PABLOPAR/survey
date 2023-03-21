package com.pablop.survey.web.app.editors;

import java.util.ArrayList;
import java.util.List;

public class AllQuestionChosenValues {
	
	private List<QuestionChosenValue> questionChosenValueList=new ArrayList<QuestionChosenValue>();


	
//	public String addNewValue(String chosenValue) {
//		
//		QuestionChosenValue questionChosenValue= new QuestionChosenValue (chosenValue);
//		
//		questionChosenValueList.add(questionChosenValue);
//		
//		
//		return chosenValue;
//	}


	public List<QuestionChosenValue> getQuestionChosenValueList() {
		return questionChosenValueList;
	}


	public void setQuestionChosenValueList(List<QuestionChosenValue> questionChosenValueList) {
		this.questionChosenValueList = questionChosenValueList;
	}


	@Override
	public String toString() {
		return "AllQuestionChosenValues [questionChosenValueList=" + questionChosenValueList + "]";
	}

	
	


	
	
	
}
