package com.pablop.survey.web.app.editors;

import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.pablop.survey.web.app.models.entity.Country;
import com.pablop.survey.web.app.services.CountryListService;




public class CountryEditorDao  extends PropertyEditorSupport implements ICountryEditor, CountryListService{
	
	
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


	@Override
	public Country searchCountryByName(String name) {

		ArrayList <Country> countryListServiceS= (ArrayList<Country>) em.createQuery("from Country").getResultList();
		
		
		Country searched = null;
		int index = 0;

		if (!name.isEmpty()) {
			while (index < countryListServiceS.size() && searched == null) {
				if (countryListServiceS.get(index).getName().equalsIgnoreCase(name)) {
					searched = countryListServiceS.get(index);
				} else {
					index++;
				}
			}

		}
		return searched;
	}


	@Override
	public List<Country> getCountryListObject() {
		// TODO Auto-generated method stub
		return null;
	}



}
