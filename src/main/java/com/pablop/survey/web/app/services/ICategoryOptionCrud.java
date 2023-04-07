package com.pablop.survey.web.app.services;

import org.springframework.data.repository.CrudRepository;

import com.pablop.survey.web.app.models.entity.CategoryOption;

public interface ICategoryOptionCrud extends CrudRepository <CategoryOption, Long>{

}
