use hospital;

alter table doctor add column doc_password varchar(20);
select * from doctor;
drop table patient;
drop table doctor;
drop table admin;

create table Doctor(doc_id int not null primary key, doc_name varchar(20),  doc_password varchar(20));

create table admin(id int not null primary key auto_increment, username varchar(255) not null unique key, password varchar(255) not null);
insert into admin(username, password) values("admin1", MD5("maranamass"));
 
create table patient(id int not null auto_increment, name varchar(255), age int not null, gender varchar(6), primary key(id));
alter table patient modify column id int not null auto_increment;

insert into patient values(1, "Siva", 13, "M");
insert into patient(name, age, gender) values("Rama", 14, "M");
insert into patient(name, age, gender) values("Krishnan", 15, "M");
insert into patient(name, age, gender) values("Krishnan", 15, "M");

select * from patient;