package com.alex.testApi.test_api_jersey.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TestReport {

	List<Item> testItems;
	int score;

	public TestReport() {
		super();
		testItems = new ArrayList<>();
		score=0;
	}

	public List<Item> getTestItems() {
		return testItems;
	}

	public void setTestItems(List<Item> testItems) {
		this.testItems = testItems;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
