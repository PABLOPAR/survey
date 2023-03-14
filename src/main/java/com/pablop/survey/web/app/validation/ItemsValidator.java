package com.pablop.survey.web.app.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public interface ItemsValidator extends Validator {

	public void validate(Object target, Errors errors); 
	
}
