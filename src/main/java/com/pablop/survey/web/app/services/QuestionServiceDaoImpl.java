package com.pablop.survey.web.app.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.pablop.survey.web.app.models.entity.Question;

@Repository("QuestionServiceDao")
@Primary
public class QuestionServiceDaoImpl implements IQuestionService {

	@PersistenceContext
	private EntityManager em;


	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Question> questionList() {
		// TODO Auto-generated method stub
		return em.createQuery("from Question").getResultList();
	}

	@Override
	@Transactional
	public void addQuestion(Question question) {

		em.persist(question);
	}

}
	
	


