package com.pablop.survey.web.app.editors;

import java.beans.PropertyEditorSupport;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.pablop.survey.web.app.models.entity.Country;
import com.pablop.survey.web.app.models.entity.PeopleAnalyzed;
import com.pablop.survey.web.app.models.entity.Person;
import com.pablop.survey.web.app.services.CountryListService;




public class CountryEditorDao  extends PropertyEditorSupport implements ICountryEditor{
	
	
	@Autowired
	private CountryListService countryListService;
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {

		if(text!=null && text.length()>0) {
			
			
		this.setValue(countryListService.searchCountryByName(text));
		}else {
			setValue(null);
		}
	}
	
	
	public String getCountryName(Country country) {

		return country.getName();

	}
	
	public Country getCountrybyId(Long id) {

		return (Country) em.find(Country.class, id);

	}

}
