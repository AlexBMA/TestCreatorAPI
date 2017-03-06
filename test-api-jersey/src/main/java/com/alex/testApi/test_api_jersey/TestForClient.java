package com.alex.testApi.test_api_jersey;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.alex.testApi.test_api_jersey.database.DAOOperations;
import com.alex.testApi.test_api_jersey.database.DB;
import com.alex.testApi.test_api_jersey.database.TestDAO;
import com.alex.testApi.test_api_jersey.local.TestLocal;
import com.alex.testApi.test_api_jersey.model.Test;
import com.alex.testApi.test_api_jersey.services.BasicService;
import com.alex.testApi.test_api_jersey.services.TestLocalService;

@Path("/testC")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TestForClient {
	
	
	@GET
	public List<TestLocal> getAllTest(@Context UriInfo uriInfo)
	{
		if(DB.getSessionFactory()==null) DB.DBConnect();
		
		
		BasicService<TestLocal> testLocalService = new TestLocalService();
		
		System.out.println("here");
		return testLocalService.getAllItems(DB.getSessionFactory());
		
	}
	@GET
	@Path("/{testId}")
	public TestLocal getTest(@Context UriInfo uriInfo, @PathParam("testId") int id)
	{
		if(DB.getSessionFactory()==null) DB.DBConnect();
		
		BasicService<TestLocal> testLocalService = new TestLocalService();
		//System.out.println(id);
		
		
		
		return testLocalService.getItem(DB.getSessionFactory(), id);
	}

}