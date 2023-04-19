package com.pablop.survey.web.app.services;

import org.springframework.data.repository.CrudRepository;

import com.pablop.survey.web.app.models.entity.Country;

public interface ICountryListCrud extends CrudRepository <Country, Long>{

}
