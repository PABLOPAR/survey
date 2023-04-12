package com.pablop.survey.web.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pablop.survey.web.app.models.entity.Category;



@Service
public class CategoryServiceImplCrud implements ICategoryService {

	
	@Autowired
	private ICategoryCrud iCategoryCrud;

	@Override
	@Transactional(readOnly = true)
	public List<Category> getListCategory() {
		// TODO Auto-generated method stub
		return (List<Category>) iCategoryCrud.findAll();
	}

	
	@Override
	@Transactional
	public void saveCategory(Category category) {
		if(category!=null) {

			iCategoryCrud.save(category);
		}
		
	}

	@Override
	@Transactional(readOnly = true)
	public Category findCategoryById(Long id) {
		Category categorySearched = null;

		if (id > 0 && id!=null) {
			categorySearched = iCategoryCrud.findById(id).orElse(null);
		}

		return categorySearched;
	}

	



	


	
	
	

}
