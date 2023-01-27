use hospital;

drop table appointment;
drop table patient;
drop table doctor;
drop table receptionist;
drop table bill;
drop table admin;

create table patient(
	patient_id int not null auto_increment primary key, 
    name varchar(20) not null, 
    age int not null, 
    gender varchar(1), 
    phno varchar(12)
);

create table doctor(
	doctor_id int not null auto_increment primary key, name varchar(20) not null, 
	username varchar(20) not null unique key, 
	password varchar(255) not null, 
	specialization varchar(255), 
    phno varchar(12), 
    fees int default 500
);

create table receptionist(
	receptionist_id int not null auto_increment primary key, 
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
	appointment_id int not null auto_increment primary key, 
    patient_id int not null, 
    doctor_id int not null,  
    status varchar(20) default "NOT_VISITED" not null,
    begins datetime not null, 
    ends datetime not null,
    foreign key(patient_id) references patient(patient_id), 
    foreign key(doctor_id) references doctor(doctor_id)
);

create table bill(
	bill_id int not null auto_increment primary key,
    appointment_id int not null,
    amount int not null, 
    status varchar(20) default "UNPAID",
    foreign key(appointment_id) references appointment(appointment_id)
);

insert into patient(name, age, gender, phno) values("Patient1", 13, "M", "1234509876");
insert into patient(name, age, gender, phno)  values("Patient2", 14, "M", "1234567890");
insert into doctor(name, username, password, specialization) values("Doctor","docdoc", MD5("docdoc"),"cardio");
insert into admin values (1, "admin", MD5("alsoAdmin"));
insert into receptionist(name, username, password, phno) values("Receptionist", "recrec", MD5("recrec"), "1234509876");
insert into appointment(patient_id, doctor_id, begins, ends) values(1, 1, "2023-01-27 8:30", "2023-01-27 9:30"); 
insert into bill(appointment_id, amount) values(1, 500);

select * from admin;
select * from patient;
select * from doctor;
select * from receptionist;
select * from appointment;
select * from bill;

select bill.bill_id, patient.name, bill.amount from bill
inner join appointment on bill.appointment_id = appointment.appointment_id
inner join patient on appointment.patient_id = patient.patient_id where appointment.patient_id = 2;

select p.name,d.username,a.appointment_id,b.amount from bill as b
inner join appointment as a on a.appointment_id = b.appointment_id
inner join doctor as d on a.doctor_id = d.doctor_id
inner join patient as p on p.patient_id = a.patient_id;

select appointment.appointment_id, patient.name, doctor.name, appointment.begins, appointment.ends, appointment.status from appointment
inner join patient on appointment.patient_id = patient.patient_id
inner join doctor on appointment.doctor_id = doctor.doctor_id  where appointment.doctor_id = 1;

delete from bill where appointment_id = 1;
delete bill from bill 
inner join appointment on bill.appointment_id = appointment.appointment_id 
inner join patient on patient.patient_id = appointment.patient_id where patient.patient_id = 1;

update appointment set status = "VISITED" where appointment_id = 4;
select MAX(begins) from appointment where doctor_id = 1;