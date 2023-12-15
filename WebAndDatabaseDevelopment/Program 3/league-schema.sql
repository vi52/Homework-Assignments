DROP DATABASE IF EXISTS league;
CREATE DATABASE league;
USE league;

DROP TABLE IF EXISTS parent CASCADE;
CREATE TABLE parent (
  plname varchar(15) not null,
  pfname varchar(15) not null,
  address varchar(50) not null,
  homenum char(10) not null,
  primary key (homenum)
);

DROP TABLE IF EXISTS player CASCADE;
CREATE TABLE player (
  lname varchar(15) not null,
  fname varchar(15) not null,
  age char(2) not null,
  team varchar(15),
  parent char(10),
  tcoach varchar(15),
  foreign key (parent) references parent(homenum),
  primary key (fname,lname)
);

DROP TABLE IF EXISTS coach CASCADE;
CREATE TABLE coach (
  clname varchar(15) not null,
  cfname varchar(15) not null,
  chomenum char(10) not null,
  teamn varchar(15),
  primary key (chomenum)
);

DROP TABLE IF EXISTS team CASCADE;
CREATE TABLE team (
  tname varchar(15) not null,
  color varchar(15) not null,
  coach varchar(15),
  primary key (tname),
  unique (tname),
  foreign key (coach) references coach(chomenum)
);

ALTER TABLE player ADD (
  foreign key (team) references team(tname),
  foreign key (tcoach) references coach(chomenum)
);

ALTER TABLE coach ADD (
  foreign key (teamn) references team(tname)
);
