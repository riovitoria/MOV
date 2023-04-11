create database dbmovimenta;
show databases;
use dbmovimenta;
create table pessoa(
idcon int primary key auto_increment, 
nome varchar(50) not null,
prio1 varchar(1) not null,
prio2 varchar(1) not null,
prio3 varchar(1) not null,
prio4 varchar(1) not null,
prio5 varchar(1) not null
);
show tables;
