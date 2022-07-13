-- 서브쿼리

/*
    <SUBQUERY>
        하나의 SQL 문 안에 포함된 또 다른 SQL문
        메인 쿼리(기존 쿼리) 를 보조하는 역할
*/

-- 서브쿼리 예시

-- 노옹철 사원의 부서코드 조회 --D9
SELECT EMP_NAME, DEPT_CODE
FROM EMPLOYEE
WHERE EMP_NAME = '노옹철';

-- 노옹철 사원과 부서코드가 같은 사원들을 조회
SELECT EMP_NAME , DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE = (
    SELECT DEPT_CODE
    FROM EMPLOYEE
    WHERE EMP_NAME = '노옹철'
);

/*
    <서브 쿼리 구분>
        서브 쿼리는 서브 쿼리를 수행한 결과의 행과 열의 갯수에 따라서 분류
        
        1) 단일행 서브 쿼리        : 서브 쿼리의 조회결과 값의 행과 열의 갯수가 1개 일 때
        2) 다중행 서브 쿼리        : 서브 쿼리의 조회결과 값의 행의 갯수가 여러행 일 때
        3) 다중열 서브 쿼리        : 서브 쿼리의 조회결과 값이 한 행이지만, 칼럼이 여러개 일 때
        4) 다중행, 다중열 서브 쿼리 : 서브 쿼리의 조회결과 값이 여러행, 여러열 일 때
        
        * 서브 쿼리의 유형에 따라서 서브쿼리 앞에 붙는 연산자가 달라진다.
*/

/*
    <단일행 서브쿼리>
        서브쿼리의 조회 결과 값의 행과 열의 갯수가 1개 일 때
        비교 연산자 사용 가능
*/

-- 1) 전 직원의 평균 급여보다 급여를 적게 받는 직원들의 이름, 직급코드, 급여 조회

-- 전 직원 평균 급여
SELECT AVG(NVL(SALARY, 0))
FROM EMPLOYEE
;

SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY < (
    SELECT AVG(NVL(SALARY, 0))
    FROM EMPLOYEE
)
;


-- 2) 최저 급여를 받는 직원의 사번, 이름, 직급코드, 급여, 입사일 조회
SELECT MIN(SALARY)
FROM EMPLOYEE
;


SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY, HIRE_DATE
FROM EMPLOYEE
WHERE SALARY = (
    SELECT MIN(SALARY)
    FROM EMPLOYEE
)
;

-- 3) 노옹철 사원의 급여보다 더 많은 급여를 받는 사원들의 사번, 사원명, 부서명, 직급코드, 급여 조회

SELECT SALARY
FROM EMPLOYEE
WHERE EMP_NAME = '노옹철'
;


SELECT 
    EMP_ID
    , EMP_NAME
    , DEPT_TITLE
    , JOB_CODE
    , SALARY
FROM EMPLOYEE E
JOIN DEPARTMENT D ON E.DEPT_CODE = D.DEPT_ID
WHERE SALARY > (
    SELECT SALARY
    FROM EMPLOYEE
    WHERE EMP_NAME = '노옹철'
)
;

-- 4) 부서별 급여의 합이 가장 큰 부서의 부서코드, 급여의 합 조회
SELECT MAX(SUM(SALARY))
FROM EMPLOYEE
GROUP BY DEPT_CODE
;


SELECT DEPT_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING SUM(SALARY) = (
    SELECT MAX(SUM(SALARY))
    FROM EMPLOYEE
    GROUP BY DEPT_CODE
)
;


























