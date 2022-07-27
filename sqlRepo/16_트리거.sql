-- TRIGGER 

/*
    <TRIGGER>
        ���̺��� INSERT, UPDATE, DELETE �� DML ������ ���ؼ� ����� ���
        �ڵ����� ����� ������ �����س��� ��ü�̴�.
        
        * Ʈ������ ����
          1) SQL ���� ���� �ñ⿡ ���� �з�
            - BEFORE TRIGGER : �ش� SQL ���� ���� ���� Ʈ���Ÿ� �����Ѵ�.
            - AFTER TRIGGER : �ش� SQL ���� ���� �Ŀ� Ʈ���Ÿ� �����Ѵ�.
          
          2) SQL ���� ���� ������ �޴� �࿡ ���� �з�
            - ���� Ʈ���� : �ش� SQL ���� �� ���� Ʈ���Ÿ� �����Ѵ�.
            - �� Ʈ���� : �ش� SQL ���� ������ �޴� �ึ�� Ʈ���Ÿ� �����Ѵ�.
            
        [����]
            CREATE OR REPLACE TRIGGER Ʈ���Ÿ�
            BEFORE|AFTER INSERT|UPDATE|DELETE ON ���̺��
            [FOR EACH ROW]
            DECLARE
                �����
            BEGIN
                �����
            EXCEPTION
                ����ó����
            END;
            /
*/


SELECT * FROM EMPLOYEE;

SET SERVEROUTPUT ON;

-- ���� Ʈ����
CREATE OR REPLACE TRIGGER TRG_01
AFTER UPDATE ON EMPLOYEE
BEGIN
    DBMS_OUTPUT.PUT_LINE('������Ʈ �����');
END;
/

UPDATE EMPLOYEE 
SET SALARY = 12345
WHERE EMP_ID = 901
;

-- �� Ʈ����
CREATE OR REPLACE TRIGGER TRG_02
AFTER UPDATE ON EMPLOYEE
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('���� �� : ' || :OLD.SALARY || ', ���� �� : ' || :NEW.SALARY);
END;
/

UPDATE EMPLOYEE 
SET SALARY = 33333
WHERE DEPT_CODE = 'D1'
;
































