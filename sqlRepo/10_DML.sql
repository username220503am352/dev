--DML (INSERT , UPDATE , DELETE)

/*
    <DML(Data Manipulation Language)>
        데이터 조작 언어로 테이블에 값을 삽입(INSERT)하거나, 수정(UPDATE), 삭제(DELETE)하는 구문이다.
    
    <INSERT>
        테이블에 새로운 행을 추가하는 구문이다.
        
        [문법]
            1) INSERT INTO 테이블명 VALUES(값, 값, 값, ..., 값);
                테이블에 모든 칼럼에 값을 INSERT 하고자 할 때 사용한다.
                칼럼 순번을 지켜서 VALUES에 값을 나열해야 한다.
            2) INSERT INTO 테이블명(칼럼명, 칼럼명, ..., 칼럼명) VALUES(값, 값, ..., 값);
                테이블에 내가 선택한 칼럼에 대한 값만 INSERT 하고자 할 때 사용한다.
                선택이 안된 칼럼들은 기본적으로 NULL 값이 들어간다. (NOT NULL 제약조건이 걸려있는 칼럼은 반드시 선택해서 값을 제시해야 한다.)
                단, 기본값(DEFAULT)이 지정되어 있으면 NULL이 아닌 기본값이 들어간다.
            3) INSERT INTO 테이블명 (서브쿼리);
                VALUES를 대신해서 서브 쿼리로 조회한 결과값을 통채로 INSERT 한다.(즉, 여러행을 INSERT 시킬 수 있다.)
                서브 쿼리의 결과값이 INSERT 문에 지정된 칼럼의 개수와 데이터 타입이 같아야 한다.
*/


--1) 모든 칼럼
INSERT INTO EMPLOYEE 
VALUES('900', '공유' , '901008-1080503' , 'you@kh.or.kr', '01055556666', 'D1', 'J7', 4000000, 0.2 , '200', SYSDATE, NULL, DEFAULT);

--2) 칼럼 지정
INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME, EMP_NO, JOB_CODE)
VALUES('901', '심원용', '800923-1234567', 'J7');

--3) 서브쿼리

CREATE TABLE EMP_01(
    EMP_ID NUMBER
    , EMP_NAME VARCHAR2(30)
    , DEPT_TITLE VARCHAR2(35)
);

INSERT INTO EMP_01(EMP_ID, EMP_NAME, DEPT_TITLE) VALUES('777' , '홍길동', '인사관리부');
INSERT INTO EMP_01(EMP_ID, EMP_NAME, DEPT_TITLE) VALUES('888' , '이순신', '인사관리부');

SELECT * FROM EMP_01;

INSERT INTO EMP_01
(
    SELECT E.EMP_ID, E.EMP_NAME, D.DEPT_TITLE
    FROM EMPLOYEE E
    LEFT OUTER JOIN DEPARTMENT D ON (E.DEPT_CODE = D.DEPT_ID)
)
;

DROP TABLE EMP_01;

/*
    <INSERT ALL>
        두 개 이상의 테이블에 INSERT 하는데 동일한 서브 쿼리가 사용되는 경우
        INSERT ALL을 이용해서 여러 테이블에 한 번에 데이터 삽입이 가능하다.
        
        [표현법]
            1) INSERT ALL
               INTO 테이블명1[(칼럼, 칼럼, ...)] VALUES(값, 값, ...)
               INTO 테이블명2[(칼럼, 칼럼, 칼럼, ...)] VALUES(값, 값, 값, ...)
               서브 쿼리;
               
            2) INSERT ALL
               WHEN 조건1 THEN 
                   INTO 테이블명1[(칼럼, 칼럼, ...)] VALUES(값, 값, ...)
               WHEN 조건2 THEN     
                   INTO 테이블명2[(칼럼, 칼럼, ...)] VALUES(값, 값, ...)
               서브 쿼리;
*/

--1)
-- 테스트용 테이블 준비 (테이블 구조만 복사)
DROP TABLE EMP_DEPT;
CREATE TABLE EMP_DEPT
AS
SELECT EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE 1=2
;

DROP TABLE EMP_MANAGER;
CREATE TABLE EMP_MANAGER
AS
SELECT EMP_ID, EMP_NAME, MANAGER_ID
FROM EMPLOYEE
WHERE 1=2
;

SELECT * FROM EMP_MANAGER;

-- INSERT ALL
INSERT ALL
INTO EMP_DEPT VALUES(EMP_ID,EMP_NAME,DEPT_CODE, HIRE_DATE)
INTO EMP_MANAGER VALUES(EMP_ID, EMP_NAME, MANAGER_ID)
    SELECT EMP_ID , EMP_NAME, DEPT_CODE, HIRE_DATE, MANAGER_ID
    FROM EMPLOYEE
    WHERE DEPT_CODE = 'D1';

SELECT * FROM EMP_DEPT;
SELECT * FROM EMP_MANAGER;

DROP TABLE EMP_DEPT;
DROP TABLE EMP_MANAGER;

--2)
-- 테이블 준비
CREATE TABLE EMP_OLD
AS 
SELECT EMP_ID , EMP_NAME, HIRE_DATE, SALARY
FROM EMPLOYEE
WHERE 1=2;

CREATE TABLE EMP_NEW
AS 
SELECT EMP_ID , EMP_NAME, HIRE_DATE, SALARY
FROM EMPLOYEE
WHERE 1=2;

--INSERT ALL
INSERT ALL
WHEN HIRE_DATE < '2000/01/01' THEN INTO EMP_OLD VALUES(EMP_ID , EMP_NAME, HIRE_DATE, SALARY)
WHEN HIRE_DATE >= '2000/01/01' THEN INTO EMP_NEW VALUES(EMP_ID , EMP_NAME, HIRE_DATE, SALARY)
SELECT EMP_ID, EMP_NAME, HIRE_DATE, SALARY
FROM EMPLOYEE;

SELECT * FROM EMP_OLD;
SELECT * FROM EMP_NEW;

--UPDATE
UPDATE EMP_OLD
SET 
SALARY = SALARY + 1
, EMP_NAME = '선동이'
WHERE EMP_NAME = '선동일'
;

--DELETE
DELETE EMP_OLD
--WHERE SALARY < 3000000 
;

/*
    <TRUNCATE>
        테이블 전체 행 삭제(조건 설정 불가능)
        DELETE 보다 빠름
        ROLLBACK 불가능
*/

TRUNCATE TABLE EMP_NEW;
SELECT * FROM EMP_NEW;

DROP TABLE EMP_OLD;
DROP TABLE EMP_NEW;










