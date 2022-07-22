-- ������ SEQUENCE

/*
    <SEQUENCE>
        �������� ���������� �����ϴ� ������ �ϴ� ��ü�̴�.
        
    <SEQUENCE ����>
        [ǥ����]
            CREATE SEQUNCE ��������
            [START WITH ����]
            [INCREAMENT BY ����]
            [MAXVALUE ����]
            [MINVALUE ����]
            [CYCLE | NOCYCLE]
            [CACHE ����Ʈũ�� | NOCACHE]; (�⺻�� 20 ����Ʈ)
            
        [��� ����]
            ��������.CURRVAL : ���� �������� ��
            ��������.NEXTVAL : ������ ���� ������Ű�� ������ ������ ��
                              (���� ������ ������ INCREAMENT �� ��ŭ ������ ��)
                              
        * ĳ�ø޸�
          - �̸� ���� ������ �����ؼ� �����صд�.
          - �Ź� ȣ���� ������ ������ ���� ���� ������ �ϴ� ���� �ƴ� ĳ�� �޸� ������ �̸� ������ ������ ����Ѵ�.
*/

DROP SEQUENCE SEQ_MEMBER_NO;
CREATE SEQUENCE SEQ_MEMBER_NO
NOCACHE NOCYCLE
;

SELECT SEQ_MEMBER_NO.NEXTVAL FROM DUAL;
SELECT SEQ_MEMBER_NO.CURRVAL FROM DUAL;



--����

--��뿹��
DROP TABLE TB_MEMBER;
CREATE TABLE TB_MEMBER(
    NO NUMBER
    , ID VARCHAR2(100)
    , PWD VARCHAR2(100)
);

INSERT INTO TB_MEMBER VALUES(SEQ_MEMBER_NO.NEXTVAL, 'USER01', '1234');
SELECT * FROM TB_MEMBER;









