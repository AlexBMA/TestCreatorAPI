package com.alex.testApi.test_api_jersey.database;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.alex.testApi.test_api_jersey.model.Answer;



public class AnswerDAO implements DAOOperations<Answer>{

	@Override
	public void insert(SessionFactory theSessionFactory, Answer ob) {
		
		// get the session
		Session theSession = theSessionFactory.getCurrentSession();
		
		//begins the transaction
		theSession.getTransaction().begin();
		
		// save the object in the database
		theSession.saveOrUpdate(ob);
			
		// commits the transaction
		theSession.getTransaction().commit();
		
		
		
	}

	@Override
	public Answer getARow(SessionFactory theSessionFactory, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Answer> getAllRow(SessionFactory theSessionFactory) {
		 // get the session
		Session theSession = theSessionFactory.getCurrentSession();
		
		//begins the transaction
		theSession.getTransaction().begin();
		
		String hql="from Answer";
		
		List<Answer> answerList= theSession.createQuery(hql).getResultList();
			
		// commits the transaction
		theSession.getTransaction().commit();
		
		
		
		return answerList;
	}

	@Override
	public void deleteRow(SessionFactory theSessionFactory, int id) {
	Session theSession = theSessionFactory.getCurrentSession();
		
		//begins the transaction
		theSession.getTransaction().begin();
		
		Answer answer = theSession.get(Answer.class, id);
		theSession.delete(answer);
			
		// commits the transaction
		theSession.getTransaction().commit();
		
		
		
	}

	@Override
	public List<Answer> getAllSimilarRows(SessionFactory theSessionFactory, int idType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> getAllId(SessionFactory theSessionFactory) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
