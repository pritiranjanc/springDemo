package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "department")
@Setter
@Getter
public class Department {
	
	@Id
	private Long id;
	
	@Column(name="name")
	private String name;
	
}
