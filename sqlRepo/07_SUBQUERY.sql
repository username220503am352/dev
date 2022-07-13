-- ��������

/*
    <SUBQUERY>
        �ϳ��� SQL �� �ȿ� ���Ե� �� �ٸ� SQL��
        ���� ����(���� ����) �� �����ϴ� ����
*/

-- �������� ����

-- ���ö ����� �μ��ڵ� ��ȸ --D9
SELECT EMP_NAME, DEPT_CODE
FROM EMPLOYEE
WHERE EMP_NAME = '���ö';

-- ���ö ����� �μ��ڵ尡 ���� ������� ��ȸ
SELECT EMP_NAME , DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE = (
    SELECT DEPT_CODE
    FROM EMPLOYEE
    WHERE EMP_NAME = '���ö'
);

/*
    <���� ���� ����>
        ���� ������ ���� ������ ������ ����� ��� ���� ������ ���� �з�
        
        1) ������ ���� ����        : ���� ������ ��ȸ��� ���� ��� ���� ������ 1�� �� ��
        2) ������ ���� ����        : ���� ������ ��ȸ��� ���� ���� ������ ������ �� ��
        3) ���߿� ���� ����        : ���� ������ ��ȸ��� ���� �� ��������, Į���� ������ �� ��
        4) ������, ���߿� ���� ���� : ���� ������ ��ȸ��� ���� ������, ������ �� ��
        
        * ���� ������ ������ ���� �������� �տ� �ٴ� �����ڰ� �޶�����.
*/

/*
    <������ ��������>
        ���������� ��ȸ ��� ���� ��� ���� ������ 1�� �� ��
        �� ������ ��� ����
*/

-- 1) �� ������ ��� �޿����� �޿��� ���� �޴� �������� �̸�, �����ڵ�, �޿� ��ȸ

-- �� ���� ��� �޿�
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


-- 2) ���� �޿��� �޴� ������ ���, �̸�, �����ڵ�, �޿�, �Ի��� ��ȸ
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

-- 3) ���ö ����� �޿����� �� ���� �޿��� �޴� ������� ���, �����, �μ���, �����ڵ�, �޿� ��ȸ

SELECT SALARY
FROM EMPLOYEE
WHERE EMP_NAME = '���ö'
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
    WHERE EMP_NAME = '���ö'
)
;

-- 4) �μ��� �޿��� ���� ���� ū �μ��� �μ��ڵ�, �޿��� �� ��ȸ
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

-- 5) ������ ����� �����ִ� �μ����� ��ȸ (������ ����� ����)
-- ���, �����, ��ȭ��ȣ, ���޸�, �μ���, �Ի��� 

-- ������ ��� �μ��ڵ� ��ȸ
SELECT DEPT_CODE
FROM EMPLOYEE
WHERE EMP_NAME = '������';


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
    WHERE EMP_NAME = '������'
)
AND EMP_NAME != '������'
;

/*
    <������ ���� ����>
        ���� ������ ��ȸ������� ���� ������ ���� �� �� ��
        
        IN / NOT IN (��������) : �������� ����� �߿��� �Ѱ��� ��ġ�Ѵٸ� TRUE ����
        ANY: �������� ���� �� �Ѱ��� �����ϸ� TRUE, IN �� �ٸ����� �� �����ڸ� �Բ� ����Ѵٴ� ��
            ANY(100, 200, 300)
            SALARY = ANY(...) : IN �� ���� ���
            SALARY != ANY(...) : NOT IN �� ���� ���
            SALARY > ANY(...) : �ּҰ� ���� ũ�� TRUE
            SALARY < ANY(...) : �ִ밪 ���� ������ TRUE
        ALL: �������� ���� ��ο� ���Ͽ� �����ؾ� TRUE , IN �� �ٸ����� �� �����ڸ� �Բ� ����Ѵٴ� ��
            ALL(100,200,300)
            SALARY > ALL(...) : �ִ밪 ���� ũ�� TRUE
            SALARY < ALL(...) : �ּҰ� ���� ������ TRUE
*/

-- 1) �� �μ��� �ְ� �޿��� �޴� ������ �̸�, ���� �ڵ�, �μ� �ڵ�, �޿� ��ȸ
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

-- 2) �� �����鿡 ���� ���, �̸�, �μ��ڵ�, ����(���/���)

-- ����� �ش��ϴ� ��� ��ȸ --
SELECT DISTINCT MANAGER_ID
FROM EMPLOYEE
WHERE MANAGER_ID IS NOT NULL
;


-- ��� ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_CODE , '���' ����
FROM EMPLOYEE
WHERE EMP_ID IN 
(
    SELECT DISTINCT MANAGER_ID
    FROM EMPLOYEE
    WHERE MANAGER_ID IS NOT NULL
)

UNION

-- ��� ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_CODE , '���' ����
FROM EMPLOYEE
WHERE EMP_ID NOT IN 
(
    SELECT DISTINCT MANAGER_ID
    FROM EMPLOYEE
    WHERE MANAGER_ID IS NOT NULL
)
;


-- SELECT ���� �������� ���
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
        ) THEN '���'
        ELSE '���'
      END AS ����  
