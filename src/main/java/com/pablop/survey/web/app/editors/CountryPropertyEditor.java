package com.pablop.survey.web.app.editors;

import java.beans.PropertyEditorSupport;
import java.util.List;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.pablop.survey.web.app.models.entity.Country;
import com.pablop.survey.web.app.services.CountryListService;

@Component
@Primary
public class CountryPropertyEditor extends PropertyEditorSupport implements ICountryEditor{

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


	@Override
	public Country getCountrybyId(Long id) {

		List<Country> allCountries = countryListServiceImpl.getCountryListObject();

		int index = 0;
		Country countrySearched = null;

		while (index < allCountries.size() && countrySearched == null) {
			if (allCountries.get(index).getId().equals(id)) {
				countrySearched = allCountries.get(index);
			} else {
				index++;
			}
		}
		return countrySearched;
	}
	
	

}
