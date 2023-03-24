package com.pablop.survey.web.app.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pablop.survey.web.app.services.CountryListService;

@Component
public class CountryPropertyEditor extends PropertyEditorSupport{

	@Autowired
	private CountryListService countryListService;
	
	
	
	
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {

		if(text!=null && text.length()>0) {
			
			
		this.setValue(countryListService.searchCountryByName(text));
		}else {
			setValue(null);
		}
	}
	
	

}
