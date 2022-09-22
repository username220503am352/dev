DROP TABLE MEMBER;
CREATE TABLE MEMBER
(
    MEMBER_ID       VARCHAR2(50)
    , MEMBER_PWD    VARCHAR2(100)
    , MEMBER_NICK   VARCHAR2(50)
    , ENROLL_DATE   TIMESTAMP DEFAULT SYSDATE
);

-- 이해 내용은 삭제할 것

INSERT INTO MEMBER
(
    MEMBER_ID
    , MEMBER_PWD
    , MEMBER_NICK
)
VALUES
(
    'user01'
    , '1234'
    , 'nick01'
)
;
rollback;

select * from member;

