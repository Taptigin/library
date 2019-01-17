CREATE ROLE libraryAdmin LOGIN
  ENCRYPTED PASSWORD '123'
  SUPERUSER INHERIT CREATEDB CREATEROLE REPLICATION;

CREATE DATABASE "Library"
WITH OWNER = libraryadmin
ENCODING = 'UTF8'
TABLESPACE = pg_default
LC_COLLATE = 'Russian_Russia.1251'
LC_CTYPE = 'Russian_Russia.1251'
CONNECTION LIMIT = -1;


-- Author
CREATE SEQUENCE authorSeq
START with 1
increment by 1
maxvalue 100000
minvalue 0;

CREATE TABLE author (
  ID BIGINT NOT NULL PRIMARY KEY,
  NAME VARCHAR(100) UNIQUE
);

INSERT INTO author VALUES (nextval('authorSeq'), 'Тестовый автор 1');
-- End Author

--Book
CREATE SEQUENCE bookseq
START with 1
increment by 1
maxvalue 100000
minvalue 0;

CREATE TABLE Book(
  ID BIGINT PRIMARY KEY NOT NULL,
  NAME VARCHAR(100) UNIQUE ,
  authorId BIGINT,
  releaseDate DATE,
  FOREIGN KEY (authorId) REFERENCES author(ID));

INSERT INTO Book VALUES (nextval('bookseq'), 'Тестовая книга 1', 1, '2018-12-12');
--End Book

--Reading Room
CREATE SEQUENCE readingRoomSeq
START with 1
increment by 1
maxvalue 100000
minvalue 0;

CREATE TABLE readingRoom (
  ID BIGINT NOT NULL PRIMARY KEY ,
  UserName VARCHAR(36) REFERENCES APP_USER(USER_NAME),
  BookId BIGINT REFERENCES book(ID)
);
--End Reading Room

--Storage
CREATE TABLE Storage (
  BookId BIGINT REFERENCES book(ID),
  BookCount INTEGER
);

INSERT INTO Storage VALUES (1, 5);
--End Storage

-- security tables
-- Create table
create table APP_USER
(
  USER_ID           BIGINT not null,
  USER_NAME         VARCHAR(36) not null,
  ENCRYTED_PASSWORD VARCHAR(128) not null,
  ENABLED           Int not null
) ;
--
alter table APP_USER
  add constraint APP_USER_PK primary key (USER_ID);

alter table APP_USER
  add constraint APP_USER_UK unique (USER_NAME);


-- Create table
create table APP_ROLE
(
  ROLE_ID   BIGINT not null,
  ROLE_NAME VARCHAR(30) not null
) ;
--
alter table APP_ROLE
  add constraint APP_ROLE_PK primary key (ROLE_ID);

alter table APP_ROLE
  add constraint APP_ROLE_UK unique (ROLE_NAME);


-- Create table
create table USER_ROLE
(
  ID      BIGINT not null,
  USER_ID BIGINT not null,
  ROLE_ID BIGINT not null
);
--
alter table USER_ROLE
  add constraint USER_ROLE_PK primary key (ID);

alter table USER_ROLE
  add constraint USER_ROLE_UK unique (USER_ID, ROLE_ID);

alter table USER_ROLE
  add constraint USER_ROLE_FK1 foreign key (USER_ID)
references APP_USER (USER_ID);

alter table USER_ROLE
  add constraint USER_ROLE_FK2 foreign key (ROLE_ID)
references APP_ROLE (ROLE_ID);



-- Used by Spring Remember Me API.
CREATE TABLE Persistent_Logins (

  username varchar(64) not null,
  series varchar(64) not null,
  token varchar(64) not null,
  last_used timestamp not null,
  PRIMARY KEY (series)

);

--------------------------------------

insert into App_User (USER_ID, USER_NAME, ENCRYTED_PASSWORD, ENABLED)
values (2, 'dbuser1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);

insert into App_User (USER_ID, USER_NAME, ENCRYTED_PASSWORD, ENABLED)
values (1, 'admin', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);

---

insert into app_role (ROLE_ID, ROLE_NAME)
values (1, 'ROLE_ADMIN');

insert into app_role (ROLE_ID, ROLE_NAME)
values (2, 'ROLE_USER');

---

insert into user_role (ID, USER_ID, ROLE_ID)
values (1, 1, 1);

insert into user_role (ID, USER_ID, ROLE_ID)
values (2, 1, 2);

insert into user_role (ID, USER_ID, ROLE_ID)
values (3, 2, 2);

-- end security tables