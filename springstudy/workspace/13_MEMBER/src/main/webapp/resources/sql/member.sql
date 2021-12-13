DROP TABLE MEMBER;
CREATE TABLE MEMBER
(
        NO      NUMBER PRIMARY KEY,
        ID      VARCHAR2(32) NOT NULL UNIQUE,
        PW      VARCHAR2(64),                   -- ��ȣȭ�� ��й�ȣ �ִ� 64 ����Ʈ
        NAME    VARCHAR2(100),
        EMAIL   VARCHAR2(100) NOT NULL UNIQUE,  -- �̸��� ���� ������ �ߺ� ������ ���״�.
        STATE   NUMBER(1),                      --���� (���� : 1 , Ż�� : -1)
        REGISTED DATE -- ������

);

DROP SEQUENCE MEMBER_SEQ;
CREATE SEQUENCE MEMBER_SEQ NOCACHE;