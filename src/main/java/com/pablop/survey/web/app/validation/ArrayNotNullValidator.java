package com.pablop.survey.web.app.validation;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.pablop.survey.web.app.models.entity.Question;

public class ArrayNotNullValidator implements ConstraintValidator<ArrayNotNull, List<Question>> {

	@Override
	public boolean isValid(List<Question> value, ConstraintValidatorContext context) {

		boolean result = true;

		if (value == null) {
			result=false;
			
		}
		return result;
	}

}

//Example of customized annotations.