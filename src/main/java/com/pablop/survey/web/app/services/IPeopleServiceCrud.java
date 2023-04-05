package com.pablop.survey.web.app.services;

import org.springframework.data.repository.CrudRepository;

import com.pablop.survey.web.app.models.entity.PeopleAnalyzed;

public interface IPeopleServiceCrud extends CrudRepository <PeopleAnalyzed, Long> {


	
}
