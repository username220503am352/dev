-- 세미 프로젝트

-------------------------------
-- 테이블 삭제
-------------------------------


-------------------------------
-- MEMBER 테이블 생성
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
-- NOTICE 테이블 생성
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



-------------------------------
-- BOARD 테이블 생성
-------------------------------
DROP TABLE BOARD CASCADE CONSTRAINTS;
CREATE TABLE BOARD(
    NO              NUMBER          PRIMARY KEY
    , TYPE          NUMBER          NOT NULL CHECK(TYPE IN (1,2)) --1:일반게시판 , 2:사진게시판
    , CATEGORY      NUMBER  --1:코딩 , 2:낚시 , 3:운동
    , TITLE         VARCHAR2(100)   NOT NULL
    , CONTENT       VARCHAR2(4000)  NOT NULL
    , WRITER        NUMBER          NOT NULL
    , HIT           NUMBER          DEFAULT 0
    , ENROLL_DATE   TIMESTAMP       DEFAULT SYSDATE
    , MODIFY_DATE   TIMESTAMP       DEFAULT SYSDATE
    , STATUS        CHAR(1)         DEFAULT 'O' CHECK(STATUS IN ('O','X'))
    , CONSTRAINT FK_BOARD_MEMBER FOREIGN KEY(WRITER) REFERENCES MEMBER(NO)
);

DROP SEQUENCE SEQ_BOARD_NO;
CREATE SEQUENCE SEQ_BOARD_NO NOCACHE NOCYCLE;


-------------------------------
-- CATEGORY 테이블 생성
-------------------------------
DROP TABLE CATEGORY CASCADE CONSTRAINTS;
CREATE TABLE CATEGORY(
    NO      NUMBER          PRIMARY KEY
    , NAME  VARCHAR2(100)   NOT NULL
);

INSERT INTO CATEGORY (NO,NAME) VALUES(10 , '코딩');
INSERT INTO CATEGORY (NO,NAME) VALUES(20 , '낚시');
INSERT INTO CATEGORY (NO,NAME) VALUES(30 , '운동');
COMMIT;

-------------------------------
-- ATTACHMENT 테이블 생성
-------------------------------

DROP TABLE ATTACHMENT CASCADE CONSTRAINTS;
CREATE TABLE ATTACHMENT(
    NO              NUMBER          PRIMARY KEY
    , BOARD_NO      NUMBER          NOT NULL
    , ORIGIN_NAME   VARCHAR2(255)   NOT NULL
    , CHANGE_NAME   VARCHAR2(255)   NOT NULL
    , FILE_PATH     VARCHAR2(1000)  NOT NULL
    , ENROLL_DATE   TIMESTAMP       DEFAULT SYSDATE
    , THUMB_YN      CHAR(1)         DEFAULT 'N' CHECK (THUMB_YN IN ('Y','N'))
    , STATUS        CHAR(1)         DEFAULT 'O' CHECK (STATUS IN ('O','X'))
    , CONSTRAINT FK_ATTACHMENT_BOARD FOREIGN KEY(BOARD_NO) REFERENCES BOARD(NO)
);

DROP SEQUENCE SEQ_ATTACHMENT_NO;
CREATE SEQUENCE SEQ_ATTACHMENT_NO NOCYCLE NOCACHE;






---------------------------------------------------------------------------
----------------테스트용 쿼리 (삭제할 것)-------------------------------------
SELECT *
FROM
(
    SELECT ROWNUM AS RNUM , T.*
    FROM 
    (
        SELECT 
            B.NO 
            ,B.TYPE 
            ,B.CATEGORY 
            ,B.TITLE 
            ,B.CONTENT 
            ,B.HIT 
            ,B.ENROLL_DATE 
            ,B.MODIFY_DATE 
            ,B.STATUS 
            ,M.NICK AS WRITER 
        FROM BOARD B 
        JOIN MEMBER M 
        ON B.WRITER = M.NO 
        WHERE B.STATUS = 'O'
        ORDER BY B.NO DESC
    ) T
)
WHERE RNUM BETWEEN 11 AND 20
;


























