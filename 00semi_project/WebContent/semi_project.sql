
/* Drop Tables */

DROP TABLE SM3_EVENT_NOTICE CASCADE CONSTRAINTS;
DROP TABLE SM3_IN_ITEM CASCADE CONSTRAINTS;
DROP TABLE SM3_QA_COMM CASCADE CONSTRAINTS;
DROP TABLE SM3_QA CASCADE CONSTRAINTS;
DROP TABLE SM3_ADMIN CASCADE CONSTRAINTS;
DROP TABLE SM3_CART CASCADE CONSTRAINTS;
DROP TABLE SM3_POINT CASCADE CONSTRAINTS;
DROP TABLE SM3_REVIEW CASCADE CONSTRAINTS;
DROP TABLE SM3_ORDER CASCADE CONSTRAINTS;
DROP TABLE SM3_USER CASCADE CONSTRAINTS;
DROP TABLE SM3_HINT CASCADE CONSTRAINTS;
DROP TABLE SM3_ITEM_SIZE CASCADE CONSTRAINTS;
DROP TABLE SM3_ITEM_COLOR CASCADE CONSTRAINTS;
DROP TABLE SM3_ITEM CASCADE CONSTRAINTS;
DROP TABLE SM3_ITEMCATE CASCADE CONSTRAINTS;




/* Create Tables */

-- 관리자
CREATE TABLE SM3_ADMIN
(
	-- 관리자번호
	ADMIN_NUM number(2,0) NOT NULL,
	-- 관리자아이디
	ADMIN_ID varchar2(20) NOT NULL,
	-- 관리자비밀번호
	ADMIN_PWD varchar2(20) NOT NULL,
	PRIMARY KEY (ADMIN_NUM)
);


-- 장바구니
CREATE TABLE SM3_CART
(
	-- 유저번호
	USER_NUM number NOT NULL,
	-- 상품번호
	ITEM_NUM number,
	-- 주문수량
	ORDER_CNT number(4,0),
	PRIMARY KEY (USER_NUM)
);


-- 이벤트&공지
CREATE TABLE SM3_EVENT_NOTICE
(
	-- 글번호
	EN_NUM number NOT NULL,
	-- 작성자
	EN_WRITER varchar2(20) NOT NULL,
	-- 글제목
	EN_TITLE varchar2(80) NOT NULL,
	-- 글내용 : 글많이넣기 LONG
	EN_CONTENT long,
	-- 작성일
	EN_DATE date,
	-- 원본사진
	EN_ORGIMG varchar2(100),
	-- 저장사진
	EN_SAVIMG varchar2(100),
	-- 관리자번호
	ADMIN_NUM number(2,0),
	PRIMARY KEY (EN_NUM)
);


-- 힌트
CREATE TABLE SM3_HINT
(
	-- 힌트번호
	HINT_NUM number(2,0) NOT NULL,
	-- 힌트질문
	HINT_Q varchar2(100),
	PRIMARY KEY (HINT_NUM)
);


-- 입고
CREATE TABLE SM3_IN_ITEM
(
	-- 입고번호
	IN_NUM number NOT NULL,
	-- 사이즈번호
	SIZE_NUM number(3,0),
	-- 관리자번호
	ADMIN_NUM number(2,0),
	-- 입고수량
	IN_CNT number(4,0),
	-- 주문원가
	IN_COST number(7,0),
	-- 입고날짜
	IN_DATE date,
	PRIMARY KEY (IN_NUM)
);


-- 상품
CREATE TABLE SM3_ITEM
(
	-- 상품번호
	ITEM_NUM number NOT NULL,
	-- 상품이름 : 상품이름
	ITEM_NAME varchar2(100),
	-- 분류번호
	CATE_NUM number,
	-- 상품설명
	ITEM_INFO varchar2(1000),
	-- 상품가격
	ITEM_PRICE number(10,0),
	-- 원본이미지
	ITEM_ORGIMG varchar2(100),
	-- 저장이미지
	ITEM_SAVIMG varchar2(100),
	PRIMARY KEY (ITEM_NUM)
);


-- 상품분류
CREATE TABLE SM3_ITEMCATE
(
	-- 분류번호
	CATE_NUM number NOT NULL,
	-- 카테고리명
	CATE_NAME varchar2(30),
	PRIMARY KEY (CATE_NUM)
);


