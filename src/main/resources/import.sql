insert into department (id, name, building) values ('Sales', 'A2');
insert into department (id, name, building) values ('IT', 'B1');

insert into employee (id, name, age, email, dep_id) values ('Joe', 32, 'joe@mail.com', select id from department where name = 'Sales');
insert into employee (id, name, age, email, dep_id) values ('Sam', 28, 'sam@mail.com', select id from department where name = 'IT');
insert into employee (id, name, age, email, dep_id) values ('John', 43, 'john@mail.com', select id from department where name = 'IT');