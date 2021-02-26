CREATE DATABASE IF NOT EXISTS `bookstore`;
USE `bookstore`;

create table author
(
    id int not null
        primary key,
    first_name varchar(255) null,
    last_name varchar(255) null
);

create table book
(
    id int not null
        primary key,
    description varchar(255) null,
    name varchar(255) null,
    author_id int null,
    constraint FKklnrv3weler2ftkweewlky958
        foreign key (author_id) references author (id)
);

create table book_tag
(
    id int not null
        primary key,
    name varchar(255) null,
    book_id int null,
    constraint FKdrc33u5ufw8rdvajeveowgx7g
        foreign key (book_id) references book (id)
);

create table hibernate_sequence
(
    next_val bigint null
);

create table user
(
    id int not null
        primary key,
    email varchar(255) null,
    first_name varchar(255) null,
    last_name varchar(255) null,
    password varchar(255) null,
    username varchar(255) null
);


