package com.alex.testApi.test_api_jersey.local;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.alex.testApi.test_api_jersey.model.Question;

@XmlRootElement
public class TestLocal {
	
	private int localId;
	private int numberOfQuestions;
	private List<QuestionLocal> questionList;
	
	
	public TestLocal()
	{
		
	}
	public TestLocal(int numberOfQuestions)
	{
		super();
		this.numberOfQuestions = numberOfQuestions;
		this.questionList = new ArrayList<>();
	}
	
	public TestLocal(int numberOfQuestions, List<QuestionLocal> questionList) {
		super();
		this.numberOfQuestions = numberOfQuestions;
		this.questionList = questionList;
	}
	public int getLocalId() {
		return localId;
	}
	public void setLocalId(int localId) {
		this.localId = localId;
	}
	public int getNumberOfQuestions() {
		return numberOfQuestions;
	}
	public void setNumberOfQuestions(int numberOfQuestions) {
		this.numberOfQuestions = numberOfQuestions;
	}
	public List<QuestionLocal> getQuestionList() {
		return questionList;
	}
	public void setQuestionList(List<QuestionLocal> questionList) {
		this.questionList = questionList;
	}
	
	
	
}
