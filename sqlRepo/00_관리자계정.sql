select sysdate from dual;

--����� ���� ����
CREATE USER C##KH IDENTIFIED BY KH;
--���� �ο�
GRANT CONNECT, RESOURCE TO C##KH;

--���̺����̽� users ���Ѻο�
ALTER USER C##KH DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;




