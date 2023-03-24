package com.pablop.survey.web.app.errors;

import org.springframework.beans.factory.annotation.Value;

public class DuplicateUserException extends RuntimeException{

	@Value("${text.duplicateUserException.title1}")
	private static String title1;

	@Value("${text.duplicateUserException.title2}")
	private static String title2;
	
	public DuplicateUserException(String email) {
		super(title1.concat(" ").concat(email).concat(title2));

	}

	private static final long serialVersionUID = 1L;
	

}
