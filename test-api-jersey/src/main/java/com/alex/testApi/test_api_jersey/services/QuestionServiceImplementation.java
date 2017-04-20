package com.alex.testApi.test_api_jersey.services;

import java.util.List;

import org.hibernate.SessionFactory;

import com.alex.testApi.test_api_jersey.database.DAOOperations;
import com.alex.testApi.test_api_jersey.database.QuestionDAO;
import com.alex.testApi.test_api_jersey.model.Answer;
import com.alex.testApi.test_api_jersey.model.Question;


public class QuestionServiceImplementation implements BasicService<Question> {

	@Override
	public Question getItem(SessionFactory factory, int id) {
		
		DAOOperations<Question> questionOpearions = new QuestionDAO();
		
		//BasicService<Answer> answerService = new AnswerService();
		
		Question q = questionOpearions.getARow(factory, id);
		//List<Answer> listAnswer = q.getListAnswersi();
		
		
		
		return q;
	}

	@Override
	public List<Question> getAllItems(SessionFactory factory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editItem(SessionFactory factory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteItem(SessionFactory factory, int id) {
		
		DAOOperations<Question> questionOpearions = new QuestionDAO();
		
		Question item = questionOpearions.getARow(factory, id);
		
		List<Answer> listAnswer = item.getListAnswers();
		BasicService<Answer>answerService = new AnswerServiceImplementation();
		
		for(Answer a:listAnswer)
		{
			answerService.deleteItem(factory, a.getId());
		}
		
		questionOpearions.deleteRow(factory, id);
	}

	@Override
	public void createItem(SessionFactory factory, Question item) {
		
		DAOOperations<Question> questionOpearions = new QuestionDAO();
		
		List<Answer> listAnswer = item.getListAnswers();
		BasicService<Answer>answerService = new AnswerServiceImplementation();
		
		for(Answer a: listAnswer)
		{
			answerService.createItem(factory, a);
		}
		
		questionOpearions.insert(factory, item);
		
	}

	@Override
	public List<Question> getSimilarItems(SessionFactory factory, int idSimilar) {
		
		DAOOperations<Question> questionOpearions = new QuestionDAO();
		List<Question> questionList = questionOpearions.getAllSimilarRows(factory, idSimilar);
		
		return questionList;
	}

	@Override
	public List<Integer> getIds(SessionFactory factory) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
