-- �׷�

/*
    <GROUP BY>
        �׷� ������ ������ �� �ִ� ����
        �������� ������ �ϳ��� �׷����� ��� ó���� �������� ����Ѵ�.
*/

-- EMP ���̺��� ��ü ����� �ϳ��� �׷����� ��� ���� ������ ���� ��� ��ȸ
SELECT SUM(SAL)
FROM EMP
;

-- �μ��� �޿� ����
SELECT DEPTNO, SUM(SAL) AS �հ�
FROM EMP
WHERE SAL > 2000
GROUP BY DEPTNO
ORDER BY �հ�
;

-- EMP ���̺� �� ����(JOB) �� �޿� �հ� ��ȸ
SELECT JOB ���� , SUM(SAL) �������޿��հ�
FROM EMP
GROUP BY JOB
;

-- �� �μ��� COMM �� �޴� ��� �� (0�� �޴°����� ó��)
SELECT DEPTNO, COUNT(COMM)
FROM EMP
GROUP BY DEPTNO
;

/*
    <HAVING>
        �׷쿡 ���� ������ ������ �� ���
*/

SELECT DEPTNO, SUM(SAL), COUNT(COMM)
FROM EMP
GROUP BY DEPTNO
HAVING SUM(SAL) > 10000
;

-- �� �μ��� ��� �޿� ��ȸ (��, ��ձ޿��� 2000 �̻��� ��츸)
SELECT DEPTNO �μ���ȣ , FLOOR(AVG(SAL)) ��ձ޿�
FROM EMP
GROUP BY DEPTNO
HAVING AVG(SAL) >= 2000
ORDER BY �μ���ȣ
;

-- EMP ���̺��� �޿��� 1000 �̻��� ����鿡 ���Ͽ�, �μ��� �޿� �հ踦 ��ȸ
SELECT DEPTNO �μ���ȣ, SUM(SAL) �μ����޿��հ�
FROM EMP
WHERE SAL >= 1000
GROUP BY DEPTNO
;

-- �� �μ���, ���ʽ�(COMM)�� �޴� ����� �� ��ȸ
SELECT COUNT(NULLIF(COMM, 0))
FROM EMP
GROUP BY DEPTNO
;


/*
    <���� �Լ�>
        �׷캰 ������ ��� ���� �߰� ���踦 ��� ���ִ� �Լ�
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
    DEPTNO �μ�����
    , CASE
        WHEN DEPTNO = 10 THEN '����1��'
        WHEN DEPTNO = 20 THEN '���ߺ���'
        WHEN DEPTNO = 30 THEN '�濵����'
        ELSE '�����'
      END �μ�
--    , JOB
    , CASE
        WHEN GROUPING(JOB) = 1 THEN '�������'
        ELSE JOB
      END ��������
    , SUM(SAL)
FROM EMP
GROUP BY ROLLUP(DEPTNO, JOB)
ORDER BY DEPTNO
;
    

/*
    <���� ������>
        ���� ���� �������� ������ �ϳ��� ���������� ����� �������̴�.
        
        UNION       : ������ : �� �������� ���� ����� ��ģ ��, �ߺ� ����
        UNION ALL   : ������ : �� �������� ���� ����� ��Ĩ (�ߺ����)
        INTERSECT   : ������ : �� ������ ���� ��� �ߺ��� ����� ����
        MINUS       : ������ : ���� ������ ��� �� ���� ������ ������� �� ������
*/

SELECT EMPNO, ENAME, DEPTNO, SAL
FROM EMP
WHERE SAL > 2000

MINUS

SELECT EMPNO, ENAME, DEPTNO, SAL
FROM EMP
WHERE SAL > 3000
;















































