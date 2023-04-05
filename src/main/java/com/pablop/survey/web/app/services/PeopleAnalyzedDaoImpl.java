package com.pablop.survey.web.app.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pablop.survey.web.app.models.entity.PeopleAnalyzed;
import com.pablop.survey.web.app.models.entity.Person;

@Repository ("PeopleAnalyzedDaoJPA")

public class PeopleAnalyzedDaoImpl implements IPeopleService {

	
	
	@PersistenceContext
	private EntityManager em;

	
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<PeopleAnalyzed> getPeopleAnalyzedList() {

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
	@Transactional(readOnly = true)
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

		if (newPeople.getId() != null && newPeople.getId() > 0) {
			em.merge(newPeople);

		} else {
			em.persist(newPeople);
		}
	}

	
	
	
	@Transactional(readOnly = true)
	public PeopleAnalyzed findPeopleById(Long id) {

		return (PeopleAnalyzed) em.find(Person.class, id);
	}

	
	
	@Transactional
	@Override
	public void deletePeopleAnalyzedById(Long id) {

		PeopleAnalyzed personToBeDelete = findPeopleById(id);

		em.remove(personToBeDelete);

	}

}
