DROP TABLE MEMBER;
CREATE TABLE MEMBER
(
        NO      NUMBER PRIMARY KEY,
        ID      VARCHAR2(32) NOT NULL UNIQUE,
        PW      VARCHAR2(64),                   -- 암호화된 비밀번호 최대 64 바이트
        NAME    VARCHAR2(100),
        EMAIL   VARCHAR2(100) NOT NULL UNIQUE,  -- 이메일 인증 때문에 중복 방지를 시켰다.
        STATE   NUMBER(1),                      --상태 (정상 : 1 , 탈퇴 : -1)
        REGISTED DATE -- 가입일

);

DROP SEQUENCE MEMBER_SEQ;
CREATE SEQUENCE MEMBER_SEQ NOCACHE;