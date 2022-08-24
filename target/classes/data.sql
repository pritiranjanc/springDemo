insert into department(id,name)
values(1,'IT');

insert into department(id,name)
values(2,'Electrical');

insert into employee(id,firstName,middleName,lastName,deptId)
values(1,'Ram','Sekhar','',1);
insert into employee(id,firstName,middleName,lastName,deptId)
values(2,'Shyam','Sekhar','',1);
insert into employee(id,firstName,middleName,lastName,deptId)
values(3,'Krishna','Sekhar','',1);

insert into employee(id,firstName,middleName,lastName,deptId)
values(4,'Ram','Reddy','',2);
insert into employee(id,firstName,middleName,lastName,deptId)
values(5,'Shyam','Reddy','',2);
insert into employee(id,firstName,middleName,lastName,deptId)
values(6,'Krishna','Reddy','',2);

update employee set lastName = null where lastName='';

update employee set lastName = 'Test' where id in (5,6);
