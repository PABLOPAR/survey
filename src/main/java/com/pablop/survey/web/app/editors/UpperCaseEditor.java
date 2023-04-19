package com.pablop.survey.web.app.editors;

import java.beans.PropertyEditorSupport;

public class UpperCaseEditor extends PropertyEditorSupport{

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		setValue(text.toUpperCase().trim());
	}

	
	
}
