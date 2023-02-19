create database STUDENT_MANAGEMENT;
use STUDENT_MANAGEMENT;

	create table Student(
		fullName Nvarchar(50),
		doB date,
		sex Nvarchar(10),
		phoneNumber Nvarchar(50),
		universityName Nvarchar(50),
		gradeLevel Nvarchar(50),
		gpa float,
		bestRewardName Nvarchar(50),
		englishScore int,
		entryTestScore float
	);
insert into student(fullName,doB,sex,phoneNumber,universityName,gradeLevel,gpa,bestRewardName) values('Nguyen Thien Duy','05-02-1995','Nam','0968686868','DUE','Gioi',8.5,'Microsoft Awards');

truncate table Student;