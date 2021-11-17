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