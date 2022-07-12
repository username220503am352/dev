-- 테이블 생성
DROP TABLE MEMBER;
CREATE TABLE MEMBER(
    ID VARCHAR2(30)
    , PWD VARCHAR2(100)
    , NICK VARCHAR2(10)
    , GENDER CHAR(1)
    , ENROLL_DATE TIMESTAMP
);

-- MEMBER 테이블의 모든 데이터 조회
SELECT * FROM MEMBER;

-- MEMBER 테이블에 INSERT
INSERT INTO MEMBER(ID, PWD, NICK, GENDER, ENROLL_DATE) VALUES('SWY', '1234', '1DRAGON', 'M', SYSDATE);
INSERT INTO MEMBER(ID, PWD, NICK, GENDER, ENROLL_DATE) VALUES('USER01', '1234', 'NICK01', 'M', SYSDATE);
INSERT INTO MEMBER(ID, PWD, NICK, GENDER, ENROLL_DATE) VALUES('USER02', '1234', 'NICK01', NULL, SYSDATE);
INSERT INTO MEMBER(ID, PWD, NICK, ENROLL_DATE) VALUES('USER03', '1234', 'NICK03', SYSDATE);
INSERT INTO MEMBER VALUES('NICK99', '1234', 'USER99', 'M', SYSDATE);

-- MEMBER 테이블 UPDATE
UPDATE MEMBER SET 
    PWD = '7777' 
    , ENROLL_DATE = SYSDATE
    WHERE ID = 'SWY'
;

-- MEMBER 테이블 DELETE
DELETE MEMBER
WHERE ID = 'NICK99'
;

COMMIT;
ROLLBACK;

INSERT INTO MEMBER VALUES('NICK99', '1234', 'USER99', 'M', SYSDATE);

SELECT * FROM MEMBER;

ROLLBACK;
































