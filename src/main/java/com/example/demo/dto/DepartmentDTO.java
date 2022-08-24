package com.example.demo.dto;


public class DepartmentDTO {
	
	private Long id;
	
	private String name;
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DepartmentDTO() {
		super();
	}

	public DepartmentDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

}
