package com.pablop.survey.web.app.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.pablop.survey.web.app.models.entity.Question;


@Repository ("QuestionServiceDao")
public class QuestionServiceDaoImpl implements QuestionService{
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<Question> findAll() {
		em.createQuery("from User").getResultList(); //Incomplete
		
		return null;
	}
	

	@Override
	public List<Question> questionList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addQuestion(Question question) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
