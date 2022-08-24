package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.SEmployee;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(tags = "Employee Controller")
@RestController
@RequestMapping("/api/v1")
public class EmployeeService {
	
	private static List<SEmployee> employees;
	{
		employees = new ArrayList<SEmployee>();
		employees.add(new SEmployee(101, "John", "Sr. Engineer", 20000));
		employees.add(new SEmployee(201, "Russ", "Team Lead", 300000));
		employees.add(new SEmployee(301, "Kate", "Manager", 700000));
		employees.add(new SEmployee(401, "Viral", "Software Engineer", 10000));
	}
	
	@GetMapping("/employees")
	@ApiOperation("Fetching Employee Details")
	public List<SEmployee> getEmployees() {
		return employees;
	}
	
	@PostMapping(value = "/addemployee")
	@ApiOperation(value="Adding Employee Details")
	public ResponseEntity createEmployee(@RequestBody SEmployee employee) {
		employees.add(employee);
		return new ResponseEntity(employee, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteemployee/{empId}")
	@ApiOperation("Delete Employee Details")
	public ResponseEntity deleteEmployee(@PathVariable Integer empId) {
		employees.removeIf(e -> e.getEmpId()== empId);
		return new ResponseEntity("{\"message\":\"Success\"}", HttpStatus.OK) ;
	}
}
