use hospital;

drop table appointment;
drop table patient;
drop table doctor;
drop table receptionist;
drop table admin;

create table patient(
	id int not null auto_increment primary key, 
    name varchar(20) not null, 
    age int not null, 
    gender varchar(1), 
    phno varchar(12)
);

create table doctor(
	id int not null auto_increment primary key, name varchar(20) not null, 
	username varchar(20) not null unique key, 
	password varchar(255) not null, 
	specialization varchar(255), 
    phno varchar(12)
);

create table receptionist(
	id int not null auto_increment primary key, 
	name varchar(20) not null, 
	username varchar(20) not null unique key, 
	password varchar(255) not null, 
    phno varchar(12)
);

create table admin(
	id int not null auto_increment primary key, 
    username varchar(20) not null, 
    password varchar(255) not null
);
 
create table appointment(
	id int not null auto_increment primary key, 
    patient_id int not null, 
    doctor_id int not null,  
    status varchar(20) default "NOT_VISITED" not null,
    begins datetime not null, 
    ends datetime not null,
    foreign key(patient_id) references patient(id), 
    foreign key(doctor_id) references doctor(id)
);

insert into patient(name, age, gender, phno) values("Siva", 13, "M", "1234509876");
insert into patient(name, age, gender, phno)  values("Rama", 14, "M", "1234567890");
insert into doctor(name, username, password, specialization) values("siva","siva", MD5("siva"),"siva");
insert into appointment(patient_id, doctor_id, begins, ends) values(1, 1, "2023-01-26 5:30:00", "2023-01-26 5:30:00");
insert into admin values (1, "admin", MD5("alsoAdmin"));

select * from admin;
select * from patient;
select * from doctor;
select * from receptionist;
select * from appointment;

select appointment.id, patient.name, doctor.name, appointment.begins, appointment.ends, appointment.status from appointment 
inner join patient on appointment.patient_id = patient.id
inner join doctor on appointment.doctor_id = doctor.id;

select apointments.Appointment_id, patients.name from apointments inner join patients on patients.ID = apointments.patient_id;