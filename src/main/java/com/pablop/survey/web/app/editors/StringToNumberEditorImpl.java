package com.pablop.survey.web.app.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.stereotype.Component;

@Component
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
