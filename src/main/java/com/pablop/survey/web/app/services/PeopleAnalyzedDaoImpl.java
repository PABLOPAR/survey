package com.pablop.survey.web.app.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pablop.survey.web.app.models.entity.PeopleAnalyzed;

@Repository ("PeopleAnalyzedDaoJPA")
public class PeopleAnalyzedDaoImpl implements PeopleService {

	@PersistenceContext 
	private EntityManager em;
	
	

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<PeopleAnalyzed> getPeopleAnalyzedList() {
		
		System.out.println("mirar aca" + em.createQuery("from User").getResultList().toString());
		
		return em.createQuery("from User").getResultList(); 
	}

	@Override
	public List<PeopleAnalyzed> peopleListAnalized() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PeopleAnalyzed analyzedByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PeopleAnalyzed> addPeopleAnalyzed(PeopleAnalyzed newPeople) {
		// TODO Auto-generated method stub
		return null;
	}


}
