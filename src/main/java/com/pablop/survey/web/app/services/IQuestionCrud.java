package com.pablop.survey.web.app.services;

import org.springframework.data.repository.CrudRepository;

import com.pablop.survey.web.app.models.entity.Question;

public interface IQuestionCrud extends CrudRepository <Question, Long>{

	
}
