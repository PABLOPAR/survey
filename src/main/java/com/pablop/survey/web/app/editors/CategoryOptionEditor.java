package com.pablop.survey.web.app.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pablop.survey.web.app.models.entity.CategoryOption;
import com.pablop.survey.web.app.services.ICategoryOptionCrud;

@Component
public class CategoryOptionEditor  extends PropertyEditorSupport{

	@Autowired
	private ICategoryOptionCrud iCategoryOptionCrud;
	
	
	
	public CategoryOption findById (Long id) {
		
		return iCategoryOptionCrud.findById(id).orElse(null);
	
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
