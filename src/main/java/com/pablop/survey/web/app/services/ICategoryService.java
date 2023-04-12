package com.pablop.survey.web.app.services;

import java.util.List;

import com.pablop.survey.web.app.models.entity.Category;


public interface ICategoryService {

	
	public List<Category> getListCategory();
	public void saveCategory(Category category);
	public Category findCategoryById(Long id);
	
	
}