FROM EMPLOYEE
;

-- 4) ���� �����ӿ��� ���� ������ �ִ� �޿����� �� ���� �޴� �������� ���, �̸� , ���޸�, �޿� ��ȸ

--���� ���� �޿�
SELECT SALARY
FROM EMPLOYEE E
JOIN JOB J ON E.JOB_CODE = J.JOB_CODE
WHERE JOB_NAME = '����'
;

SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE E
JOIN JOB J ON E.JOB_CODE = J.JOB_CODE
WHERE JOB_NAME = '����'
AND SALARY > ALL
(
    SELECT SALARY
    FROM EMPLOYEE E
    JOIN JOB J ON E.JOB_CODE = J.JOB_CODE
    WHERE JOB_NAME = '����'
)
;

/*
    <���߿� ���� ����>
        ��ȸ ��� ���� �� ��������, ������ Į�� ���� �������� ��
*/

-- 1) ������ ����� ���� �μ��ڵ�, ���� �����ڵ忡 �ش��ϴ� ����� ��ȸ

-- ������ ����� �μ��ڵ�, �����ڵ� ��ȸ (D5, J5)
SELECT EMP_NAME, DEPT_CODE, JOB_CODE
FROM EMPLOYEE
WHERE EMP_NAME = '������'
;

-- ���ǿ� �´� ����� ��ȸ
SELECT EMP_NAME, DEPT_CODE, JOB_CODE
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
AND JOB_CODE = 'J5'
;

-- ���� ������ ���������� �ۼ�
SELECT EMP_NAME, DEPT_CODE, JOB_CODE
FROM EMPLOYEE
WHERE DEPT_CODE = 
(
    SELECT DEPT_CODE
    FROM EMPLOYEE
    WHERE EMP_NAME = '������'
)
AND JOB_CODE = 
(
    SELECT JOB_CODE
    FROM EMPLOYEE
    WHERE EMP_NAME = '������'
)
; 

-- ���߿� �������� ���
SELECT EMP_NAME, DEPT_CODE, JOB_CODE
FROM EMPLOYEE
WHERE (DEPT_CODE, JOB_CODE) IN 
(
    (
        SELECT DEPT_CODE, JOB_CODE
        FROM EMPLOYEE
        WHERE EMP_NAME = '������'
    )
)
;

-- 2) �ڳ��� ����� ���� �ڵ尡 ��ġ�ϸ鼭 ���� ����� ������ �ִ� �����
--      ���, �̸�, �����ڵ�, ������ ��ȸ

SELECT JOB_CODE, MANAGER_ID
FROM EMPLOYEE
WHERE EMP_NAME = '�ڳ���'
;


SELECT EMP_ID, EMP_NAME, JOB_CODE, MANAGER_ID
FROM EMPLOYEE
WHERE (JOB_CODE,MANAGER_ID) IN 
(
    SELECT JOB_CODE, MANAGER_ID
    FROM EMPLOYEE
    WHERE EMP_NAME = '�ڳ���'
)
;

/*
    <������ ���߿� ���� ����>
        ���� ������ ������� ������ ���߿�
*/
-- 1. �� ���޺��� �ּ� �޿��� �޴� ������� ���, �̸� , ���� �ڵ� , �޿� ��ȸ
-- �� ���޺� �ּ� �޿� ��ȸ
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
--WHERE JOB_CODE = 'J1' AND SALARY = �ش������ּұ޿�
--OR    JOB_CODE = 'J2' AND SALARY = �ش������ּұ޿�
--OR    JOB_CODE = 'J3' AND SALARY = �ش������ּұ޿�
;

-----------------------------------------------------------------
/*
    <�ζ��� ��>
        FROM ���� ���� ������ �����ϰ�, ���������� ������ ����� ���̺� ��� ���
*/


-- �޿��� ���� ���� 5�� ��ȸ
SELECT ROWNUM, �����, �޿�
FROM 
(
    SELECT EMP_NAME �����, SALARY �޿�
    FROM EMPLOYEE E
    ORDER BY SALARY DESC
)
WHERE ROWNUM >= 2
;

-- �޿��� 6~10 �� ��ȸ
SELECT *
FROM
(
    SELECT ROWNUM ����, �����, �޿�
    FROM 
    (
        SELECT EMP_NAME �����, SALARY �޿�
        FROM EMPLOYEE E
        ORDER BY SALARY DESC
    )
)
--WHERE ���� >= 6 AND ���� <= 10
WHERE ���� BETWEEN 6 AND 10
;





/*
    <RANK �Լ�>
        RANK() OVER(���ı���) / DENSE_RANK() OVER(���ı���) / 
        - �ߺ����� ���� �� ó���� �ٸ�
        - �ߺ��� �ο��� ��ŭ ���� ������ + ������ , �׳� +1 ����
*/

SELECT 
    EMP_NAME
    , SALARY
    , DENSE_RANK() OVER(ORDER BY SALARY DESC) ����
FROM EMPLOYEE
--WHERE RANK() OVER(ORDER BY SALARY DESC) <= 5 --WHERE �� ���� ��� �Ұ���
;















