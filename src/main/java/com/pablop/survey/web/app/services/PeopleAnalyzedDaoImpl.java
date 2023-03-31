package com.pablop.survey.web.app.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pablop.survey.web.app.models.entity.PeopleAnalyzed;

@Repository ("PeopleAnalyzedDaoJPA")
@Primary
public class PeopleAnalyzedDaoImpl implements IPeopleService {

	@PersistenceContext 
	private EntityManager em;
	
	

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<PeopleAnalyzed> getPeopleAnalyzedList() {
		
//		System.out.println("mirar ACA" + em.createNamedQuery("SelectAllPeopleAnalyzed", PeopleAnalyzed.class).getResultList().toString());
		
		return em.createQuery("from PeopleAnalyzed").getResultList(); 
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<PeopleAnalyzed> peopleListAnalized() {
		// TODO Auto-generated method stub
		return em.createQuery("from PeopleAnalyzed").getResultList();
	}

	@Override
	public PeopleAnalyzed analyzedByEmail(String email) {
		@SuppressWarnings("unchecked")
		List<PeopleAnalyzed> peopleList = em.createQuery("from PeopleAnalyzed").getResultList();

		PeopleAnalyzed peopleSearched = null;
		if (peopleList.size() > 0) {

			int index = 0;

			while (index < peopleList.size() && peopleSearched == null) {
				if (peopleList.get(index).getEmail().equalsIgnoreCase(email)) {
					peopleSearched = peopleList.get(index);

				} else {
					index++;
				}
			}
		}
		return peopleSearched;
	}

	@Override
	@Transactional
	public void addPeopleAnalyzed(PeopleAnalyzed newPeople) {
		em.persist(newPeople);
	}


}
