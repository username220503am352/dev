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

-- 5) 전지연 사원이 속해있는 부서원들 조회 (전지연 사원은 제외)
-- 사번, 사원명, 전화번호, 직급명, 부서명, 입사일 

-- 전지연 사원 부서코드 조회
SELECT DEPT_CODE
FROM EMPLOYEE
WHERE EMP_NAME = '전지연';


SELECT
    EMP_ID
    , EMP_NAME
    , PHONE
    , JOB_NAME
    , DEPT_TITLE
    , HIRE_DATE
FROM EMPLOYEE E
JOIN DEPARTMENT D ON (E.DEPT_CODE = D.DEPT_ID) 
JOIN JOB J ON E.JOB_CODE = J.JOB_CODE
WHERE DEPT_CODE = (
    SELECT DEPT_CODE
    FROM EMPLOYEE
    WHERE EMP_NAME = '전지연'
)
AND EMP_NAME != '전지연'
;

/*
    <다중행 서브 쿼리>
        서브 쿼리의 조회결과값의 행의 갯수가 여러 행 일 때
        
        IN / NOT IN (서브쿼리) : 여러개의 결과값 중에서 한개라도 일치한다면 TRUE 리턴
        ANY: 여러개의 값들 중 한개라도 만족하면 TRUE, IN 과 다른점은 비교 연산자를 함께 사용한다는 점
            ANY(100, 200, 300)
            SALARY = ANY(...) : IN 과 같은 결과
            SALARY != ANY(...) : NOT IN 과 같은 결과
            SALARY > ANY(...) : 최소값 보다 크면 TRUE
            SALARY < ANY(...) : 최대값 보다 작으면 TRUE
        ALL: 여러개의 값들 모두와 비교하여 만족해야 TRUE , IN 과 다른점은 비교 연산자를 함께 사용한다는 점
            ALL(100,200,300)
            SALARY > ALL(...) : 최대값 보다 크면 TRUE
            SALARY < ALL(...) : 최소값 보다 작으면 TRUE
*/

-- 1) 각 부서별 최고 급여를 받는 직원의 이름, 직급 코드, 부서 코드, 급여 조회
SELECT MAX(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE
;

SELECT EMP_NAME, JOB_CODE, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY IN 
(
    SELECT MAX(SALARY)
    FROM EMPLOYEE
    GROUP BY DEPT_CODE
)
ORDER BY SALARY DESC
;

-- 2) 전 직원들에 대해 사번, 이름, 부서코드, 구분(사수/사원)

-- 사수에 해당하는 사번 조회 --
SELECT DISTINCT MANAGER_ID
FROM EMPLOYEE
WHERE MANAGER_ID IS NOT NULL
;


-- 사수 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE , '사수' 구분
FROM EMPLOYEE
WHERE EMP_ID IN 
(
    SELECT DISTINCT MANAGER_ID
    FROM EMPLOYEE
    WHERE MANAGER_ID IS NOT NULL
)

UNION

-- 사원 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE , '사원' 구분
FROM EMPLOYEE
WHERE EMP_ID NOT IN 
(
    SELECT DISTINCT MANAGER_ID
    FROM EMPLOYEE
    WHERE MANAGER_ID IS NOT NULL
)
;


-- SELECT 절에 서브쿼리 사용
SELECT 
    EMP_ID
    , EMP_NAME
    , DEPT_CODE
    , CASE 
        WHEN EMP_ID IN 
        (
            SELECT DISTINCT MANAGER_ID
            FROM EMPLOYEE
            WHERE MANAGER_ID IS NOT NULL
        ) THEN '사수'
        ELSE '사원'
      END AS 구분  
FROM EMPLOYEE
;

-- 4) 과장 직급임에도 차장 직급의 최대 급여보다 더 많이 받는 직원들의 사번, 이름 , 직급명, 급여 조회

--차장 직급 급여
SELECT SALARY
FROM EMPLOYEE E
JOIN JOB J ON E.JOB_CODE = J.JOB_CODE
WHERE JOB_NAME = '차장'
;

SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE E
JOIN JOB J ON E.JOB_CODE = J.JOB_CODE
WHERE JOB_NAME = '과장'
AND SALARY > ALL
(
    SELECT SALARY
    FROM EMPLOYEE E
    JOIN JOB J ON E.JOB_CODE = J.JOB_CODE
    WHERE JOB_NAME = '차장'
)
;

