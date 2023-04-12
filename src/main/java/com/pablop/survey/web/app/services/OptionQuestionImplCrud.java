package com.pablop.survey.web.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pablop.survey.web.app.models.entity.OptionQuestionCategory;

@Service
public class OptionQuestionImplCrud implements IQuestionOptionService{

	
	@Autowired
	private ICategoryOptionCrud ICategoryOptionCrud;

	@Override
	@Transactional(readOnly = true)
	public List<OptionQuestionCategory> getOptionQuestionList() {

		return (List<OptionQuestionCategory>) ICategoryOptionCrud.findAll();
	}
	
	
}
