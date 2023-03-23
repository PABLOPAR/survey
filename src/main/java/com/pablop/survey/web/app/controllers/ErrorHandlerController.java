package com.pablop.survey.web.app.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandlerController{
	
	@Value("${text.template.error.message}")
	private String message;
	
	@Value("${text.template.error.promise}")
	private String promise;
	
	@Value("${text.template.error.errorType}")
	private String errorType;	
	
	
	
	
	@ExceptionHandler(RuntimeException.class)
	public String runTimeError(RuntimeException err, Model model) {
		model.addAttribute("message", message);
		model.addAttribute("promise", promise);
		model.addAttribute("errorType", errorType);
		model.addAttribute("type",HttpStatus.INTERNAL_SERVER_ERROR.value());
		return "error/500";
	}

//	@ExceptionHandler(Error.class)
//	public String WhiteLabelError(RuntimeException err, Model model) {
//		model.addAttribute("message", message);
//		model.addAttribute("promise", promise);
//		model.addAttribute("errorType", errorType);
//		model.addAttribute("class", err.getClass());
//		model.addAttribute("type",HttpStatus.INTERNAL_SERVER_ERROR.value());
//		return "error/404";
//	}

	
	
}
