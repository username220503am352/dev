--DML (INSERT , UPDATE , DELETE)

/*
    <DML(Data Manipulation Language)>
        ������ ���� ���� ���̺� ���� ����(INSERT)�ϰų�, ����(UPDATE), ����(DELETE)�ϴ� �����̴�.
    
    <INSERT>
        ���̺� ���ο� ���� �߰��ϴ� �����̴�.
        
        [����]
            1) INSERT INTO ���̺�� VALUES(��, ��, ��, ..., ��);
                ���̺� ��� Į���� ���� INSERT �ϰ��� �� �� ����Ѵ�.
                Į�� ������ ���Ѽ� VALUES�� ���� �����ؾ� �Ѵ�.
            2) INSERT INTO ���̺��(Į����, Į����, ..., Į����) VALUES(��, ��, ..., ��);
                ���̺� ���� ������ Į���� ���� ���� INSERT �ϰ��� �� �� ����Ѵ�.
                ������ �ȵ� Į������ �⺻������ NULL ���� ����. (NOT NULL ���������� �ɷ��ִ� Į���� �ݵ�� �����ؼ� ���� �����ؾ� �Ѵ�.)
                ��, �⺻��(DEFAULT)�� �����Ǿ� ������ NULL�� �ƴ� �⺻���� ����.
            3) INSERT INTO ���̺�� (��������);
                VALUES�� ����ؼ� ���� ������ ��ȸ�� ������� ��ä�� INSERT �Ѵ�.(��, �������� INSERT ��ų �� �ִ�.)
                ���� ������ ������� INSERT ���� ������ Į���� ������ ������ Ÿ���� ���ƾ� �Ѵ�.
*/


--1) ��� Į��
INSERT INTO EMPLOYEE 
VALUES('900', '����' , '901008-1080503' , 'you@kh.or.kr', '01055556666', 'D1', 'J7', 4000000, 0.2 , '200', SYSDATE, NULL, DEFAULT);

--2) Į�� ����
INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME, EMP_NO, JOB_CODE)
VALUES('901', '�ɿ���', '800923-1234567', 'J7');

--3) ��������

CREATE TABLE EMP_01(
    EMP_ID NUMBER
    , EMP_NAME VARCHAR2(30)
    , DEPT_TITLE VARCHAR2(35)
);

INSERT INTO EMP_01(EMP_ID, EMP_NAME, DEPT_TITLE) VALUES('777' , 'ȫ�浿', '�λ������');
INSERT INTO EMP_01(EMP_ID, EMP_NAME, DEPT_TITLE) VALUES('888' , '�̼���', '�λ������');

SELECT * FROM EMP_01;

INSERT INTO EMP_01
(
    SELECT E.EMP_ID, E.EMP_NAME, D.DEPT_TITLE
    FROM EMPLOYEE E
    LEFT OUTER JOIN DEPARTMENT D ON (E.DEPT_CODE = D.DEPT_ID)
)
;

DROP TABLE EMP_01;

/*
    <INSERT ALL>
        �� �� �̻��� ���̺� INSERT �ϴµ� ������ ���� ������ ���Ǵ� ���
        INSERT ALL�� �̿��ؼ� ���� ���̺� �� ���� ������ ������ �����ϴ�.
        
        [ǥ����]
            1) INSERT ALL
               INTO ���̺��1[(Į��, Į��, ...)] VALUES(��, ��, ...)
               INTO ���̺��2[(Į��, Į��, Į��, ...)] VALUES(��, ��, ��, ...)
               ���� ����;
               
            2) INSERT ALL
               WHEN ����1 THEN 
                   INTO ���̺��1[(Į��, Į��, ...)] VALUES(��, ��, ...)
               WHEN ����2 THEN     
                   INTO ���̺��2[(Į��, Į��, ...)] VALUES(��, ��, ...)
               ���� ����;
*/

--1)
-- �׽�Ʈ�� ���̺� �غ� (���̺� ������ ����)
DROP TABLE EMP_DEPT;
CREATE TABLE EMP_DEPT
AS
SELECT EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE 1=2
;

DROP TABLE EMP_MANAGER;
CREATE TABLE EMP_MANAGER
AS
SELECT EMP_ID, EMP_NAME, MANAGER_ID
FROM EMPLOYEE
WHERE 1=2
;

SELECT * FROM EMP_MANAGER;

-- INSERT ALL
INSERT ALL
INTO EMP_DEPT VALUES(EMP_ID,EMP_NAME,DEPT_CODE, HIRE_DATE)
INTO EMP_MANAGER VALUES(EMP_ID, EMP_NAME, MANAGER_ID)
    SELECT EMP_ID , EMP_NAME, DEPT_CODE, HIRE_DATE, MANAGER_ID
    FROM EMPLOYEE
    WHERE DEPT_CODE = 'D1';

SELECT * FROM EMP_DEPT;
SELECT * FROM EMP_MANAGER;

DROP TABLE EMP_DEPT;
DROP TABLE EMP_MANAGER;

--2)
-- ���̺� �غ�
CREATE TABLE EMP_OLD
AS 
SELECT EMP_ID , EMP_NAME, HIRE_DATE, SALARY
FROM EMPLOYEE
WHERE 1=2;

CREATE TABLE EMP_NEW
AS 
SELECT EMP_ID , EMP_NAME, HIRE_DATE, SALARY
FROM EMPLOYEE
WHERE 1=2;

--INSERT ALL
INSERT ALL
WHEN HIRE_DATE < '2000/01/01' THEN INTO EMP_OLD VALUES(EMP_ID , EMP_NAME, HIRE_DATE, SALARY)
WHEN HIRE_DATE >= '2000/01/01' THEN INTO EMP_NEW VALUES(EMP_ID , EMP_NAME, HIRE_DATE, SALARY)
SELECT EMP_ID, EMP_NAME, HIRE_DATE, SALARY
FROM EMPLOYEE;

SELECT * FROM EMP_OLD;
SELECT * FROM EMP_NEW;

--UPDATE
UPDATE EMP_OLD
SET 
SALARY = SALARY + 1
, EMP_NAME = '������'
WHERE EMP_NAME = '������'
;

--DELETE
DELETE EMP_OLD
--WHERE SALARY < 3000000 
;

/*
    <TRUNCATE>
        ���̺� ��ü �� ����(���� ���� �Ұ���)
        DELETE ���� ����
        ROLLBACK �Ұ���
*/

TRUNCATE TABLE EMP_NEW;
SELECT * FROM EMP_NEW;

DROP TABLE EMP_OLD;
DROP TABLE EMP_NEW;










