package com.pablop.survey.web.app.services;

import org.springframework.data.repository.CrudRepository;

import com.pablop.survey.web.app.models.entity.Role;

public interface IRoleCrud extends CrudRepository <Role, Long>{

	
}
