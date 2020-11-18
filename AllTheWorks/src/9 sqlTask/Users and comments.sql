CREATE database USER_ROLES;
USE USER_ROLES;

create table Roles (
	id int not null auto_increment,
    title varchar(20) not null,
    primary key (id)
);

CREATE TABLE Users (
	id INT not null auto_increment,
    username varchar(20) not null,
    email varchar(50),
    primary key (Id)
);

create table users_roles (
	id int not null auto_increment,
    roleId int not null,
    userId int not null,
    primary key (id),
    foreign key (roleId) references Roles (id),
    foreign key (userId) references Users (id)
);

insert into Roles (title) 
	values
    ("Guest"),
    ("User"),
    ("Moderator"),
    ("Admin");

insert into Users (username, email) 
	values
    ("user1", "email1"),
    ("user2", "email2"),
    ("user3", "email3"),
    ("user4", "email4"),
    ("user5", "email5"),
    ("user6", "email6"),
    ("user7", "email7"),
    ("user8", "email8");
    
insert into users_roles (roleId, userId) 
	values
    (1, 4),
    (4, 2),
    (1, 7),
    (2, 5),
    (3, 8),
    (4, 3),
    (2, 6),
    (3, 1);


