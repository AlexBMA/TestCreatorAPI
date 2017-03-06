package com.alex.testApi.test_api_jersey.services;

import java.util.List;
import org.hibernate.SessionFactory;
import com.alex.testApi.test_api_jersey.model.Test;
import com.alex.testApi.test_api_jersey.database.*;
import com.alex.testApi.test_api_jersey.model.*;

public class TestService implements BasicService<Test> {

	@Override
	public Test getItem(SessionFactory factory, int id) {
		
		DAOOperations<Test> testOpearions = new TestDAO();
		BasicService<Question> questionService = new QuestionService();
		
	
		Test test = testOpearions.getARow(factory, id);
		List<Question> questionList = questionService.getSimilarItems(factory, test.getId());
		
		test.setListQuestions(questionList);
		
		
		return test;
	}
	@Override
	public List<Test> getAllItems(SessionFactory factory) {
		DAOOperations<Test> testOpearions = new TestDAO();
		
		List<Test> testList = testOpearions.getAllRow(factory);
		
		return testList;
	}

	@Override
	public void deleteItem(SessionFactory factory, int id) {
		DAOOperations<Test> testOpearions = new TestDAO();
		
		BasicService<Question> questionService = new QuestionService();
		
		Test test = testOpearions.getARow(factory, id);
		List<Question> questionList = questionService.getSimilarItems(factory, test.getId());
		
		for(Question q:questionList)
		{
			questionService.deleteItem(factory, q.getId());
		}
		
		
		testOpearions.deleteRow(factory, id);
	}


	@Override
	public void editItem(SessionFactory factory) {
	
		
	}

	@Override
	public void createItem(SessionFactory factory, Test item) {
		
		DAOOperations<Test> testOpearions = new TestDAO();

		List<Question> listQuestion = item.getListQuestions();
		BasicService<Question> questionService = new QuestionService();
		
		for(Question q:listQuestion){
			questionService.createItem(factory, q);
		}
		
		testOpearions.insert(factory, item);
		
	}

	@Override
	public List<Test> getSimilarItems(SessionFactory factory, int idSimilar) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Integer> getIds(SessionFactory factory) {
		
		DAOOperations<Test> testOpearions = new TestDAO();
		List<Integer> testIds = testOpearions.getAllId(factory);
		
		return testIds;
	}

	

}