-- 상품색상
CREATE TABLE SM3_ITEM_COLOR
(
	-- 컬러번호
	COLOR_NUM number(4,0) NOT NULL,
	-- 컬러이름
	COLOR_NAME varchar2(20),
	-- 컬러코드
	COLOR_CODE varchar2(20),
	-- 상품번호
	ITEM_NUM number,
	PRIMARY KEY (COLOR_NUM)
);


-- 상품사이즈
CREATE TABLE SM3_ITEM_SIZE
(
	-- 사이즈번호
	SIZE_NUM number(3,0) NOT NULL,
	-- 사이즈이름
	SIZE_NAME varchar2(20),
	-- 컬러번호
	COLOR_NUM number(4,0),
	-- 재고수량
	SIZE_CNT number(4,0),
	PRIMARY KEY (SIZE_NUM)
);


-- 주문
CREATE TABLE SM3_ORDER
(
	-- 주문번호
	ORDER_NUM number NOT NULL,
	-- 주문상품번호
	SIZE_NUM number(3,0),
	-- 고객번호
	USER_NUM number,
	-- 주문수량
	ORDER_CNT number(4,0),
	-- 상품가격
	ITEM_PRICE number(7,0),
	-- 총금액
	ORDER_TOTAL number(10,0),
	-- 포인트사용액 : 적립금테이블이랑 트랜잭션
	-- 구매확정되면 적립금테이블 포인트 차감
	ORDER_POINT number(7,0),
	-- 결제금액 : 총금액-포인트사용액
	ORDER_PAY number(10,0),
	-- 배송지 : 우편번호API
	ORDER_ADDR varchar2(100),
	-- 주문날짜
	ORDER_DATE date,
	-- 주문상태 : 1 배송중
	-- 2 배송완료
	-- 3 구매확정
	-- 4 취소
	-- 5 반품
	ORDER_STATUS number(2,0),
	PRIMARY KEY (ORDER_NUM)
);


-- 적립금
CREATE TABLE SM3_POINT
(
	-- 주문번호 : 복합기본키(유저번호, 주문번호)
	-- 
	ORDER_NUM number NOT NULL,
	-- 유저번호 : 복합기본키(유저번호, 주문번호)
	USER_NUM number NOT NULL,
	-- 주문날짜
	ORDER_DATE date,
	-- 적립금
	POINT number,
	-- 포인트만료날짜 : INSERT할때
	-- SQL 구문에서 ORDER_DATE+365일
	END_DATE date,
	PRIMARY KEY (ORDER_NUM, USER_NUM)
);


-- Q&A
CREATE TABLE SM3_QA
(
	-- 글번호
	QA_NUM number NOT NULL,
	-- 작성자 : USER_ID 
	QA_WRITER varchar2(20) NOT NULL,
	-- 글제목
	QA_TITLE varchar2(80) NOT NULL,
	-- 글내용
	QA_CONTENT long,
	-- 작성일
	QA_DATE date,
	-- 부모글번호
	REF number,
	-- 그룹
	LEV number(3,0),
	-- 등록순서
	STEP number(3,0),
	-- 유저번호
	USER_NUM number,
	-- 관리자번호
	ADMIN_NUM number(2,0),
	PRIMARY KEY (QA_NUM)
);


-- 댓글
CREATE TABLE SM3_QA_COMM
(
	-- 댓글번호
	COMM_NUM number NOT NULL,
	-- 작성자
	COMM_WRITER varchar2(20),
	-- 댓글내용
	COMM_CONTENT varchar2(1000),
	-- 작성일
	COMM_DATE date,
	-- QA글번호
	QA_NUM number,
	-- 유저번호
	USER_NUM number,
	-- 관리자번호
	ADMIN_NUM number(2,0),
	PRIMARY KEY (COMM_NUM)
);


-- 상품리뷰
CREATE TABLE SM3_REVIEW
(
	-- 리뷰번호
	REVIEW_NUM number NOT NULL,
	-- 제품이름
	REVIEW_ITEM varchar2(50) NOT NULL,
	-- 원본사진
	REVIEW_ORGIMG varchar2(100),
	-- 저장사진
	REVIEW_SAVIMG varchar2(100),
	-- 리뷰평점 : 1~5
	REVIEW_RATING number(2,0) NOT NULL,
	-- 리뷰내용
	REVIEW_CONTENT varchar2(200),
	-- 작성일
	REVIEW_DATE date,
	-- 주문번호 : 외래키
	ORDER_NUM number,
	-- 유저번호
	USER_NUM number,
	PRIMARY KEY (REVIEW_NUM)
);


