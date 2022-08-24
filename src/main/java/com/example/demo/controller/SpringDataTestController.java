package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.dao.EmployeeRepository;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.dto.EmployeeIDTO;
import com.example.demo.model.Employee;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1")
@Api(tags = "Spring Data JPA Utility Methods")
public class SpringDataTestController {
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	
	@GetMapping("/employee/names")
	@ApiOperation("Fetching only employee names from model using JPQL")
	public List<EmployeeDTO> getEmployeeNames(){
		return employeeRepo.getEmployeeNames();
	}
	
	@GetMapping("/employee/nativeNames")
	@ApiOperation("Fetching only employee names from model using native Query")
	public List<EmployeeIDTO> getNativeEmployeeNames(){
		return employeeRepo.getNativeEmployeeNames();
	}
	
	@GetMapping("/employee/entityNativeNames")
	@ApiOperation("Fetching only employee names  using Entity Manager native Query")
	public List<EmployeeDTO> getEntityNativeEmployeeNames(){
		return employeeDAO.getNativeEmployeeNames();
	}
	
	@GetMapping("/employee/pagination")
	@ApiOperation("Fetching employees with inbuild Pagination")
	public List<Employee> getAllEmployees(@RequestParam(defaultValue = "0") Integer pageNo, 
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Employee> pagedResult = employeeRepo.findAll(paging);
         
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Employee>();
        }
    }
	
	@GetMapping("/employee/name/{name}")
	@ApiOperation("Fetching only employee names  with inbuild Pagination")
	public List<Employee> getEmployeeNames(@PathVariable String name){
		return employeeRepo.findByFirstName(name);
	}
	
	@GetMapping("/employee/nullLastname")
	@ApiOperation("Fetching employees last name is null")
	public List<Employee> getEmployeeLastNameNull(){
		return employeeRepo.findByLastNameIsNull();
	}
	
	@GetMapping("/employee/notnullLastname")
	@ApiOperation("Fetching employees last name is not null")
	public List<Employee> getEmployeeLastNameNotNull(){
		return employeeRepo.findByLastNameIsNotNull();
	}
	
	@GetMapping("/employee/findByNameOrder/{name}")
	@ApiOperation("Fetching employees by middle name with order")
	public List<Employee> getEmployeeByFirstName(@PathVariable String name){
		return employeeRepo.findByMiddleNameOrderByFirstName(name);
	}
	
	
	

}
