package com.pablop.survey.web.app.services;

import org.springframework.data.repository.CrudRepository;

import com.pablop.survey.web.app.models.entity.Survey;



public interface ISurveyServiceCrud extends CrudRepository <Survey, Long> {

	
	
	
}
