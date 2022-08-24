package com.example.demo.controller;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.DemoApplicationTests;
import com.example.demo.dto.SEmployee;

public class EmployeeServiceTest extends DemoApplicationTests {

	@Test
	public void testAddEmployee() throws Exception 
	{
		String url = "/api/v1/addemployee";
		SEmployee emp = new SEmployee(101, "John", "Sr. Engineer", 20000);
		String inputJson = mapToJson(emp);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(url)
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content(inputJson)).andReturn();

		Assert.assertEquals(200,mvcResult.getResponse().getStatus());
	}

	@Test
	public void testGetEmployees() throws Exception 
	{
		String uri = "/api/v1/employees";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
				.accept(MediaType.APPLICATION_JSON)).andReturn();
		Assert.assertEquals(200,mvcResult.getResponse().getStatus());
	}

	@Test
	public void testDeleteEmployee() throws Exception {

		String uri = "/api/v1/deleteemployee/101";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)
				.accept(MediaType.APPLICATION_JSON)).andReturn();
		Assert.assertEquals(200,mvcResult.getResponse().getStatus());
	}
}
