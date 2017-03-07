package com.alex.testApi.test_api_jersey.simplemodel;

import java.util.List;

public class QuestionSimple {
	
	private int questionId;
	private String questionText;
	
	List<String> answerUser;
	
	
	public QuestionSimple()
	{
		
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public List<String> getAnswerUser() {
		return answerUser;
	}

	public void setAnswerUser(List<String> answerUser) {
		this.answerUser = answerUser;
	}
	
	
	
}
