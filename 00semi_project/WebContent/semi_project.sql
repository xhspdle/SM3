
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

-- ������
CREATE TABLE SM3_ADMIN
(
	-- �����ڹ�ȣ
	ADMIN_NUM number(2,0) NOT NULL,
	-- �����ھ��̵�
	ADMIN_ID varchar2(20) NOT NULL,
	-- �����ں�й�ȣ
	ADMIN_PWD varchar2(20) NOT NULL,
	PRIMARY KEY (ADMIN_NUM)
);


-- ��ٱ���
CREATE TABLE SM3_CART
(
	-- ������ȣ
	USER_NUM number NOT NULL,
	-- ��ǰ��ȣ
	ITEM_NUM number,
	-- �ֹ�����
	ORDER_CNT number(4,0),
	PRIMARY KEY (USER_NUM)
);


-- �̺�Ʈ&����
CREATE TABLE SM3_EVENT_NOTICE
(
	-- �۹�ȣ
	EN_NUM number NOT NULL,
	-- �ۼ���
	EN_WRITER varchar2(20) NOT NULL,
	-- ������
	EN_TITLE varchar2(80) NOT NULL,
	-- �۳��� : �۸��ֱ̳� LONG
	EN_CONTENT long,
	-- �ۼ���
	EN_DATE date,
	-- ��������
	EN_ORGIMG varchar2(100),
	-- �������
	EN_SAVIMG varchar2(100),
	-- �����ڹ�ȣ
	ADMIN_NUM number(2,0),
	PRIMARY KEY (EN_NUM)
);


-- ��Ʈ
CREATE TABLE SM3_HINT
(
	-- ��Ʈ��ȣ
	HINT_NUM number(2,0) NOT NULL,
	-- ��Ʈ����
	HINT_Q varchar2(100),
	PRIMARY KEY (HINT_NUM)
);


-- �԰�
CREATE TABLE SM3_IN_ITEM
(
	-- �԰��ȣ
	IN_NUM number NOT NULL,
	-- �������ȣ
	SIZE_NUM number(3,0),
	-- �����ڹ�ȣ
	ADMIN_NUM number(2,0),
	-- �԰����
	IN_CNT number(4,0),
	-- �ֹ�����
	IN_COST number(7,0),
	-- �԰�¥
	IN_DATE date,
	PRIMARY KEY (IN_NUM)
);


-- ��ǰ
CREATE TABLE SM3_ITEM
(
	-- ��ǰ��ȣ
	ITEM_NUM number NOT NULL,
	-- ��ǰ�̸� : ��ǰ�̸�
	ITEM_NAME varchar2(100),
	-- �з���ȣ
	CATE_NUM number,
	-- ��ǰ����
	ITEM_INFO varchar2(1000),
	-- ��ǰ����
	ITEM_PRICE number(10,0),
	-- �����̹���
	ITEM_ORGIMG varchar2(100),
	-- �����̹���
	ITEM_SAVIMG varchar2(100),
	PRIMARY KEY (ITEM_NUM)
);


-- ��ǰ�з�
CREATE TABLE SM3_ITEMCATE
(
	-- �з���ȣ
	CATE_NUM number NOT NULL,
	-- ī�װ���
	CATE_NAME varchar2(30),
	PRIMARY KEY (CATE_NUM)
);


-- ��ǰ����
CREATE TABLE SM3_ITEM_COLOR
(
	-- �÷���ȣ
	COLOR_NUM number(4,0) NOT NULL,
	-- �÷��̸�
	COLOR_NAME varchar2(20),
	-- �÷��ڵ�
	COLOR_CODE varchar2(20),
	-- ��ǰ��ȣ
	ITEM_NUM number,
	PRIMARY KEY (COLOR_NUM)
);


-- ��ǰ������
CREATE TABLE SM3_ITEM_SIZE
(
	-- �������ȣ
	SIZE_NUM number(3,0) NOT NULL,
	-- �������̸�
	SIZE_NAME varchar2(20),
	-- �÷���ȣ
	COLOR_NUM number(4,0),
	-- ������
	SIZE_CNT number(4,0),
	PRIMARY KEY (SIZE_NUM)
);


