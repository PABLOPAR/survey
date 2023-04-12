package com.pablop.survey.web.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pablop.survey.web.app.models.entity.Category;
import com.pablop.survey.web.app.models.entity.OptionQuestionCategory;



@Service
public class CategoryServiceImplCrud implements ICategoryService {

	
	@Autowired
	private ICategoryCrud iCategoryCrud;
	
	@Autowired
	private IQuestionOptionService iQuestionOptionService;

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


	@Override
	public ArrayList<OptionQuestionCategory> GetOptionsByCategory(Category category) {

		List<OptionQuestionCategory> allOptionQuestion = iQuestionOptionService.getOptionQuestionList();

		ArrayList<OptionQuestionCategory> categoryOptionSelected = new ArrayList<OptionQuestionCategory>();

		if (category != null && findCategoryById(category.getId()) != null) {

			for (OptionQuestionCategory option : allOptionQuestion) {
				System.out.println("Llega???");

				if (option.getCategoryOptionId() == category.getId()) {
					categoryOptionSelected.add(option);

				}
			}
		
			if(categoryOptionSelected.isEmpty()) { 
				categoryOptionSelected= null;
			}
		}
		return categoryOptionSelected;
	}

	



	


	
	
	

}
