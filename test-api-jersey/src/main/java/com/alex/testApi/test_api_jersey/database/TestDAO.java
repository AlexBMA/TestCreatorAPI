package com.alex.testApi.test_api_jersey.database;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.alex.testApi.test_api_jersey.model.Question;
import com.alex.testApi.test_api_jersey.model.Test;



public class TestDAO implements DAOOperations<Test>{

	@Override
	public void insert(SessionFactory theSessionFactory, Test ob) {
		
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
	public Test getARow(SessionFactory theSessionFactory, int id) {
			   // get the session
				Session theSession = theSessionFactory.getCurrentSession();
				
				//begins the transaction
				theSession.getTransaction().begin();
				
				Test test = theSession.get(Test.class, id);
					
				// commits the transaction
				theSession.getTransaction().commit();
				
				
				
				return test;
	}

	@Override
	public List<Test> getAllRow(SessionFactory theSessionFactory) {
		
		// get the session
		Session theSession = theSessionFactory.getCurrentSession();
		
		//begins the transaction
		theSession.getTransaction().begin();
		
	
		String hql="from Test";
		
		List<Test> testList= theSession.createQuery(hql).getResultList();
			
		// commits the transaction
		theSession.getTransaction().commit();
		
		
		
		return testList;
	}

	@Override
	public void deleteRow(SessionFactory theSessionFactory, int id) {
		
		   // get the session
		Session theSession = theSessionFactory.getCurrentSession();
		
		//begins the transaction
		theSession.getTransaction().begin();
		
		Test test = theSession.get(Test.class, id);
		theSession.delete(test);
			
		// commits the transaction
		theSession.getTransaction().commit();
		
		
	}

	@Override
	public List<Test> getAllSimilarRows(SessionFactory theSessionFactory, int idType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> getAllId(SessionFactory theSessionFactory) {
		
		
		 // get the session
		Session theSession = theSessionFactory.getCurrentSession();
		
				
		//begins the transaction
		theSession.getTransaction().begin();
		
		EntityManagerFactory emf = theSession.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		String nativeSql ="select test.id from test";
	
		String hql=" id from Test";
		
		
		List<Integer> testIdList= em.createNativeQuery(nativeSql).getResultList();
		
		theSession.getTransaction().commit();
		
		return  testIdList;
	}
	
	
	
}
