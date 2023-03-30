package com.pablop.survey.web.app.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pablop.survey.web.app.services.CountryListServiceImpl;

@Component
public class CountryPropertyEditor extends PropertyEditorSupport{

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
	
	

}
