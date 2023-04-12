package com.pablop.survey.web.app.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pablop.survey.web.app.models.entity.Category;
import com.pablop.survey.web.app.services.ICategoryService;

@Component
public class CategoryOptionEditor  extends PropertyEditorSupport{

	@Autowired
	private ICategoryService iCategoryService;
	
	
	
	public Category findById (Long id) {
		
		return iCategoryService.findCategoryById(id);
	
	}



	@Override
	public void setAsText(String IdForm) throws IllegalArgumentException {
		
		
		if (!IdForm.isEmpty()) {

			Long idLong = Long.parseLong(IdForm);

			this.setValue(findById(idLong));

		} else {
			setValue(null);
		}

	}

	
}
