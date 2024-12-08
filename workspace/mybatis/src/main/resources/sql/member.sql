CREATE SEQUENCE SEQ_MEMBER;

CREATE TABLE TBL_MEMBER(
    ID NUMBER CONSTRAINT PK_MEMBER PRIMARY KEY,
    MEMBER_NAME VARCHAR2(255) NOT NULL,
    MEMBER_AGE NUMBER DEFAULT 0,
    MEMBER_EMAIL VARCHAR2(255) NOT NULL,
    MEMBER_PASSWORD VARCHAR2(255) NOT NULL,
    STATUS NUMBER DEFAULT 1
);

ALTER TABLE TBL_MEMBER ADD MEMBER_EMAIL VARCHAR2(255) DEFAULT 'test@gmail.com' NOT NULL;
ALTER TABLE TBL_MEMBER ADD MEMBER_PASSWORD VARCHAR2(255) DEFAULT '1234' NOT NULL;
ALTER TABLE TBL_MEMBER ADD STATUS NUMBER DEFAULT 1;

SELECT * FROM TBL_MEMBER;
