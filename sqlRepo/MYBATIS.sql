DROP TABLE MEMBER;
CREATE TABLE MEMBER
(
    MEMBER_ID VARCHAR2(100)
    , MEMBER_PWD VARCHAR2(100)
)
;

DROP TABLE BOARD;
CREATE TABLE BOARD(
    TITLE           VARCHAR2(1000)
    , CONTENT       VARCHAR2(4000)
    , ENROLL_DATE   TIMESTAMP
);


select * from board;