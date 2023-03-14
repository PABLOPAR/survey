package com.pablop.survey.web.app.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.pablop.survey.web.app.models.entity.Question;

@Component
public class QuestionValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Question.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
	
		ValidationUtils.rejectIfEmpty(errors, "question", "NotEmpty");
		
	}

}
