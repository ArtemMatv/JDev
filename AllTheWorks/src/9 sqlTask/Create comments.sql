CREATE database COMMENTS_DB;
USE COMMENTS_DB;
CREATE TABLE COMMENTS (
	Id INT NOT NULL auto_increment,
    Message VARCHAR(200),
    Created datetime,
    AuthorName varchar(20),
    AuthorEmail varchar(50),
    primary key (Id)
);

INSERT into COMMENTS (Message, Created, AuthorName, AuthorEmail)
VALUES 
	("Hello, this is the first comment here", "2020.12.12", "Artem", "kvazar2569@gmail.com"),
    ("This is the second comment here", "2020.12.12", "Vasya", "puppa@gmail.com"),
    ("The third comment", "2020.12.12", "Vova", "luppa@gmail.com"),
    ("Comment 4", "2020.12.12", "Anatoliy", "zapuppu@gmail.com"),
    ("5th here", "2020.12.12", "Oleg", "samiznaite@gmail.com");
