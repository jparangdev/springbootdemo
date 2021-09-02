
CREATE TABLE if not exists User
(
    seq bigint auto_increment comment '고객번호' primary key,
    email varchar(50) comment '이메일',
    name VARCHAR(20) comment '이름',
    password VARCHAR(20) comment '비밀번호',
    job VARCHAR(20) comment '직업코드'
);

INSERT INTO User(email,name,password,job) VALUES ('absc@naver.com','일이삼','1234','JB001');
INSERT INTO User(email,name,password,job) VALUES ('sdfss@kakao.com','제프','1234','JB002');
INSERT INTO User(email,name,password,job) VALUES ('gggg@gmail.com','고골이','1234','JB001');
INSERT INTO User(email,name,password,job) VALUES ('SONss1@nate.com','손오공1','1234','JB005');
INSERT INTO User(email,name,password,job) VALUES ('SONss2@nate.com','손오공2','1234','JB005');
INSERT INTO User(email,name,password,job) VALUES ('SONss3@nate.com','손오공3','1234','JB005');
INSERT INTO User(email,name,password,job) VALUES ('SONss4@nate.com','손오공4','1234','JB005');
INSERT INTO User(email,name,password,job) VALUES ('SONss5@nate.com','손오공5','1234','JB005');
INSERT INTO User(email,name,password,job) VALUES ('SONss6@nate.com','손오공6','1234','JB005');
INSERT INTO User(email,name,password,job) VALUES ('SONss7@nate.com','손오공7','1234','JB005');
INSERT INTO User(email,name,password,job) VALUES ('SONss8@nate.com','손오공8','1234','JB005');
INSERT INTO User(email,name,password,job) VALUES ('SONss9@nate.com','손오공9','1234','JB005');
INSERT INTO User(email,name,password,job) VALUES ('zkdltk@nate.com','카이사','1234','JB002');
INSERT INTO User(email,name,password,job) VALUES ('flffldk@nate.com','릴리아','1234','JB002');
INSERT INTO User(email,name,password,job) VALUES ('wkfmqks@nate.com','자르반','1234','JB002');
INSERT INTO User(email,name,password,job) VALUES ('wls@nate.com','진','1234','JB002');



CREATE TABLE if not exists Book
(
    seq bigint auto_increment comment '책번호' primary key,
    name varchar(50) comment '책이름',
    publisher_seq bigint comment '출판사',
    price int comment '가격'
);

INSERT INTO Book(name,publisher_seq,price) VALUES ('스프링책','1','20000');
INSERT INTO Book(name,publisher_seq,price) VALUES ('JPA책','1','34000');
INSERT INTO Book(name,publisher_seq,price) VALUES ('도커책','2','15000');
INSERT INTO Book(name,publisher_seq,price) VALUES ('자기계발서1','3','12000');
INSERT INTO Book(name,publisher_seq,price) VALUES ('자기계발서2','3','25000');


CREATE TABLE if not exists Book_Cart
(
    seq bigint auto_increment comment '시퀀스' primary key,
    user_seq bigint comment '고객번호',
    book_seq bigint comment '책번호'
);