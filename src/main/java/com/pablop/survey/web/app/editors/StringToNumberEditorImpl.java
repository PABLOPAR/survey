package com.pablop.survey.web.app.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;

import com.pablop.survey.web.app.services.IQuestionService;

public class StringToNumberEditorImpl extends PropertyEditorSupport{

	
//	@Autowired
//	private IQuestionService iQuestionService;
	
	
	
	@Override
	public void setAsText(String IdForm) throws IllegalArgumentException {
		
		
		if (!IdForm.isEmpty()) {

			Long idLong = Long.parseLong(IdForm);

			this.setValue(idLong);

		} else {
			setValue(null);
		}

	}
	
}
