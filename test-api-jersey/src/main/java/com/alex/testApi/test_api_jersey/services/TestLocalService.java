package com.alex.testApi.test_api_jersey.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.sql.Template;

import com.alex.testApi.test_api_jersey.database.DAOOperations;
import com.alex.testApi.test_api_jersey.database.DB;
import com.alex.testApi.test_api_jersey.database.TestDAO;
import com.alex.testApi.test_api_jersey.local.QuestionLocal;
import com.alex.testApi.test_api_jersey.local.TestLocal;
import com.alex.testApi.test_api_jersey.model.Answer;
import com.alex.testApi.test_api_jersey.model.Question;
import com.alex.testApi.test_api_jersey.model.Test;

public class TestLocalService implements BasicService<TestLocal> {

	
	private static Map<Integer,Integer> localToRealId;
	
	@Override
	public List<TestLocal> getAllItems(SessionFactory session) {
		
		BasicService<Test> testService = new TestService();
		
		List<Test> allTest = testService.getAllItems(DB.getSessionFactory());

		localToRealId = new HashMap<>();
		
		List<TestLocal> allTestLocal = allTestLocal(allTest);
		
		
		return allTestLocal;
	}

	public List<TestLocal> allTestLocal(List<Test> allTest) {
		Test testTemp;
		TestLocal testLocalTemp;
		List<TestLocal> allTestLocal = new ArrayList<>();
		int sizeAllTest = allTest.size();
			
		for(int i=0;i<sizeAllTest;i++)
		{
			testTemp  = allTest.get(i);
			localToRealId.put(i+1, testTemp.getId());
			testLocalTemp = new TestLocal(testTemp.getNumberOfQuestions());
			testLocalTemp.setLocalId(i+1);
			allTestLocal.add(testLocalTemp);
			
		}
		return allTestLocal;
	}

	@Override
	public TestLocal getItem(SessionFactory factory, int id) {
		
		if(localToRealId == null)  getAllTestId(factory);
		
		int realId = localToRealId.get(id);
		
		BasicService<Test> testService = new TestService();
		Test tempTest = testService.getItem(DB.getSessionFactory(), realId);
		
		TestLocal tempLocal= new TestLocal();
		tempLocal.setLocalId(id);
		tempLocal.setNumberOfQuestions(tempTest.getNumberOfQuestions());
		
		
		List<Question> testQuestions = tempTest.getListQuestions();
		List<QuestionLocal> testQuestionForClient  = new ArrayList<>();
		Question tempQuestion;
		int size = testQuestions.size();
		
		for(int i=0;i<size;i++)
		{
			QuestionLocal tempQuestionLocal = new QuestionLocal();
			tempQuestion = testQuestions.get(i);	
			tempQuestionLocal.setLocalId(i+1);
			tempQuestionLocal.convertQestionToQuestionLocal(tempQuestion);
			testQuestionForClient.add(tempQuestionLocal);
			
			
		}
		
		tempLocal.setQuestionList(testQuestionForClient);
		
		return tempLocal;
	}
	
	
	public void getAllTestId(SessionFactory factory)
	{
		localToRealId = new HashMap<>();
		BasicService<Test> testService = new TestService();
		List<Integer> testIds = testService.getIds(factory);
		
		int size = testIds.size();
		for(int i=0;i<size;i++)
		{
			localToRealId.put(i+1, testIds.get(i));
		}
			
	}
	
	

	@Override
	public List<TestLocal> getSimilarItems(SessionFactory factory, int idSimilar) {
		
		return null;
	}

	@Override
	public void editItem(SessionFactory factory) {
		
		
	}

	@Override
	public void deleteItem(SessionFactory factory, int id) {
		
		
	}

	@Override
	public void createItem(SessionFactory factory, TestLocal item) {
		
		
	}

	@Override
	public List<Integer> getIds(SessionFactory factory) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
