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




























































