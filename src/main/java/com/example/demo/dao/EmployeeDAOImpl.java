package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.EmployeeDTO;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
	
	@Autowired
	@Qualifier("entityManagerFactory")
	private EntityManager entityManager;

	@Override
	public List<EmployeeDTO> getNativeEmployeeNames() {
		String query = "SELECT e.firstName firstName, e.middleName middleName,d.id id,d.name name FROM employee e,department d where e.deptId = d.id";
		Query queryObj = entityManager.createNativeQuery(query, "employeeName");
		return queryObj.getResultList();
	}

}
