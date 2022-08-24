package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import com.example.demo.dto.EmployeeDTO;

import lombok.Getter;
import lombok.Setter;


@SqlResultSetMapping(name="employeeName", classes = {
	    @ConstructorResult(targetClass = EmployeeDTO.class, 
	    columns = {
	    			@ColumnResult(name="firstName"), 
	    		    @ColumnResult(name="middleName"),
	    			@ColumnResult(name="id",type = Long.class), 
	    		    @ColumnResult(name="name")
	    		}
	    )
})

@Entity
@Table(name = "employee")
@Setter
@Getter
public class Employee {
	
	@Id
	private Long id;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="middleName")
	private String middleName;
	
	@Column(name="lastName")
	private String lastName;
	
	@JoinColumn(name = "deptId")
	@ManyToOne
	private Department department;
}
