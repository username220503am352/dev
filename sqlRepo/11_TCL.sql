-- TCL (COMMIT, ROLLBACK)

/*
    <TCL(Transaction Control Language)>
        Ʈ������� �����ϴ� ����̴�.
        
        * Ʈ�����
          - �ϳ��� ������ �۾� ������ Ʈ������̶�� �Ѵ�.
          - ������ �۾����� ��� �ϳ��� �۾� ������ ����� ������ ���� Ʈ������̶�� �Ѵ�.
          - �ϳ��� Ʈ��������� �̷���� �۾����� �ݵ�� �Ѳ����� �Ϸᰡ �Ǿ�� �ϸ�, �׷��� ���� ��쿡�� �Ѳ����� ��ҵǾ�� �Ѵ�.
          - �������� ���� ����(DML(INSERT, UPDATE, DELETE))���� ��� �ϳ��� Ʈ����ǿ� ��� ó���Ѵ�.
          - COMMIT(Ʈ����� ���� ó�� �� ����), ROLLBACK(Ʈ����� ���), SAVEPOINT(�ӽ�����)�� ���ؼ� Ʈ������� �����Ѵ�.
*/
DROP TABLE BOARD;
CREATE TABLE BOARD(
    NO NUMBER
    , TITLE VARCHAR2(100)
);

-- COMMIT �� �ڵ����� �����

INSERT INTO BOARD VALUES(1, 'ù��°');
COMMIT;
INSERT INTO BOARD VALUES(2, '�ι�°');
INSERT INTO BOARD VALUES(3, '����°');

SELECT * FROM BOARD;

SAVEPOINT SP_INSERT; --3�� �� ���� �� ����

DELETE BOARD
WHERE NO=2
;

SAVEPOINT SP_DELETE; -- (1���� Ŀ��, 2,3���� SP) 3�� ���� �־�����, 2���� ������ �� ����

DELETE BOARD;

SELECT * FROM BOARD;

ROLLBACK TO SP_DELETE;
ROLLBACK;
ROLLBACK TO SP_INSERT;





























