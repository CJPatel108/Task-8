create database if not exists PoisedPMS;
use PoisedPMS;
drop table if exists project;
create table project
	(
		projectNumber int,
		projectName varchar(50),		
		typeOfBuilding varchar(50),
		physicalAddress varchar(50),
		erfNumber varchar(50),
		totalFeeCharged double,
		totalAmountPaidToDate double,
		deadline date,
		personId int,
		Primary Key(projectNumber),
		Foreign Key(personId) References person(personId)
	);
insert into projects values(1, "firstProject", "House", " 3 Blue Street", "234proj", 2100000, 30000);
insert into projects values(2, "secondProject", "Store", " 7 Yellow Street", "567proj", 4300000, 70000);

drop table if exists person;
create table person
	(
		personId int,
		name varchar(50),
		telephoneNumber varchar(50),
		emailAddress varchar(50),
		physicalAddress varchar(50),
		Primary Key(personId)
	);
insert into person values(1, "John Doe", "0127843969", "john.doe@gmail.com", "11 Red Street");
insert into person values(2, "Jane Doe", "0129843767", "jane.doe@gmail.com", "13 Green Street");
