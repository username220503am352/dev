-- ���� ������Ʈ

-------------------------------
-- ���̺� ����
-------------------------------


-------------------------------
-- MEMBER ���̺� ����
-------------------------------
DROP TABLE MEMBER CASCADE CONSTRAINTS;
CREATE TABLE MEMBER(
    NO              NUMBER          PRIMARY KEY
    , ID            VARCHAR2(100)   NOT NULL UNIQUE
    , PWD           VARCHAR2(100)   NOT NULL
    , NICK          VARCHAR2(100)   NOT NULL UNIQUE
    , ADDR          VARCHAR2(100)   
    , HOBBY         VARCHAR2(100)
    , ENROLL_DATE   TIMESTAMP       DEFAULT SYSDATE
    , MODIFY_DATE   TIMESTAMP       DEFAULT SYSDATE
    , STATUS        CHAR(1)         DEFAULT 'O' CHECK(STATUS IN ('O','X'))
);

DROP SEQUENCE SEQ_MEMBER_NO;
CREATE SEQUENCE SEQ_MEMBER_NO NOCACHE NOCYCLE;


-------------------------------
-- NOTICE ���̺� ����
-------------------------------
DROP TABLE NOTICE CASCADE CONSTRAINTS;
CREATE TABLE NOTICE(
    NO              NUMBER          PRIMARY KEY
    , TITLE         VARCHAR2(100)   NOT NULL 
    , CONTENT       VARCHAR2(4000)  NOT NULL
    , WRITER        NUMBER          NOT NULL
    , HIT           NUMBER          DEFAULT 0
    , ENROLL_DATE   TIMESTAMP       DEFAULT SYSDATE
    , MODIFY_DATE   TIMESTAMP       DEFAULT SYSDATE
    , STATUS        CHAR(1)         DEFAULT 'O' CHECK(STATUS IN ('O' , 'X'))
    , CONSTRAINT FK_NOTICE_MEMBER FOREIGN KEY(WRITER) REFERENCES MEMBER(NO)
);

DROP SEQUENCE SEQ_NOTICE_NO;
CREATE SEQUENCE SEQ_NOTICE_NO NOCACHE NOCYCLE;





---------------------------------------------------------------------------
----------------�׽�Ʈ�� ���� (������ ��)-------------------------------------


SELECT 
      N.NO
    , N.TITLE
    , N.CONTENT
    , N.WRITER
    , N.HIT
    , N.ENROLL_DATE
    , N.MODIFY_DATE
    , N.STATUS
    , M.NICK
FROM NOTICE N
JOIN MEMBER M 
ON N.WRITER = M.NO
WHERE N.NO = 3 
AND N.STATUS = 'O'










