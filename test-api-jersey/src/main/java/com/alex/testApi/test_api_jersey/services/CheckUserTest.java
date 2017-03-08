package com.alex.testApi.test_api_jersey.services;

import com.alex.testApi.test_api_jersey.model.TestReport;
import com.alex.testApi.test_api_jersey.simplemodel.SimpleTest;

public interface CheckUserTest {

	TestReport checkUserTest(SimpleTest userTestl);
	
}
