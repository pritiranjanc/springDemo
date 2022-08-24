package com.example.demo.dto;


public class EmployeeDTO {
	
	private String firstName;
	
	private String lastName;
	
	private DepartmentDTO department = new DepartmentDTO();
	
	public EmployeeDTO(String firstName, String lastName,Long id,String name) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.department.setId(id);
		this.department.setName(name);
	}
	
	public EmployeeDTO(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public DepartmentDTO getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentDTO department) {
		this.department = department;
	}
	
	

}
