--SELECT

/*
    <SELECT ��>
        [����]
            SELECT Į��1, Į��2, Į��3 .... Į��
            FROM ���̺��;
            
        - �����͸� ��ȸ�ϰ��� �� �� ���
        - SELECT �� ���ؼ� ��ȸ�� ����� RESULT SET �̶�� �Ѵ�. (��ȸ�� ����� ����)
        - ��ȸ�ϰ��� �ϴ� Į������ �ݵ�� FROM ���� ����� ���̺� �����ϴ� Į���̾�� �Ѵ�.
*/


-- EMP ���̺���, �����ȣ,����̸�,���� ��ȸ�ϱ�
SELECT EMPNO, ENAME, SAL FROM EMP;

-- EMP ���̺��� ��� Į�� ��ȸ�ϱ�
SELECT *
FROM EMP;

-- ��ҹ��� �������� ���� (���ʻ�, �빮�ڷ� ��)
select empno, ename 
from emp;

/*
    �������
        SELECT ���� Į���� �Է� �κп��� ��� ������ �̿��ؼ� ����� ��ȸ�� �� �ִ�.
*/

-- EMP ���̺��� �����̸�, �������� ��ȸ�ϱ�
SELECT ENAME , SAL * 12
FROM EMP;

-- NULL �� �����ص� NULL
SELECT ENAME, COMM * 12
FROM EMP;

-- ���� �� NULL���� �ϳ��� �ִٸ� NULL
SELECT ENAME, (SAL + COMM) * 12
FROM EMP;

-- DATE ����
SELECT ENAME, FLOOR(SYSDATE - HIREDATE)
FROM EMP;

-- Į���� ��Ī ����
SELECT ENAME, FLOOR(SYSDATE - HIREDATE) �ٹ��Ⱓ
FROM EMP;

-- ��ü ������ �̸�, 1��ġ (�޿�+COMM) ����Ͽ� ��ȸ
SELECT ENAME, (SAL + COMM) * 12 AS ���ҵ�
FROM EMP;


/*
    <���ͷ�>
        SELECT ���� ���ͷ��� ����ϸ� ���̺� �����ϴ� ������ó�� ��ȸ�� �����ϴ�.
        ���ͷ��� RESULT SET �� ��� �࿡ �ݺ� ��µȴ�.
*/
-- EMP ���̺��� ���, �̸�, �޿�(��) ��ȸ
SELECT EMPNO , ENAME , SAL , '�� �Դϴ�.' AS "����(����)"
FROM EMP;

/*
    <DISTINCT>
        Į���� ���Ե� �ߺ� ���� �ѹ����� ǥ���ϰ��� �� �� ����Ѵ�.
        SELECT ���� �ѹ��� ��� ����
        Į���� �������̸� Į�� ������ ��� �����ؾ� �ߺ� ������ �ǴܵǾ� �ߺ��� ���ŵȴ�.
*/

-- EMP ���̺��� ���� �� ��ȸ (�ߺ�����)
SELECT DISTINCT JOB FROM EMP;

SELECT DISTINCT JOB, DEPTNO FROM EMP;
--SELECT DISTINCT JOB, DISTINCT DEPTNO FROM EMP; -- �����߻� (DISTINCT �� �ѹ��� ��� ����)



/*
    <���� ������>
        ���� Į�� ���� �ϳ��� Į���ΰ�ó�� ���� �ϰų� �÷��� ���ͷ��� ������ �� �ִ�.
*/

-- EMP ���̺���, ���,�����,�޿� �� �����ؼ� ��ȸ
SELECT EMPNO || ENAME || SAL
FROM EMP;

-- EMP ���̺���, �����, �޿� �� ���ͷ��� �����Ͽ� ��ȸ
SELECT ENAME || ' �� ������ ' || SAL || ' �Դϴ�'
FROM EMP;


/*
    <WHERE ��>
        [����]
            SELECT Į��1, Į��2, ... Į��
            FROM ���̺��
            WHERE ���ǽ�;
            
        - ��ȸ�ϰ��� �ϴ� ���̺��� �ش� ���ǿ� �����ϴ� ������� ��ȸ�ϰ��� �� �� ����Ѵ�.
        - ���ǽĿ��� �پ��� �����ڵ��� ����� �� �ִ�.
        
    <�� ������>
        <, >, <=, >= : ��Һ�
        =            : �����
        != , ^=, <>  : �����ʴ�
*/

-- EMP ���̺��� �μ��ڵ尡 30�� ������� ��� Į�� ��ȸ
SELECT *
FROM EMP
WHERE DEPTNO = 30;

-- EMP ���̺��� �μ��ڵ尡 20�� �ƴ� ������� ���,�����,�μ��ڵ� ��ȸ
SELECT EMPNO, ENAME, DEPTNO
FROM EMP
WHERE DEPTNO != 20
;

-- EMP ���̺���, �޿��� 1000 �̻��� �������� �̸�,�μ��ڵ�,�޿� ��ȸ
SELECT ENAME, DEPTNO, SAL
FROM EMP
WHERE SAL >= 1000;


-- �ǽ�����
-- 1. EMP ���̺��� COMM �� 0 �ʰ��� ����� �̸�,�Ի���,�μ��ڵ� ��ȸ

-- 2. EMP ���̺��� �޿��� 1500 ������ ����� �̸�, �޿�, �μ��ڵ� ��ȸ















