package com.alex.testApi.test_api_jersey.services;

import java.util.List;

import org.hibernate.SessionFactory;

import com.alex.testApi.test_api_jersey.database.AnswerDAO;
import com.alex.testApi.test_api_jersey.database.DAOOperations;
import com.alex.testApi.test_api_jersey.model.Answer;

public class AnswerService implements BasicService<Answer> {

	@Override
	public Answer getItem(SessionFactory factory, int id) {

		DAOOperations<Answer>answerOpearions = new AnswerDAO();
		
		return answerOpearions.getARow(factory, id);
		
		
	}

	@Override
	public List<Answer> getAllItems(SessionFactory factory) {
		
		return null;
	}


	@Override
	public void deleteItem(SessionFactory factory, int id) {
		
		DAOOperations<Answer>answerOpearions = new AnswerDAO();
		answerOpearions.deleteRow(factory, id);
	}


	@Override
	public void editItem(SessionFactory factory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createItem(SessionFactory factory, Answer item) {
		
			DAOOperations<Answer>answerOpearions = new AnswerDAO();
			answerOpearions.insert(factory, item);
		
	}

	@Override
	public List<Answer> getSimilarItems(SessionFactory factory, int idSimilar) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> getIds(SessionFactory factory) {
		// TODO Auto-generated method stub
		return null;
	}

}
