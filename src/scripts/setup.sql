DROP TABLE Person;
CREATE TABLE PERSON (
 ID INTEGER NOT NULL,
 FIRST_NAME VARCHAR(50),
 LAST_NAME VARCHAR(50),
 PHONE_NUMBER INTEGER,
 PRIMARY KEY (ID)
);
insert into Person values(100,'Peter','Hansen', null);
insert into Person values(110,'Lone','Hansen', null);
insert into Person values(120,'John','McDonald', 1337);
insert into Person values(130,'Peter','Jensen', null);

commit;