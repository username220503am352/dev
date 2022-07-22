-- DDL (CREATE)

/*
    DDL
        ������ ���� ���
        ��ü ����, ����, ���� ��
        ���� ������ ���� �ƴ�, �������� ���� ��ü�� �����ϴ� ���
        
        * ����Ŭ ��ü : ���̺�, ��, ������, �ε���, Ʈ����, ���ν���, �Լ�, ����� ��...
*/

--DROP TABLE TB_MEMBER;
CREATE TABLE TB_MEMBER(
    ID VARCHAR2(30)
    , PWD VARCHAR2(100)
    , NAME VARCHAR2(20)
    , ENROLL_DATE TIMESTAMP DEFAULT SYSDATE
);

DESC TB_MEMBER;
SELECT * FROM TB_MEMBER;

COMMENT ON COLUMN TB_MEMBER.ID IS 'ȸ�����̵�';

/*
    �������� (CONSTRAINT)
        ����ڰ� ���ϴ� ������ �����͸� �����ϱ� ���ؼ� ���
        ������ ���Ἲ ������ �������� �� (��Ȯ��, �ϰ��� ����)
        
        * NOT NULL, UNIQUE, CHECK, PRIMARY KEY, FOREIGN KEY
*/

-- ���� ���� Ȯ��
DESC USER_CONSTRAINTS;
SELECT * FROM USER_CONSTRAINTS;
SELECT * FROM USER_CONSTRAINTS WHERE OWNER = 'C##KH';

-- ���������� �ɸ� Į�� ��ȸ
DESC USER_CONS_COLUMNS;
SELECT * FROM USER_CONS_COLUMNS;

-- NOT NULL : �ش� Į���� �ݵ�� ���� �־�� �ϴ� ���
INSERT INTO TB_MEMBER VALUES(NULL, NULL, NULL, NULL);
SELECT * FROM TB_MEMBER;

-- ���̺� ����
--DROP TABLE TB_MEMBER;
CREATE TABLE TB_MEMBER(
    ID VARCHAR2(30) NOT NULL
    , PWD VARCHAR2(100) NOT NULL
    , NAME VARCHAR2(20) NOT NULL
    , ENROLL_DATE TIMESTAMP DEFAULT SYSDATE
);

-- ���̺� ����
--DROP TABLE TB_MEMBER;
CREATE TABLE TB_MEMBER(
    ID VARCHAR2(30) NOT NULL UNIQUE
    , PWD VARCHAR2(100) NOT NULL UNIQUE
    , NAME VARCHAR2(20) NOT NULL UNIQUE
    , ENROLL_DATE TIMESTAMP DEFAULT SYSDATE
);

INSERT INTO TB_MEMBER (ID, PWD, NAME) VALUES('USER01', '1234' , 'SWY');
SELECT * FROM TB_MEMBER;


-- ���̺� ����
DROP TABLE TB_MEMBER;
CREATE TABLE TB_MEMBER(
    ID VARCHAR2(30) CONSTRAINT MEMBER_ID_NN NOT NULL
    , PWD VARCHAR2(100) 
    , NAME VARCHAR2(20) CONSTRAINT MEMBER_NAME_UQ UNIQUE
    , ENROLL_DATE TIMESTAMP DEFAULT SYSDATE
);

INSERT INTO TB_MEMBER (ID, PWD, NAME) VALUES('ZZZ', '1234' , 'SWY');
SELECT * FROM TB_MEMBER;


-- ���̺� ����
DROP TABLE TB_MEMBER;
CREATE TABLE TB_MEMBER(
    ID VARCHAR2(30) CONSTRAINT MEMBER_ID_NN NOT NULL
    , PWD VARCHAR2(100) 
    , NAME VARCHAR2(20)
    , ENROLL_DATE TIMESTAMP DEFAULT SYSDATE
    , CONSTRAINT MEMBER_ID_PWD_NAME_UQ UNIQUE(ID , PWD, NAME)
);

INSERT INTO TB_MEMBER (ID, PWD, NAME) VALUES('ZZZ', '4321' , 'SWY');
SELECT * FROM TB_MEMBER;

INSERT INTO TB_MEMBER (ID, PWD, NAME, ENROLL_DATE) VALUES('USER01', '1234' , 'NAME01', DEFAULT);
SELECT * FROM TB_MEMBER;

DROP TABLE TB_MEMBER;


