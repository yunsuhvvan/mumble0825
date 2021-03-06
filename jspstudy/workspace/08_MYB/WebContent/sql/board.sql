DROP TABLE board;
CREATE TABLE board
(
	idx		NUMBER	PRIMARY KEY,
	title	VARCHAR2(50),
	writer	VARCHAR2(50),
	content	VARCHAR2(100),
	register VARCHAR2(10)-- '2021-11-10'
);

DROP SEQUENCE board_seq;
CREATE SEQUENCE board_seq INCREMENT BY 1 START WITH 1000 NOMINVALUE NOMAXVALUE NOCYCLE NOCACHE;
