package com.pablop.survey.web.app.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pablop.survey.web.app.models.entity.Country;



@Repository ("CountryListServiceDAO")
@Primary
public class CountryListServiceDAO implements CountryListService{

	@PersistenceContext
	private EntityManager em;
	
	@Transactional(readOnly=true)
	@Override
	public Country searchCountryByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<Country> getCountryListObject() {
		
		System.out.println("Mirar aca " +em.createQuery("from Country").getResultList().toString());

		return em.createQuery("from Country").getResultList();
	}
	

}
