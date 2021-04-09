
CREATE TABLE if not exists User
(
    seq bigint auto_increment comment '고객번호' primary key,
    email varchar(50) comment '이메일',
    name VARCHAR(20) comment '이름',
    job VARCHAR(20) comment '직업코드'
);

INSERT INTO User(email,name,job) VALUES ('absc@naver.com','일이삼','JB001');
INSERT INTO User(email,name,job) VALUES ('sdfss@kakao.com','제프','JB002');
INSERT INTO User(email,name,job) VALUES ('gggg@gmail.com','고골이','JB001');
INSERT INTO User(email,name,job) VALUES ('SONss@nate.com','손오공','JB005');