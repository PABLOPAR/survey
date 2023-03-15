package com.pablop.survey.web.app.validation;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.pablop.survey.web.app.models.entity.Question;

@Component
@Primary
public class QuestionValidatorImpl implements ItemsValidator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Question.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Question question = (Question) target;

//		ValidationUtils.rejectIfEmpty(errors, "question", "NotEmpty");

		if (question.getQuestionWeighting()>10 || question.getQuestionWeighting()<0) {
			errors.rejectValue("questionWeighting", "InvalidRange");
		}
	}

}
