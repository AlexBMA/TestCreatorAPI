package com.alex.testApi.test_api_jersey.services;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alex.testApi.test_api_jersey.database.DB;
import com.alex.testApi.test_api_jersey.model.Answer;
import com.alex.testApi.test_api_jersey.model.Item;
import com.alex.testApi.test_api_jersey.model.Question;
import com.alex.testApi.test_api_jersey.model.Test;
import com.alex.testApi.test_api_jersey.model.TestReport;
import com.alex.testApi.test_api_jersey.simplemodel.QuestionSimple;
import com.alex.testApi.test_api_jersey.simplemodel.SimpleTest;

public class CheckUserTestImplementation implements CheckUserTest {

	@Override
	public TestReport checkUserTest(SimpleTest userTestl) {

		

		TestLocalService testLocalService = new TestLocalService();
		Map<Integer, Integer> localToRealId = testLocalService.getIdMap();
		int realId = localToRealId.get(userTestl.getTestId());

		BasicService<Test> testService = new TestService();

		Test testTemp = testService.getItem(DB.getSessionFactory(), realId);

		TestReport testReport = new TestReport();
		
		checkQuestionList(testReport, testTemp.getListQuestions(), userTestl.getListQuestions());
		
		
		return testReport;
	}

	private void checkQuestionList(TestReport testReport, List<Question> questionListTest,
			List<QuestionSimple> questionListUser) {
		int sizeQuestionList = questionListTest.size();
		int sizeQuestionListUser = questionListUser.size();

		int score = testReport.getScore();

		for (int i = 0; i < sizeQuestionList; i++) {
			
			Item item = new Item();

			if (checkAnswerList(questionListTest.get(i), questionListUser.get(i), item) == true)
				score++;
			
			testReport.getTestItems().add(item);
			testReport.setScore(score);
		}

	}

	private boolean checkAnswerList(Question tempQuestion, QuestionSimple tempQuestionUser, Item item) {
		List<Answer> answerList = tempQuestion.getListAnswers();
		int numberOfCorrectAnswer = tempQuestion.getNumberOfCorrectAnswers();
		int numberOfAnswers = tempQuestion.getNumberOfAnswers();

		List<String> answerListUser = tempQuestionUser.getAnswerUser();
		int numberOfAnswersUser = answerListUser.size();
		int numberOfCorrectAnswersUser = 0;

		List<String> correctAnswers = new ArrayList<>();

		Answer tempAnswer;
		for (int i = 0; i < numberOfAnswers; i++) {
			tempAnswer = answerList.get(i);

			if (tempAnswer.getTrueFalse() == 1) {
				String answerText = tempAnswer.getAnswerText();
				correctAnswers.add(answerText);

				for (int j = 0; j < numberOfAnswersUser; j++) {
					String answerTextUser = answerListUser.get(j);

					if (answerTextUser.equalsIgnoreCase(answerText) == true)
						numberOfCorrectAnswersUser++;
				}

			}
		}

		item.setQuestionText(tempQuestion.getQuestionText());
		item.setMyAnswers(answerListUser);
		item.setCorrectAnswers(correctAnswers);

		
		
		if (numberOfCorrectAnswer == numberOfCorrectAnswersUser)
			return true;

		return false;

	}

}
