-- JOIN
/*
    <JOIN>
        �� �� �̻��� ���̺��� �����͸� ��ȸ�ϰ��� �� �� ���
        
        [����]
            1) ����Ŭ ���� ����
                SELECT Į��, Į��....
                FROM ���̺�1, ���̺�2 
                WHERE ���̺�1.Į�� = ���̺�2.Į��;
                
            -   FROM ���� ��ȸ�ϰ��� �ϴ� ���̺���� �޸��� �����Ͽ� ����
            -   WHERE ���� ��Ī ��ų Į���� ���� ���� ����
            
            2) ANSI ǥ�� ����
                SELECT Į��, Į��
                FROM ���̺�1
                JOIN ���̺�2
                ON ���̺�1.Į�� = ���̺�2.Į��;
                
            -   FROM ���� ������ �Ǵ� ���̺��� ���
            -   JOIN ���� ���� ��ȸ�ϰ��� �ϴ� ���̺� ��� �� ��Ī��ų Į���� ���� ���� ���
            -   ���ῡ ����Ϸ��� Į������ ���� ��� ON ���� ��� USING(Į��) ��� ����
*/

--ANSI ǥ��
SELECT ENAME , E.DEPTNO, DNAME
FROM EMP E
JOIN DEPT D
ON E.DEPTNO = D.DEPTNO
--USING(DEPTNO)
;

--ORACLE ����
SELECT ENAME, E.DEPTNO, DNAME
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO
;

/*
    2)
        ���� JOIN
            �������� ���̺� �����ϴ� ���
*/
CREATE TABLE LOCATION(
    LOCNO NUMBER
    , LOCNAME VARCHAR2(100)
    , LOCNAMEKOR VARCHAR2(100)
);

INSERT INTO LOCATION VALUES(1, 'NEW YORK', '����');
INSERT INTO LOCATION VALUES(2, 'DALLAS', '�޶�');
INSERT INTO LOCATION VALUES(3, 'CHICAGO', '��ī��');
INSERT INTO LOCATION VALUES(4, 'BOSTON', '������');

SELECT * FROM LOCATION;
COMMIT;

-- EMP, DEPT, LOCATION 3���� ���̺��� Ȱ���Ͽ�,
-- �����ȣ, �����, �μ��ڵ�, �μ��̸�, �μ���ġ, �μ���ġ(�ѱ�) ��ȸ
SELECT EMPNO, ENAME, E.DEPTNO, DNAME, LOC, LOCNAMEKOR
FROM EMP E
JOIN DEPT D ON E.DEPTNO = D.DEPTNO
JOIN LOCATION L ON D.LOC = L.LOCNAME
;

/*
    3) �ܺ����� (OUTTER JOIN)
        ���̺��� JOIN�� ��ġ���� �ʴ� �൵ ���Խ��Ѽ� ��ȸ ����
        ��, �ݵ�� ������ �Ǵ� ���̺��� �����ؾ� ��
*/

SELECT *
FROM EMP
;

-- EMP ���̺� ��� �Ѹ� �߰��ϱ�
-- EMPNO �� 9999, ENAME�� �����Ӱ�, JOB �� FREE , 
-- �Ŵ��� ����, �Ի����� ���ó�¥, ������ 1000, COMM ����, DEPTNO����
INSERT INTO EMP VALUES(9999, '�ɿ���', 'FREE', NULL, SYSDATE, 1000, NULL, NULL);
SELECT * FROM EMP;
COMMIT;

--ANSI
SELECT *
FROM EMP A
RIGHT JOIN DEPT B ON A.DEPTNO = B.DEPTNO
;

--ORACLE ���� 
SELECT *
FROM EMP A, DEPT B
WHERE A.DEPTNO(+) = B.DEPTNO
;

-- FULL OUTER JOIN : �� ���̺��� ������ ��� ���� ��ȸ ���� (ORACLE ������ �������� ����)
-- ANSI
SELECT *
FROM EMP A
FULL JOIN DEPT B ON A.DEPTNO = B.DEPTNO
;


/*
    4) �������� (CROSS JOIN)
        ���εǴ� ��� ���̺��� �� ����� ���μ��� ��� ���ε� �����Ͱ� �˻��ȴ�.
        ���̺��� ����� ��� ������ ����� ������ ���
*/

SELECT EMPNO, ENAME, DNAME
FROM EMP A
CROSS JOIN DEPT B
;


/*
    5. �� ����(NON EQUAL JOIN)
        ���� ���ǿ� ��ȣ(=)�� ������� �ʴ� ���ι��� �� �����̶�� �Ѵ�.
        ������ Į������ ��ġ�ϴ� ��찡 �ƴ�, ���� ������ ���ԵǴ� ����� �����ϴ� ���
        ( = �̿��� �� ������ �� ����Ѵ�.)
        ANSI �������δ� JOIN ON �� ��� ���� (USING ��� �Ұ�)
*/

SELECT * FROM SALGRADE;

SELECT *
FROM EMP A
JOIN SALGRADE B ON A.SAL > B.LOSAL
ORDER BY ENAME
;

/*
    6. ��������
        ���� ���̺��� �ٽ��ѹ� �����ϴ� ���
*/

SELECT A.EMPNO, A.ENAME �����, A.MGR, B.ENAME �����̸�
FROM EMP A
JOIN EMP B ON A.MGR = B.EMPNO
;
































