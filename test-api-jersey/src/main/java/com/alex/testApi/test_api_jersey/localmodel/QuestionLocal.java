package com.alex.testApi.test_api_jersey.localmodel;

import java.util.ArrayList;
import java.util.List;

import com.alex.testApi.test_api_jersey.model.Answer;
import com.alex.testApi.test_api_jersey.model.Question;

public class QuestionLocal {

	private String questionText;
	private int localId;
	private List<String> answers;
	private int questionType;
	
	
	
	public QuestionLocal()
	{
		this.questionText="";
		this.localId=0;
		this.answers = new ArrayList<>();
		this.questionType = -1;
	}
	
	public QuestionLocal(String questionText, int localId) {
		super();
		this.questionText = questionText;
		this.localId = localId;
		this.answers = new ArrayList<>();
		this.questionType = -1;
	}
	
	
	public void convertQestionToQuestionLocal(Question q)
	{
		this.questionText = q.getQuestionText();
		List<String> answerText = new ArrayList<>();
		List<Answer> listAnswer = q.getListAnswers();
		for(Answer a:listAnswer)
		{
			answerText.add(a.getAnswerText());
		}
		
		if(listAnswer.size()==1) this.questionType=1;
			else this.questionType =2 ;
		
		this.answers = answerText;
	}
	
	
	public QuestionLocal(String questionText, int localId, List<String> answers) {
		super();
		this.questionText = questionText;
		this.localId = localId;
		this.answers = answers;
		this.questionType = -1;
	}

	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public int getLocalId() {
		return localId;
	}
	public void setLocalId(int localId) {
		this.localId = localId;
	}

	public List<String> getAnswers() {
		return answers;
	}

	public void setAnswers(List<String> answers) {
		this.answers = answers;
	}

	public int getQuestionType() {
		return questionType;
	}

	public void setQuestionType(int questionType) {
		this.questionType = questionType;
	}
	
	
	
}
