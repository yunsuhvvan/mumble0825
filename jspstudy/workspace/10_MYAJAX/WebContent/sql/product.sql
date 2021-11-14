DROP TABLE product1;
CREATE TABLE product1(

	pno		NUMBER PRIMARY KEY,
	name	VARCHAR2(20),
	price	NUMBER,
	made	DATE

);

DROP SEQUENCE product1_seq;
CREATE SEQUENCE product1_seq NOCACHE;