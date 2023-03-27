package com.pablop.survey.web.app.models;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pablop.survey.web.app.models.entity.PeopleAnalyzed;

@Repository ("PeopleAnalyzedDaoJPA")
public class PeopleAnalyzedDaoImpl implements IPeopleAnalyzedDao {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	@Override
	public List<PeopleAnalyzed> findAll() {
		em.createQuery("from User").getResultList(); 

		
		return null;
	}

}
