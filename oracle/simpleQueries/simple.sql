create table city(
	city_id INT(10),
    city_name varchar(100),
    constraint city_pk primary key (city_id)  	
);

create table employees(
	emp_id INT,
    emmp_name varchar(100),
    manager_id INT,
    city_id INT,
    
    constraint emp_pk primary key (emp_id),
    constraint emp_city_fk foreign key (city_id) references city(city_id)
);

insert into city values (10, 'Bangalore');
insert into city values (20, 'London');
select * from city;

insert into employees values (101,'aju',201,10);
insert into employees values (102,'pavan',201,10);
insert into employees values (103,'babu',202,10);
insert into employees values (201,'archana',202,10);
insert into employees values (202,'vijay',null,10);

insert into employees values (404,'mukthar',null,20);

update employees set manager_id=404 where emp_id =202;

insert into employees values (2111,'asas',null,10);
delete from employees where emp_id =2111;


select * from employees;

select * from employees e join city c on (e.city_id = c.city_id);

select e.emmp_name, m.emmp_name from employees e join employees m on (e.manager_id = m.emp_id);