/*
    <다중열 서브 쿼리>
        조회 결과 값은 한 행이지만, 나열된 칼럼 수가 여러개일 때
*/

-- 1) 하이유 사원과 같은 부서코드, 같은 직급코드에 해당하는 사원들 조회

-- 하이유 사원의 부서코드, 직급코드 조회 (D5, J5)
SELECT EMP_NAME, DEPT_CODE, JOB_CODE
FROM EMPLOYEE
WHERE EMP_NAME = '하이유'
;

-- 조건에 맞는 사원들 조회
SELECT EMP_NAME, DEPT_CODE, JOB_CODE
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
AND JOB_CODE = 'J5'
;

-- 각각 단일행 서브쿼리로 작성
SELECT EMP_NAME, DEPT_CODE, JOB_CODE
FROM EMPLOYEE
WHERE DEPT_CODE = 
(
    SELECT DEPT_CODE
    FROM EMPLOYEE
    WHERE EMP_NAME = '하이유'
)
AND JOB_CODE = 
(
    SELECT JOB_CODE
    FROM EMPLOYEE
    WHERE EMP_NAME = '하이유'
)
; 

-- 다중열 서브쿼리 사용
SELECT EMP_NAME, DEPT_CODE, JOB_CODE
FROM EMPLOYEE
WHERE (DEPT_CODE, JOB_CODE) IN 
(
    (
        SELECT DEPT_CODE, JOB_CODE
        FROM EMPLOYEE
        WHERE EMP_NAME = '하이유'
    )
)
;

-- 2) 박나라 사원과 직급 코드가 일치하면서 같은 사수를 가지고 있는 사원의
--      사번, 이름, 직급코드, 사수사번 조회

SELECT JOB_CODE, MANAGER_ID
FROM EMPLOYEE
WHERE EMP_NAME = '박나라'
;


SELECT EMP_ID, EMP_NAME, JOB_CODE, MANAGER_ID
FROM EMPLOYEE
WHERE (JOB_CODE,MANAGER_ID) IN 
(
    SELECT JOB_CODE, MANAGER_ID
    FROM EMPLOYEE
    WHERE EMP_NAME = '박나라'
)
;

/*
    <다중행 다중열 서브 쿼리>
        서브 쿼리의 결과값이 다중행 다중열
*/
-- 1. 각 직급별로 최소 급여를 받는 사원들의 사번, 이름 , 직급 코드 , 급여 조회
-- 각 직급별 최소 급여 조회
SELECT JOB_CODE, MIN(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE
;

SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE (JOB_CODE,SALARY) IN 
(  
    SELECT JOB_CODE, MIN(SALARY)
    FROM EMPLOYEE
    GROUP BY JOB_CODE
)
--WHERE JOB_CODE = 'J1' AND SALARY = 해당직급최소급여
--OR    JOB_CODE = 'J2' AND SALARY = 해당직급최소급여
--OR    JOB_CODE = 'J3' AND SALARY = 해당직급최소급여
;

-----------------------------------------------------------------
/*
    <인라인 뷰>
        FROM 절에 서브 쿼리를 제시하고, 서브쿼리를 수행한 결과를 테이블 대신 사용
*/


-- 급여가 높은 상위 5명 조회
SELECT ROWNUM, 사원명, 급여
FROM 
(
    SELECT EMP_NAME 사원명, SALARY 급여
    FROM EMPLOYEE E
    ORDER BY SALARY DESC
)
WHERE ROWNUM >= 2
;

-- 급여순 6~10 등 조회
SELECT *
FROM
(
    SELECT ROWNUM 순위, 사원명, 급여
    FROM 
    (
        SELECT EMP_NAME 사원명, SALARY 급여
        FROM EMPLOYEE E
        ORDER BY SALARY DESC
    )
)
--WHERE 순위 >= 6 AND 순위 <= 10
WHERE 순위 BETWEEN 6 AND 10
;





/*
    <RANK 함수>
        RANK() OVER(정렬기준) / DENSE_RANK() OVER(정렬기준) / 
        - 중복순위 이후 값 처리가 다름
        - 중복된 인원수 만큼 다음 순위를 + 해줄지 , 그냥 +1 할지
*/

SELECT 
    EMP_NAME
    , SALARY
    , DENSE_RANK() OVER(ORDER BY SALARY DESC) 순위
FROM EMPLOYEE
--WHERE RANK() OVER(ORDER BY SALARY DESC) <= 5 --WHERE 절 에서 사용 불가능
;















