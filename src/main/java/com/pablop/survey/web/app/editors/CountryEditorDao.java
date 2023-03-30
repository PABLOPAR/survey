package com.pablop.survey.web.app.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;

import com.pablop.survey.web.app.services.CountryListService;




public class CountryEditorDao  extends PropertyEditorSupport implements ICountryEditor{
	
	
	@Autowired
	private CountryListService countryListServiceImpl;
	
	
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {

		if(text!=null && text.length()>0) {
			
			
		this.setValue(countryListServiceImpl.searchCountryByName(text));
		}else {
			setValue(null);
		}
	}

}
