create database if not exists footydb;
grant all on footydb.* to footy@localhost identified by 'footy';
use footydb;
drop table if exists ch22games;
CREATE TABLE ch22games ( home_team VARCHAR(32), away_team VARCHAR(32), winner INTEGER);
insert into games values ('Flemington', 'Brunswick', 1);
insert into games values ('Hawthorn', 'Malvern', 2);
insert into games values ('Dandenong', 'Springvale', 2);
insert into games values ('Carlton', 'Melbourne', 1);