-- 유저
CREATE TABLE SM3_USER
(
	-- 유저번호
	USER_NUM number NOT NULL,
	-- 유저아이디 : 중복되믄안댐
	USER_ID varchar2(20) NOT NULL UNIQUE,
	-- 유저비밀번호
	USER_PWD varchar2(20) NOT NULL,
	-- 유저이름
	USER_NAME varchar2(30) NOT NULL,
	-- 유저이메일
	USER_EMAIL varchar2(30) NOT NULL UNIQUE,
	-- 유저전화번호
	USER_PHONE varchar2(20) NOT NULL,
	-- 유저주소
	USER_ADDR varchar2(100) NOT NULL,
	-- 가입일
	USER_REGDATE date,
	-- 비밀번호찾기
	HINT_NUM number(2,0) NOT NULL,
	-- 비밀번호찾기답
	HINT_OK varchar2(50) NOT NULL,
	PRIMARY KEY (USER_NUM)
);



/* Create Foreign Keys */

ALTER TABLE SM3_EVENT_NOTICE
	ADD FOREIGN KEY (ADMIN_NUM)
	REFERENCES SM3_ADMIN (ADMIN_NUM)
;


ALTER TABLE SM3_IN_ITEM
	ADD FOREIGN KEY (ADMIN_NUM)
	REFERENCES SM3_ADMIN (ADMIN_NUM)
;


ALTER TABLE SM3_QA
	ADD FOREIGN KEY (ADMIN_NUM)
	REFERENCES SM3_ADMIN (ADMIN_NUM)
;


ALTER TABLE SM3_QA_COMM
	ADD FOREIGN KEY (ADMIN_NUM)
	REFERENCES SM3_ADMIN (ADMIN_NUM)
;


ALTER TABLE SM3_USER
	ADD FOREIGN KEY (HINT_NUM)
	REFERENCES SM3_HINT (HINT_NUM)
;


ALTER TABLE SM3_CART
	ADD FOREIGN KEY (ITEM_NUM)
	REFERENCES SM3_ITEM (ITEM_NUM)
;


ALTER TABLE SM3_ITEM_COLOR
	ADD FOREIGN KEY (ITEM_NUM)
	REFERENCES SM3_ITEM (ITEM_NUM)
;


ALTER TABLE SM3_ITEM
	ADD FOREIGN KEY (CATE_NUM)
	REFERENCES SM3_ITEMCATE (CATE_NUM)
;


ALTER TABLE SM3_ITEM_SIZE
	ADD FOREIGN KEY (COLOR_NUM)
	REFERENCES SM3_ITEM_COLOR (COLOR_NUM)
;


ALTER TABLE SM3_IN_ITEM
	ADD FOREIGN KEY (SIZE_NUM)
	REFERENCES SM3_ITEM_SIZE (SIZE_NUM)
;


ALTER TABLE SM3_ORDER
	ADD FOREIGN KEY (SIZE_NUM)
	REFERENCES SM3_ITEM_SIZE (SIZE_NUM)
;


ALTER TABLE SM3_POINT
	ADD FOREIGN KEY (ORDER_NUM)
	REFERENCES SM3_ORDER (ORDER_NUM)
;


ALTER TABLE SM3_REVIEW
	ADD FOREIGN KEY (ORDER_NUM)
	REFERENCES SM3_ORDER (ORDER_NUM)
;


ALTER TABLE SM3_QA_COMM
	ADD FOREIGN KEY (QA_NUM)
	REFERENCES SM3_QA (QA_NUM)
;


ALTER TABLE SM3_CART
	ADD FOREIGN KEY (USER_NUM)
	REFERENCES SM3_USER (USER_NUM)
;


ALTER TABLE SM3_ORDER
	ADD FOREIGN KEY (USER_NUM)
	REFERENCES SM3_USER (USER_NUM)
;


ALTER TABLE SM3_POINT
	ADD FOREIGN KEY (USER_NUM)
	REFERENCES SM3_USER (USER_NUM)
;


ALTER TABLE SM3_QA
	ADD FOREIGN KEY (USER_NUM)
	REFERENCES SM3_USER (USER_NUM)
;


ALTER TABLE SM3_QA_COMM
	ADD FOREIGN KEY (USER_NUM)
	REFERENCES SM3_USER (USER_NUM)
;


ALTER TABLE SM3_REVIEW
	ADD FOREIGN KEY (USER_NUM)
	REFERENCES SM3_USER (USER_NUM)
;



