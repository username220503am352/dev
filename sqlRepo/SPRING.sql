DROP TABLE MEMBER;
CREATE TABLE MEMBER(
    MEMBER_ID VARCHAR2(100)
    , MEMBER_PWD VARCHAR2(100)
    , MEMBER_NICK VARCHAR2(100)
    , ENROLL_DATE TIMESTAMP
);

DROP TABLE BOARD;
CREATE TABLE BOARD(
    TITLE VARCHAR2(100)
    , CONTENT VARCHAR2(100)
    , ENROLL_DATE TIMESTAMP
);

DROP TABLE BOARD_CNT;
CREATE TABLE BOARD_CNT(
    CNT NUMBER
);

INSERT INTO BOARD_CNT
(CNT)
VALUES
(0)
;
COMMIT;

select * from board;
select * from board_cnt;














