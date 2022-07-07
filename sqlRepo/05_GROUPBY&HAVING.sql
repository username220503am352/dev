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




























































