
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