package com.alex.testApi.test_api_jersey.database;

import java.util.List;

import org.hibernate.SessionFactory;

public interface DAOOperations<T> {
	
	public void insert(SessionFactory theSessionFactory,T ob);
	public T getARow(SessionFactory theSessionFactory,int id);
	public List<T> getAllRow(SessionFactory theSessionFactory);
	public void deleteRow(SessionFactory theSessionFactory,int id);
	public List<T> getAllSimilarRows(SessionFactory theSessionFactory,int idType );
	public List<Integer> getAllId(SessionFactory theSessionFactory);
	
}


	
	