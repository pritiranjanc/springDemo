-- create database springjpa;
-- use springjpa;

create table department
(  
	id int primary key auto_increment,
	name varchar(100)
);

create table employee
(  
	id int primary key auto_increment,
	firstName varchar(50),
	middleName varchar(50),
	lastName varchar(50),
	deptId int not null
);

alter table employee
add constraint fk_employee_dept foreign key (deptId) references department(id);


