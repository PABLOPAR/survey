package com.pablop.survey.web.app.services;

import org.springframework.data.repository.CrudRepository;

import com.pablop.survey.web.app.models.entity.Category;



public interface ICategoryCrud extends CrudRepository <Category, Long>{

}
