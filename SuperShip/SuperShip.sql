create database SuperShip
use SuperShip
drop database SuperShip
create table account(
username varchar(30),
password varchar(30),
gmail varchar(50)
)

insert into account(username,password) values('admin','admin')
insert into account(username,password) values('client','client')
insert into account(username,password) values('mod','mod')

select * from account
select * from account where username like 'admin' and password like 'admin'
select * from account where username like 'client' and password like 'client'
select * from account where username like 'mod' and password like 'mod'