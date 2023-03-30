package com.pablop.survey.web.app.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.pablop.survey.web.app.models.entity.User;

@Repository ("UserServiceImplDao")
public class UserServiceImplDao implements IUserService{

	@PersistenceContext 
	private EntityManager em;
	
		
	
	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return em.createQuery("from User").getResultList();
	}

	
	
	
}
