--SELECT

/*
    <SELECT 절>
        [문법]
            SELECT 칼럼1, 칼럼2, 칼럼3 .... 칼럼
            FROM 테이블명;
            
        - 데이터를 조회하고자 할 때 사용
        - SELECT 를 통해서 조회된 결과를 RESULT SET 이라고 한다. (조회된 행들의 집합)
        - 조회하고자 하는 칼럼들은 반드시 FROM 절에 기술한 테이블에 존재하는 칼럼이어야 한다.
*/


-- EMP 테이블에서, 사원번호,사원이름,월급 조회하기
SELECT EMPNO, ENAME, SAL FROM EMP;

-- EMP 테이블에서 모든 칼럼 조회하기
SELECT *
FROM EMP;

-- 대소문자 구분하지 않음 (관례상, 대문자로 씀)
select empno, ename 
from emp;

/*
    산술연산
        SELECT 절에 칼럼명 입력 부분에서 산술 연산을 이용해서 결과를 조회할 수 있다.
*/

-- EMP 테이블에서 직원이름, 직원연봉 조회하기
SELECT ENAME , SAL * 12
FROM EMP;

-- NULL 은 연산해도 NULL
SELECT ENAME, COMM * 12
FROM EMP;

-- 연산 중 NULL값이 하나라도 있다면 NULL
SELECT ENAME, (SAL + COMM) * 12
FROM EMP;

-- DATE 연산
SELECT ENAME, FLOOR(SYSDATE - HIREDATE)
FROM EMP;

-- 칼럼명에 별칭 지정
SELECT ENAME, FLOOR(SYSDATE - HIREDATE) 근무기간
FROM EMP;

-- 전체 직원의 이름, 1년치 (급여+COMM) 계산하여 조회
SELECT ENAME, (SAL + COMM) * 12 AS 연소득
FROM EMP;


/*
    <리터럴>
        SELECT 절에 리터럴을 사용하면 테이블에 존재하는 데이터처럼 조회가 가능하다.
        리터럴은 RESULT SET 의 모든 행에 반복 출력된다.
*/
-- EMP 테이블에서 사번, 이름, 급여(원) 조회
SELECT EMPNO , ENAME , SAL , '원 입니다.' AS "단위(만원)"
FROM EMP;

/*
    <DISTINCT>
        칼럼에 포함된 중복 값을 한번씩만 표시하고자 할 때 사용한다.
        SELECT 절에 한번만 기술 가능
        칼럼이 여러개이면 칼럼 값들이 모두 동일해야 중복 값으로 판단되어 중복이 제거된다.
*/

-- EMP 테이블에서 직업 을 조회 (중복제거)
SELECT DISTINCT JOB FROM EMP;

SELECT DISTINCT JOB, DEPTNO FROM EMP;
--SELECT DISTINCT JOB, DISTINCT DEPTNO FROM EMP; -- 에러발생 (DISTINCT 는 한번만 사용 가능)



/*
    <연결 연산자>
        여러 칼럼 값을 하나의 칼럼인것처럼 연결 하거나 컬럼과 리터럴을 연결할 수 있다.
*/

-- EMP 테이블에서, 사번,사원명,급여 를 연결해서 조회
SELECT EMPNO || ENAME || SAL
FROM EMP;

-- EMP 테이블에서, 사원명, 급여 를 리터럴로 연결하여 조회
SELECT ENAME || ' 의 월급은 ' || SAL || ' 입니다'
FROM EMP;


/*
    <WHERE 절>
        [문법]
            SELECT 칼럼1, 칼럼2, ... 칼럼
            FROM 테이블명
            WHERE 조건식;
            
        - 조회하고자 하는 테이블에서 해당 조건에 만족하는 결과만을 조회하고자 할 때 사용한다.
        - 조건식에는 다양한 연산자들을 사용할 수 있다.
        
    <비교 연산자>
        <, >, <=, >= : 대소비교
        =            : 동등비교
        != , ^=, <>  : 같지않다
*/

-- EMP 테이블에서 부서코드가 30인 사원들의 모든 칼럼 조회
SELECT *
FROM EMP
WHERE DEPTNO = 30;

-- EMP 테이블에서 부서코드가 20이 아닌 사원들의 사번,사원명,부서코드 조회
SELECT EMPNO, ENAME, DEPTNO
FROM EMP
WHERE DEPTNO != 20
;

-- EMP 테이블에서, 급여가 1000 이상인 직원들의 이름,부서코드,급여 조회
SELECT ENAME, DEPTNO, SAL
FROM EMP
WHERE SAL >= 1000;


-- 실습문제
-- 1. EMP 테이블에서 COMM 이 0 초과인 사원의 이름,입사일,부서코드 조회

-- 2. EMP 테이블에서 급여가 1500 이하인 사원의 이름, 급여, 부서코드 조회















