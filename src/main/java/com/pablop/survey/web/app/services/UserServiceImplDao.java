package com.pablop.survey.web.app.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pablop.survey.web.app.models.entity.User;

@Repository ("UserServiceImplDao")

public class UserServiceImplDao implements IUserService{

	@PersistenceContext 
	private EntityManager em;
	
		
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return em.createQuery("from User").getResultList();
	}

	@Override
	@Transactional
	public void save(User user) {
		em.persist(user);
		
	}

	
	
	
}