-- CHECK ��������
DROP TABLE STUDENT;
CREATE TABLE STUDENT(
    NO NUMBER CONSTRAINT NNNNN CHECK(NO > 0)
    , NICK VARCHAR2(100) NOT NULL
    , NAME VARCHAR2(100) 
    , GENDER CHAR(1) CONSTRAINT ZZZ CHECK(GENDER IN ('M' , 'F'))
    , CONSTRAINT ABC CHECK (NAME != NICK)
);

INSERT INTO STUDENT VALUES(1, '�ɿ���', '�ɿ���', 'M');
INSERT INTO STUDENT VALUES(1, '�ɿ���', 'X');
SELECT * FROM STUDENT;


-- �⺻Ű

/*
    <�⺻Ű>
        ���̺��� �� ���� ������ �ĺ��ϱ� ���� ����� �÷��� �ο��ϴ� ��������
        �� ����� ������ �� �ִ� �ĺ���
        �⺻ Ű �������� ���� ��, �ڵ����� NOT NULL + UNIQUE ������ ������
        �� ���̺� �Ѱ��� ������ �� �ִ�. (�������� Į���� ��� �⺻Ű�� ���� ����)
        �÷� ����, ���̺��� ���� ��� ����
*/

DROP TABLE TB_MEMBER;

CREATE TABLE TB_MEMBER(
    ID VARCHAR2(100) PRIMARY KEY
    , PWD VARCHAR2(100)
    , NICK VARCHAR2(100)
);

INSERT INTO TB_MEMBER VALUES(NULL, '1234', 'NICK01');


DROP TABLE TB_MEMBER;

CREATE TABLE TB_MEMBER(
    ID VARCHAR2(100)
    , PWD VARCHAR2(100)
    , NICK VARCHAR2(100)
    , CONSTRAINT MEMBER_PK_ID_PWD PRIMARY KEY(ID,PWD) --����Ű
);

INSERT INTO TB_MEMBER VALUES(NULL, '1234', 'NICK01');
INSERT INTO TB_MEMBER VALUES('USER01', NULL, 'NICK01');

INSERT INTO TB_MEMBER VALUES('USER01', '4321', 'NICK01');


/*
    <�ܷ�Ű>
        �ٸ� ���̺� �����ϴ� ������ �����;� �ϴ�Į���� �ο� (NULL ����)
        
        [����]
            1) Į�� ����
                Į���� �ڷ���(ũ��) [CONSTRAINT �������߸�] REFERENCES �������̺�� [(�⺻Ű)] [������]
                
            2) ���̺� ����
                [CONSTRAINT �������Ǹ�] FOREIGN KEY(Į����) REFERENCES �������̺�� [(�⺻Ű)] [������]
                
        [������]
            �θ����̺��� �����Ͱ� �������� �� �ɼ�
            1) ON DELETE RESTRICT   : 
                �ڽ� ���̺��� ���� Ű�� �θ� ���̺��� Ű ���� �����ϴ� ���,
                �θ� ���̺������� ������ �� ����. (�⺻�ɼ�)
            2) ON DELETE SET NULL   :
                �θ����̺��� ������ ���� ��, �����ϰ� �ִ� �ڽ� ���̺��� Į�� ���� NULL �� ����
            3) ON DELETE CASCADE    :
                �θ����̺��� ������ ���� ��, �����ϰ� �ִ� �ڽ� ���̺��� Į�� ���� �����ϴ� �� ��ü ����
*/


DROP TABLE STUDENT;
CREATE TABLE STUDENT(
    NO NUMBER PRIMARY KEY
    , NAME VARCHAR2(100) NOT NULL
);

DROP TABLE SCORE;
CREATE TABLE SCORE(
    STD_NO NUMBER REFERENCES STUDENT--(NO) --ON DELETE CASCADE
    , SCORE NUMBER NOT NULL
);

INSERT INTO STUDENT(NO, NAME) VALUES(1, '�Ϲ��л�');
INSERT INTO STUDENT(NO, NAME) VALUES(2, '�̹��л�');
INSERT INTO STUDENT(NO, NAME) VALUES(3, '����л�');
SELECT * FROM STUDENT;

INSERT INTO SCORE(STD_NO, SCORE) VALUES(1, 100);
INSERT INTO SCORE(STD_NO, SCORE) VALUES(2, 90);
INSERT INTO SCORE(STD_NO, SCORE) VALUES(3, 80);
SELECT * FROM SCORE;

INSERT INTO SCORE(STD_NO, SCORE) VALUES(5, 99);

DELETE STUDENT WHERE NO = 1;




























