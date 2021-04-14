DROP TABLE IF EXISTS order_items CASCADE;
DROP TABLE IF EXISTS orders CASCADE;
DROP TABLE IF EXISTS bookmarked_stores CASCADE;
DROP TABLE IF EXISTS stores CASCADE;
DROP TABLE IF EXISTS users CASCADE;

CREATE TABLE users
(
    id            bigint      NOT NULL AUTO_INCREMENT, --사용자 PK
    name          varchar(10) NOT NULL,                --사용자명
    email         varchar(50) NOT NULL,                --로그인 이메일
    passwd        varchar(90) NOT NULL,                --로그인 비밀번호
    login_count   int         NOT NULL DEFAULT 0,      --로그인 횟수 (로그인시 마다 1 증가)
    last_login_at datetime             DEFAULT NULL,   --최종로그인 시각
    created_at    datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP(),
    PRIMARY KEY (id),
    UNIQUE KEY unq_user_email (email)
);

CREATE TABLE stores
(
    id         bigint      NOT NULL AUTO_INCREMENT, --상점 PK
    name       varchar(20) NOT NULL,                --상점명
    state      enum ('HIDDEN','NORMAL') DEFAULT 'NORMAL' NOT NULL,
    off_day    int         NOT NULL,                --휴무요일 (월:1,화:2,수:3,목:4,금:5,토:6,일:7)
    run24      bool        NOT NULL,                --true 라면, 24시간영업 (open_time,close_time 미사용)
    open_time  int         NOT NULL,                --영업시작시각 (0~1439,예:9시=9*60=540)
    close_time int         NOT NULL,                --영업종료시각 (0~1439,예:10시20분=10*60+20=620)
    created_at datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP(),
    PRIMARY KEY (id)
);

CREATE TABLE bookmarked_stores
(
    id         bigint   NOT NULL AUTO_INCREMENT, --상점 즐겨찾기 PK
    user_id    bigint   NOT NULL,                --사용자 PK
    store_id   bigint   NOT NULL,                --상점 PK
    created_at datetime NOT NULL DEFAULT CURRENT_TIMESTAMP(),
    PRIMARY KEY (id),
    UNIQUE KEY unq_user_store (user_id, store_id),
    CONSTRAINT fk_bookmark_to_users FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT fk_bookmark_to_stores FOREIGN KEY (store_id) REFERENCES stores (id) ON DELETE RESTRICT ON UPDATE RESTRICT
);

CREATE TABLE orders
(
    id           bigint   NOT NULL AUTO_INCREMENT, --주문 PK
    user_id      bigint   NOT NULL,                --사용자 PK
    store_id     bigint   NOT NULL,                --상점 PK
    state        enum ('NEW','COMPLETE','CANCEL') DEFAULT 'NEW' NOT NULL,
    cancel_msg   varchar(512)      DEFAULT NULL,   --취소요청 메시지
    canceled_at  datetime          DEFAULT NULL,   --취소된 날짜
    completed_at datetime          DEFAULT NULL,   --완료된 날짜
    created_at   datetime NOT NULL DEFAULT CURRENT_TIMESTAMP(),
    PRIMARY KEY (id),
    INDEX        idx_user_id_created_at (user_id, created_at),
    CONSTRAINT fk_orders_to_users FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT fk_orders_to_stores FOREIGN KEY (store_id) REFERENCES stores (id) ON DELETE RESTRICT ON UPDATE RESTRICT
);

CREATE TABLE order_items
(
    id         bigint      NOT NULL AUTO_INCREMENT, --주문아이템 PK
    order_id   bigint      NOT NULL,                --주문 PK
    name       varchar(50) NOT NULL,                --아이템명
    unit_price int         NOT NULL,                --개별가격
    unit_count int         NOT NULL,                --갯수 (총금액=갯수*개별가격)
    PRIMARY KEY (id),
    CONSTRAINT fk_order_items_to_orders FOREIGN KEY (order_id) REFERENCES orders (id) ON DELETE RESTRICT ON UPDATE RESTRICT
);

--User 데이터 생성
INSERT INTO users(id, name, email, passwd)
VALUES (null, 'tester', 'tester@gmail.com',
        '1ARVn2Auq2/WAqx2gNrL+q3RNjAzXpUfCXrzkA6d4Xa22yhRLy4AC50E+6UTPoscbo31nbOoq51gvkuXzJ6B2w==') -- user id 1 (비밀번호:1234)
;
--STORE 데이터 생성
INSERT INTO stores(id, name, state, off_day, run24, open_time, close_time)
VALUES (null, 'Normal Store1', 'NORMAL', 7, false, 540, 1080), -- store id 1
       (null, 'Hidden Store', 'HIDDEN', 7, false, 540, 1080),  -- store id 2
       (null, 'Normal Store2', 'NORMAL', 1, true, 0, 0)        -- store id 3
;
--STORE BOOKMARK 데이터 생성
INSERT INTO bookmarked_stores(id, user_id, store_id)
VALUES (null, 1, 1), -- bookmarked store id 1
       (null, 1, 2)  -- bookmarked store id 2
;
--ORDER 데이터 생성
INSERT INTO orders(id, user_id, store_id, state, cancel_msg, canceled_at, completed_at, created_at)
VALUES --orders for store1
       (null, 1, 1, 'NEW', null, null, null, '2021-03-01 09:00:00'),                                  -- order id 1
       (null, 1, 1, 'CANCEL', 'expensive price', '2021-03-01 12:30:00', null, '2021-03-01 12:00:00'), -- order id 2
       (null, 1, 1, 'COMPLETE', null, null, '2021-03-03 12:30:00', '2021-03-01 10:30:00'),            -- order id 3
       --orders for store3
       (null, 1, 3, 'NEW', null, null, null, '2021-03-02 11:00:00'),                                  -- order id 4
       (null, 1, 3, 'COMPLETE', null, null, '2021-03-03 12:30:00', '2021-03-03 09:00:00')             -- order id 5
;
--ORDER ITEM 데이터 생성
INSERT INTO order_items(id, order_id, name, unit_price, unit_count)
VALUES --items for order1
       (null, 1, 'MENU-A', 10000, 2), -- order item id 1
       (null, 1, 'MENU-B', 5000, 3),  -- order item id 2
       --items for order2
       (null, 2, 'MENU-A', 10000, 1), -- order item id 3
       --items for order3
       (null, 3, 'MENU-C', 15000, 1), -- order item id 4
       (null, 3, 'MENU-D', 20000, 1), -- order item id 5
       (null, 3, 'MENU-E', 5000, 2),  -- order item id 6
       --items for order4
       (null, 4, 'MENU-F', 30000, 2), -- order item id 7
       --items for order5
       (null, 5, 'MENU-G', 10000, 2)  -- order item id 8
;