-- �ֹ�
CREATE TABLE SM3_ORDER
(
	-- �ֹ���ȣ
	ORDER_NUM number NOT NULL,
	-- �ֹ���ǰ��ȣ
	SIZE_NUM number(3,0),
	-- ����ȣ
	USER_NUM number,
	-- �ֹ�����
	ORDER_CNT number(4,0),
	-- ��ǰ����
	ITEM_PRICE number(7,0),
	-- �ѱݾ�
	ORDER_TOTAL number(10,0),
	-- ����Ʈ���� : ���������̺��̶� Ʈ�����
	-- ����Ȯ���Ǹ� ���������̺� ����Ʈ ����
	ORDER_POINT number(7,0),
	-- �����ݾ� : �ѱݾ�-����Ʈ����
	ORDER_PAY number(10,0),
	-- ����� : �����ȣAPI
	ORDER_ADDR varchar2(100),
	-- �ֹ���¥
	ORDER_DATE date,
	-- �ֹ����� : 1 �����
	-- 2 ��ۿϷ�
	-- 3 ����Ȯ��
	-- 4 ���
	-- 5 ��ǰ
	ORDER_STATUS number(2,0),
	PRIMARY KEY (ORDER_NUM)
);


-- ������
CREATE TABLE SM3_POINT
(
	-- �ֹ���ȣ : ���ձ⺻Ű(������ȣ, �ֹ���ȣ)
	-- 
	ORDER_NUM number NOT NULL,
	-- ������ȣ : ���ձ⺻Ű(������ȣ, �ֹ���ȣ)
	USER_NUM number NOT NULL,
	-- �ֹ���¥
	ORDER_DATE date,
	-- ������
	POINT number,
	-- ����Ʈ���ᳯ¥ : INSERT�Ҷ�
	-- SQL �������� ORDER_DATE+365��
	END_DATE date,
	PRIMARY KEY (ORDER_NUM, USER_NUM)
);


-- Q&A
CREATE TABLE SM3_QA
(
	-- �۹�ȣ
	QA_NUM number NOT NULL,
	-- �ۼ��� : USER_ID 
	QA_WRITER varchar2(20) NOT NULL,
	-- ������
	QA_TITLE varchar2(80) NOT NULL,
	-- �۳���
	QA_CONTENT long,
	-- �ۼ���
	QA_DATE date,
	-- �θ�۹�ȣ
	REF number,
	-- �׷�
	LEV number(3,0),
	-- ��ϼ���
	STEP number(3,0),
	-- ������ȣ
	USER_NUM number,
	-- �����ڹ�ȣ
	ADMIN_NUM number(2,0),
	PRIMARY KEY (QA_NUM)
);


-- ���
CREATE TABLE SM3_QA_COMM
(
	-- ��۹�ȣ
	COMM_NUM number NOT NULL,
	-- �ۼ���
	COMM_WRITER varchar2(20),
	-- ��۳���
	COMM_CONTENT varchar2(1000),
	-- �ۼ���
	COMM_DATE date,
	-- QA�۹�ȣ
	QA_NUM number,
	-- ������ȣ
	USER_NUM number,
	-- �����ڹ�ȣ
	ADMIN_NUM number(2,0),
	PRIMARY KEY (COMM_NUM)
);


-- ��ǰ����
CREATE TABLE SM3_REVIEW
(
	-- �����ȣ
	REVIEW_NUM number NOT NULL,
	-- ��ǰ�̸�
	REVIEW_ITEM varchar2(50) NOT NULL,
	-- ��������
	REVIEW_ORGIMG varchar2(100),
	-- �������
	REVIEW_SAVIMG varchar2(100),
	-- �������� : 1~5
	REVIEW_RATING number(2,0) NOT NULL,
	-- ���䳻��
	REVIEW_CONTENT varchar2(200),
	-- �ۼ���
	REVIEW_DATE date,
	-- �ֹ���ȣ : �ܷ�Ű
	ORDER_NUM number,
	-- ������ȣ
	USER_NUM number,
	PRIMARY KEY (REVIEW_NUM)
);


-- ����
CREATE TABLE SM3_USER
(
	-- ������ȣ
	USER_NUM number NOT NULL,
	-- �������̵� : �ߺ��ǹȾȴ�
	USER_ID varchar2(20) NOT NULL UNIQUE,
	-- ������й�ȣ
	USER_PWD varchar2(20) NOT NULL,
	-- �����̸�
	USER_NAME varchar2(30) NOT NULL,
	-- �����̸���
	USER_EMAIL varchar2(30) NOT NULL UNIQUE,
	-- ������ȭ��ȣ
	USER_PHONE varchar2(20) NOT NULL,
	-- �����ּ�
	USER_ADDR varchar2(100) NOT NULL,
	-- ������
	USER_REGDATE date,
	-- ��й�ȣã��
	HINT_NUM number(2,0) NOT NULL,
	-- ��й�ȣã���
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



