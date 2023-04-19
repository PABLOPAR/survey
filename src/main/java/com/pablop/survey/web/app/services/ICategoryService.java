package com.pablop.survey.web.app.services;

import java.util.ArrayList;
import java.util.List;

import com.pablop.survey.web.app.models.entity.Category;
import com.pablop.survey.web.app.models.entity.OptionQuestionCategory;


public interface ICategoryService {

	
	public List<Category> getListCategory();
	public void saveCategory(Category category);
	public Category findCategoryById(Long id);
	public ArrayList<OptionQuestionCategory> GetOptionsByCategory(Category categorty);
	
	
}
