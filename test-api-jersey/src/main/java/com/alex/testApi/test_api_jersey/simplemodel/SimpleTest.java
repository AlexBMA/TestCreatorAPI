package com.alex.testApi.test_api_jersey.simplemodel;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SimpleTest {

	private int testId;
	private List<QuestionSimple> listQuestions;
	
	public SimpleTest()
	{
		
	}
	
	public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}
	public List<QuestionSimple> getListQuestions() {
		return listQuestions;
	}
	public void setListQuestions(List<QuestionSimple> listQuestions) {
		this.listQuestions = listQuestions;
	}
	
	
	
}
