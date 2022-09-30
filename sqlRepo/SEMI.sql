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


---------------------------------------------------------------------------
----------------테스트용 쿼리 (삭제할 것)-------------------------------------
INSERT INTO MEMBER
(
    NO
    ,ID
    ,PWD
    ,NICK
    ,ADDR
    ,HOBBY
)
VALUES
(
    SEQ_MEMBER_NO.NEXTVAL
    , ?
    , ?
    , ?
    , ?
    , ?
)
;
ROLLBACK;






















