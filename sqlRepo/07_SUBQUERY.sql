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


























