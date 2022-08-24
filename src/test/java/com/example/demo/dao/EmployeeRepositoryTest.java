package com.example.demo.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.dto.EmployeeIDTO;
import com.example.demo.model.Employee;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryTest {

	@Autowired
    private EmployeeRepository employeeRepository;
	
    @Test
    public void getEmployeeNames() {
        List<EmployeeDTO> empList = employeeRepository.getEmployeeNames();
        assertEquals(6,empList.size());
    }
    
    @Test
    public void getNativeEmployeeNames() {
        List<EmployeeIDTO> empList = employeeRepository.getNativeEmployeeNames();
        assertEquals(6,empList.size());
    }
    
    @Test
    public void findByFirstName() {
        List<Employee> empList = employeeRepository.findByFirstName("Ram");
        assertEquals(2,empList.size());
    }
    
    @Test
    public void findByLastNameNull() {
        List<Employee> empList = employeeRepository.findByLastNameIsNull();
        assertEquals(4,empList.size());
    }
    
    @Test
    public void findByLastNameIsNotNull() {
        List<Employee> empList = employeeRepository.findByLastNameIsNotNull();
        assertEquals(2,empList.size());
    }
    
    @Test
    public void findByMiddleNameOrderByFirstName() {
        List<Employee> empList = employeeRepository.findByMiddleNameOrderByFirstName("Sekhar");
        assertEquals(3,empList.size());
        assertEquals("Krishna",empList.get(0).getFirstName());
    }
    
    
}
