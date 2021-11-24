/*
	댓글형 게시판
	1. 공지사항  : notice
	2. 댓글  	 : reply
*/

DROP TABLE reply;
DROP TABLE notice;


CREATE TABLE notice(
 
/*게시글번호*/	nno				NUMBER,
/*작성자 */		writer			VARCHAR2(50),
/*제목*/		title			VARCHAR2(2000),
/*내용*/		content			VARCHAR2(4000),
/*조회수*/		hit				NUMBER,
/*작성자IP*/	ip				VARCHAR2(32),
/*작성일*/		ndate			DATE,
/*최종수정일*/	nlastmodified	DATE
);
	
CREATE TABLE reply(
/*댓글번호*/	rno			NUMBER,
/*작성자*/		writer		VARCHAR2(50),
/*댓글내용*/	content		VARCHAR2(2000),
/*작성자IP*/	ip			VARCHAR2(32),
/*게시글번호*/	nno			NUMBER,
/*댓글작성일*/	rdate		DATE
);

ALTER TABLE notice ADD CONSTRAINT notice_pk PRIMARY KEY(nno);
ALTER TABLE reply  ADD CONSTRAINT reply_pk	PRIMARY KEY(rno);
ALTER TABLE reply  ADD CONSTRAINT reply_notice_fk FOREIGN KEY(nno) REFERENCES notice(nno) ON DELETE CASCADE;

DROP SEQUENCE notice_seq;
DROP SEQUENCE reply_seq;
CREATE SEQUENCE notice_seq NOCACHE;
CREATE SEQUENCE reply_seq NOCACHE;

INSERT INTO notice VALUES(notice_seq.nextval, '관리자', '이용 시 주의사항', '바른말 사용하기', 0, '0:0:0:0:0:0:0', SYSDATE, SYSDATE );
commit





/*
 * 	회원
 *  1. 회원 : member
 *  2. 기록 : member_log
 * 
 */

DROP TABLE MEMBER_LOG;
DROP TABLE MEMBER;
CREATE TABLE MEMBER(
/* PK말고 다른 곳에 외래키 주기 위해서는 UNIQUE 필수*/

 /*회원번호*/  MNO			NUMBER,
 /* 아이디 */  ID			VARCHAR2(32) NOT NULL UNIQUE,  
 /*비밀번호*/  PW			VARCHAR2(32) NOT NULL,
 /* 이름 */	   NAME			VARCHAR2(50),
 /* 메일 */	   EMAIL		VARCHAR2(200),
 /*가입일*/	   MDATE		DATE
);

CREATE TABLE MEMBER_LOG(

	/*기록번호*/ LNO			NUMBER,
	/*아이디*/   ID				VARCHAR2(32),
	/*로그인일시*/LOGIN			DATE
);

ALTER TABLE MEMBER ADD CONSTRAINT MEMBER_PK PRIMARY KEY(MNO); 
ALTER TABLE MEMBER_LOG ADD CONSTRAINT MEMBERLOG_PK PRIMARY KEY(LNO);
ALTER TABLE MEMBER_LOG ADD CONSTRAINT MEMBER_LOG_MEMBER_FK FOREIGN KEY(ID) REFERENCES MEMBER(ID) ON DELETE CASCADE;

DROP SEQUENCE MEMBER_SEQ;
DROP SEQUENCE MEMBER_LOG_SEQ;

CREATE SEQUENCE MEMBER_SEQ NOCACHE;
CREATE SEQUENCE MEMBER_LOG_SEQ NOCACHE;

INSERT INTO MEMBER VALUES(MEMBER_SEQ.NEXTVAL, 'admin', '1111', '관리자', 'admin@myhome.com', SYSDATE);
INSERT INTO MEMBER VALUES(MEMBER_SEQ.NEXTVAL, 'scott', '1111', '스콧', 'scott@myhome.com', SYSDATE);
COMMIT



/*
 * 			계층형 게시판
 * 			자유게시판
 */

DROP TABLE FREE;
CREATE TABLE FREE(

	/*글번호*/		FNO			 NUMBER,
	/*작성자*/		WRITER		 VARCHAR2(32),
	/*내 용 */		CONTENT		 VARCHAR2(4000),
	/*  I P */  	IP			 VARCHAR2(32),
	/*조회수*/		HIT			 NUMBER,
	/*최초작성일*/	CREATED		 DATE,
	/*최종수정일*/	LASTMODIFIED DATE,
	/*삭제여부*/	STATE		 NUMBER, /*정상: 0, 삭제: -1*/
	/*게시글/댓글*/ DEPTH		 NUMBER, /*게시글: 0,   댓글 : 1 이상*/
	/*동일그룹*/	GROUPNO		 NUMBER, /*게시글: FNO, 댓글 : 게시글의 글번호(FNO) */
	/*그룹내순서*/	GROUPORD	 NUMBER  /*동일그룹내 표시순서를 의미*/
);


DROP SEQUENCE FREE_SEQ;
CREATE SEQUENCE FREE_SEQ NOCACHE;

ALTER TABLE FREE ADD CONSTRAINT FREE_PK PRIMARY KEY(FNO);












