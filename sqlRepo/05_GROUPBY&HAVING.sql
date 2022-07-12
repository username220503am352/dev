-- 그룹

/*
    <GROUP BY>
        그룹 기준을 제시할 수 있는 구문
        여러개의 값들을 하나의 그룹으로 묶어서 처리할 목적으로 사용한다.
*/

-- EMP 테이블에서 전체 사원을 하나의 그룹으로 묶어서 월급 총합을 구한 결과 조회
SELECT SUM(SAL)
FROM EMP
;

-- 부서별 급여 총합
SELECT DEPTNO, SUM(SAL) AS 합계
FROM EMP
WHERE SAL > 2000
GROUP BY DEPTNO
ORDER BY 합계
;

-- EMP 테이블 중 직무(JOB) 별 급여 합계 조회
SELECT JOB 직무 , SUM(SAL) 직무별급여합계
FROM EMP
GROUP BY JOB
;

-- 각 부서별 COMM 을 받는 사원 수 (0도 받는것으로 처리)
SELECT DEPTNO, COUNT(COMM)
FROM EMP
GROUP BY DEPTNO
;

/*
    <HAVING>
        그룹에 대한 조건을 제시할 때 사용
*/

SELECT DEPTNO, SUM(SAL), COUNT(COMM)
FROM EMP
GROUP BY DEPTNO
HAVING SUM(SAL) > 10000
;

-- 각 부서별 평균 급여 조회 (단, 평균급여가 2000 이상인 경우만)
SELECT DEPTNO 부서번호 , FLOOR(AVG(SAL)) 평균급여
FROM EMP
GROUP BY DEPTNO
HAVING AVG(SAL) >= 2000
ORDER BY 부서번호
;

-- EMP 테이블에서 급여가 1000 이상인 사람들에 대하여, 부서별 급여 합계를 조회
SELECT DEPTNO 부서번호, SUM(SAL) 부서별급여합계
FROM EMP
WHERE SAL >= 1000
GROUP BY DEPTNO
;

-- 각 부서별, 보너스(COMM)를 받는 사원의 수 조회
SELECT COUNT(NULLIF(COMM, 0))
FROM EMP
GROUP BY DEPTNO
;


/*
    <집계 함수>
        그룹별 산출한 결과 값의 중간 집계를 계산 해주는 함수
        - CUBE
        - ROLLUP
        - GROUPING SETS
        
        - GROUPING
*/

SELECT DEPTNO, JOB, SUM(SAL)
FROM EMP
GROUP BY CUBE(DEPTNO, JOB)
ORDER BY DEPTNO
;

SELECT DEPTNO, JOB, SUM(SAL)
FROM EMP
GROUP BY GROUPING SETS(DEPTNO, JOB)
;


SELECT DEPTNO, JOB, SUM(SAL) , GROUPING(JOB), GROUPING(DEPTNO)
FROM EMP
GROUP BY GROUPING SETS(DEPTNO, JOB)
;


SELECT
    DEPTNO 부서구분
    , CASE
        WHEN DEPTNO = 10 THEN '영업1팀'
        WHEN DEPTNO = 20 THEN '개발본부'
        WHEN DEPTNO = 30 THEN '경영지원'
        ELSE '사장님'
      END 부서
--    , JOB
    , CASE
        WHEN GROUPING(JOB) = 1 THEN '모든직업'
        ELSE JOB
      END 직업구분
    , SUM(SAL)
FROM EMP
GROUP BY ROLLUP(DEPTNO, JOB)
ORDER BY DEPTNO
;
    

/*
    <집합 연산자>
        여러 개의 쿼리문을 가지고 하나의 쿼리문으로 만드는 연산자이다.
        
        UNION       : 합집합 : 두 쿼리문의 수행 결과를 합친 후, 중복 제거
        UNION ALL   : 합집합 : 두 쿼리문의 수행 결과를 합칩 (중복허용)
        INTERSECT   : 교집합 : 두 쿼리문 수행 결과 중복된 결과만 추출
        MINUS       : 차집합 : 선행 쿼리의 결과 중 후행 쿼리의 결과값을 뺀 나머지
*/

SELECT EMPNO, ENAME, DEPTNO, SAL
FROM EMP
WHERE SAL > 2000

MINUS

SELECT EMPNO, ENAME, DEPTNO, SAL
FROM EMP
WHERE SAL > 3000
;















































