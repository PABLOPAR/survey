package com.pablop.survey.web.app.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pablop.survey.web.app.models.entity.Country;
import com.pablop.survey.web.app.models.entity.PeopleAnalyzed;
import com.pablop.survey.web.app.models.entity.Person;



@Repository ("CountryListServiceDAO")
@Primary
public class CountryListServiceDAO implements CountryListService{

	@PersistenceContext
	private EntityManager em;
	
	@Transactional(readOnly = true)
	@Override
	public Country searchCountryByName(String name) {
		// TODO Auto-generated method stub

		@SuppressWarnings("unchecked")
		List<Country> countryList = ((Query) em).getResultList();

		Country searched = null;
		int index = 0;

		if (!name.isEmpty()) {
			while (index < countryList.size() && searched == null) {
				if (countryList.get(index).getName().equalsIgnoreCase(name)) {
					searched = countryList.get(index);
				} else {
					index++;
				}
			}
		}
		return searched;

	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<Country> getCountryListObject() {
		
		return em.createQuery("from Country").getResultList();
	}

	@Override
	public Country searchCountryById(Long id) {

		return (Country) em.find(Country.class, id);
	}
	

}
