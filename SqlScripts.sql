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

-- Users
CREATE SEQUENCE userSeq
START with 1
increment by 1
maxvalue 100000
minvalue 0;

CREATE TABLE users (
  ID BIGINT PRIMARY KEY NOT NULL,
  Name VARCHAR(100),
  Password VARCHAR(100),
  isAdmin BOOLEAN NOT NULL);
-- End Users

-- Author
CREATE SEQUENCE authorSeq
START with 1
increment by 1
maxvalue 100000
minvalue 0;

CREATE TABLE author (
  ID BIGINT NOT NULL PRIMARY KEY,
  NAME VARCHAR(100)
);
-- End Author

--Book
CREATE SEQUENCE bookseq
START with 1
increment by 1
maxvalue 100000
minvalue 0;

CREATE TABLE Book(
  ID BIGINT PRIMARY KEY NOT NULL,
  NAME VARCHAR(100),
  authorId BIGINT REFERENCES author(id),
  releaseDate DATE
);
--End Book

--Reading Room
CREATE SEQUENCE readingRoomSeq
START with 1
increment by 1
maxvalue 100000
minvalue 0;

CREATE TABLE readingRoom (
  ID BIGINT NOT NULL PRIMARY KEY ,
  UserId BIGINT REFERENCES users(ID),
  BookId BIGINT REFERENCES book(ID)
);
--End Reading Room

--Storage
CREATE TABLE Storage (
  BookId BIGINT REFERENCES book(ID),
  BookCount INTEGER
);
--End Storage