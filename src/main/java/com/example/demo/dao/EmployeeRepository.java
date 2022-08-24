package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.dto.EmployeeIDTO;
import com.example.demo.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	@Query("SELECT new com.example.demo.dto.EmployeeDTO(e.firstName, e.middleName,e.department.id,e.department.name) FROM Employee e")
	public List<EmployeeDTO> getEmployeeNames();
	
	@Query(value = "SELECT e.firstName, e.middleName FROM employee e",nativeQuery = true)
	public List<EmployeeIDTO> getNativeEmployeeNames();
	
	
	//List<User> findByNameIs(String name);
	//List<User> findByNameEquals(String name);
	//List<User> findByNameIsNot(String name);
	public List<Employee> findByFirstName(String firstName);
	
	
	// Name is null
	public List<Employee> findByLastNameIsNull();
	
	// Name is not null
	public List<Employee> findByLastNameIsNotNull();
	
	
	//List<Employee> findByNameStartingWith(String prefix);
	//List<Employee> findByNameEndingWith(String suffix);
	//List<Employee> findByNameLike(String likePattern);
	//public List<Employee> findByNameContaining(String prefix);
	
	List<Employee> findByMiddleNameOrderByFirstName(String name);
	
	
	//List<Employee> findByAgeLessThan(Integer age);
	//List<Employee> findByAgeLessThanEqual(Integer age);
	//List<Employee> findByAgeGreaterThan(Integer age);
	//List<Employee> findByAgeGreaterThanEqual(Integer age);
	//List<Employee> findByAgeBetween(Integer startAge, Integer endAge);
	//List<Employee> findByAgeIn(Collection<Integer> ages);
	
	//List<User> findByNameOrBirthDate(String name, ZonedDateTime birthDate);
	//List<User> findByNameOrBirthDateAndActive(String name, ZonedDateTime birthDate, Boolean active);

}
