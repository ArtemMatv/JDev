create database forum_db;
use forum_db;

create table roles (
	id int not null auto_increment,
	title varchar(20) not null,
    primary key (id)
);

create table users (
	id int not null auto_increment,
    roleId int not null,
    username varchar(20) not null,
    email varchar(50) not null,
    isBanned boolean,
    isSilenced boolean,
    primary key (id),
    foreign key (roleId) references roles (id)
);

create table sections (
	id int not null auto_increment,
    title varchar(25) not null,
    primary key (id)
);

create table posts (
	id int not null auto_increment,
    authorId int not null,
    sectionId int not null,
    dateCreated Datetime,
    title varchar(50) not null,
    message varchar(1000) not null,
    primary key (id),
    foreign key (authorId) references users (id),
    foreign key (sectionId) references sections (id)
);

create table comments (
	id int not null auto_increment,
    authorId int not null,
    postId int not null,
    dateCreated Datetime,
    message varchar(200) not null,
    primary key (id),
    foreign key (authorId) references users (id),
    foreign key (postId) references posts (id)
);

create table comment_answ (
	id int not null auto_increment,
    authorId int not null,
    commentId int not null,
    dateCreated Datetime,
    message varchar(200) not null,
    primary key (id),
    foreign key (authorId) references users (id),
    foreign key (commentId) references comments (id)
);

