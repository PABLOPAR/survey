package com.pablop.survey.web.app.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy=ArrayNotNullValidator.class)
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface ArrayNotNull {
	
	String message() default "{ArrayNotNull}";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };



}
