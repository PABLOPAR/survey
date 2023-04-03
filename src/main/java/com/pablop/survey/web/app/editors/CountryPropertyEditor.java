package com.pablop.survey.web.app.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.pablop.survey.web.app.models.entity.Country;
import com.pablop.survey.web.app.services.CountryListServiceImpl;

@Component
@Primary
public class CountryPropertyEditor extends PropertyEditorSupport implements ICountryEditor{

	@Autowired
	private CountryListServiceImpl countryListServiceImpl;
	
	
	
	
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {

		if(text!=null && text.length()>0) {
			
			
		this.setValue(countryListServiceImpl.searchCountryByName(text));
		}else {
			setValue(null);
		}
	}


	@Override
	public Country getCountrybyId(Long id) {
		// Not yet Implemented
		return null;
	}
	
	

}
