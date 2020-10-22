insert into department (id, name, building) values (1, 'Sales', 'A2');
insert into department (id, name, building) values (2, 'IT', 'B1');

insert into employee (id, name, age, email, dep_id) values (1001, 'Joe', 32, 'joe@mail.com', select id from department where name = 'Sales');
insert into employee (id, name, age, email, dep_id) values (1002, 'Sam', 28, 'sam@mail.com', select id from department where name = 'IT');
insert into employee (id, name, age, email, dep_id) values (1003, 'John', 43, 'john@mail.com', select id from department where name = 'IT');