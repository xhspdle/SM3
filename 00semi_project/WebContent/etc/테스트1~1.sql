CREATE OR REPLACE VIEW SM3_ITEM_VIEW
AS
    SELECT 
        C.CATE_NUM,C.CATE_NAME,
        I.ITEM_NUM,I.ITEM_NAME,I.ITEM_INFO,I.ITEM_PRICE,I.ITEM_ORGIMG,I.ITEM_SAVIMG,
        S.SIZE_NUM,S.SIZE_NAME,S.SIZE_CNT,
        CO.COLOR_NUM,CO.COLOR_NAME,CO.COLOR_CODE
    FROM SM3_ITEMCATE C,SM3_ITEM I,SM3_ITEM_SIZE S,SM3_ITEM_COLOR CO
    WHERE C.CATE_NUM=I.CATE_NUM AND I.ITEM_NUM=S.ITEM_NUM AND S.COLOR_NUM=CO.COLOR_NUM;

SELECT * FROM SM3_ITEM_VIEW WHERE ITEM_NUM=1;
delete from sm3_purchase;
commit;
-- SAVIMG, ITEM_NAME, ITEM_PRICE, COLOR_NAME, ORDER_CNT
CREATE OR REPLACE VIEW SM3_CART_VIEW
AS
    SELECT 
        CA.CART_NUM,CA.USER_NUM,CA.SIZE_NUM,CA.ORDER_CNT,
        I.ITEM_PRICE,I.ITEM_SAVIMG,I.ITEM_NAME,
        CO.COLOR_NAME
    FROM SM3_ITEM I,SM3_ITEM_SIZE S,SM3_ITEM_COLOR CO,SM3_CART CA
    WHERE I.ITEM_NUM=S.ITEM_NUM AND S.COLOR_NUM=CO.COLOR_NUM AND S.SIZE_NUM=CA.SIZE_NUM;

CREATE OR REPLACE VIEW SM3_PURCHASE_VIEW
AS
    SELECT 
        P.PL_NUM,P.PUR_NUM,P.SIZE_NUM,P.ORDER_CNT,
        I.ITEM_PRICE,I.ITEM_SAVIMG,I.ITEM_NAME,
        CO.COLOR_NAME
    FROM SM3_ITEM I,SM3_ITEM_SIZE S,SM3_ITEM_COLOR CO,SM3_PURCHASE_LIST P
    WHERE I.ITEM_NUM=S.ITEM_NUM AND S.COLOR_NUM=CO.COLOR_NUM AND S.SIZE_NUM=P.SIZE_NUM;

CREATE OR REPLACE VIEW SM3_SALES_REPORT_VIEW
AS
    SELECT 
        O.ORDER_NUM,O.ORDER_TOTAL,O.ORDER_POINT,O.ORDER_PAY,O.ORDER_DATE,
        P.ORDER_CNT,P.ITEM_PRICE,        
        I.IN_CNT,I.IN_COST
    FROM SM3_ORDER O,SM3_PURCHASE PU,SM3_PURCHASE_LIST P,SM3_ITEM_SIZE S,SM3_IN_ITEM I
    WHERE O.PUR_NUM=PU.PUR_NUM AND PU.PUR_NUM=P.PUR_NUM AND P.SIZE_NUM=S.SIZE_NUM AND S.SIZE_NUM=I.SIZE_NUM;

SELECT
    O.ORDER_NUM,
    PU.PUR_NUM,PU.SIZE_NUM,PU.ORDER_CNT,
    S.ITEM_NUM,S.SIZE_CNT
FROM SM3_ORDER O,SM3_PURCHASE P,SM3_PURCHASE_LIST PU,SM3_ITEM_SIZE S
WHERE O.PUR_NUM=P.PUR_NUM AND P.PUR_NUM=PU.PUR_NUM AND PU.SIZE_NUM=S.SIZE_NUM;

SELECT *
FROM
(
    SELECT AA.*,ROWNUM RNUM
    FROM
    (
        SELECT *
        FROM SM3_ORDER
        ORDER BY ORDER_NUM DESC
    )AA
)
WHERE RNUM>=1 AND RNUM<=10;

-- INDEX���ѷ��ٰ� ��ǰ�̹���, ��ǰ��, ����, ���䰹��
CREATE OR REPLACE VIEW SM3_INDEX_VIEW
AS
    SELECT
        I.ITEM_ORGIMG,I.ITEM_NAME,I.ITEM_PRICE,I.ITEM_NUM,
        PU.ORDER_CNT
    FROM SM3_ITEM I,SM3_ITEM_SIZE S,SM3_PURCHASE_LIST PU,SM3_PURCHASE P,SM3_ORDER O
    WHERE I.ITEM_NUM=S.ITEM_NUM AND S.SIZE_NUM=PU.SIZE_NUM AND PU.PUR_NUM=P.PUR_NUM AND P.PUR_NUM=O.PUR_NUM;


CREATE OR REPLACE FORCE VIEW SM3_ORDERLIST_VIEW
 AS 
  SELECT
        ORD.ORDER_NUM,ORD.USER_NUM,ORD.PUR_NUM,I.ITEM_NUM,I.ITEM_NAME,I.ITEM_ORGIMG, 
        I.ITEM_INFO,PL.ORDER_CNT,
        ORD.ORDER_PAY,ORD.ORDER_RECIPIENT,ORD.ORDER_PHONE,ORD.ORDER_BASIC_ADDR,ORD.ORDER_DETAIL_ADDR,ORD.ORDER_POINT,ORD.ORDER_STATUS,ORD.ORDER_DATE
        FROM SM3_ORDER ORD,SM3_ITEM I,SM3_PURCHASE P,SM3_PURCHASE_LIST PL,SM3_ITEM_SIZE S
        WHERE ORD.PUR_NUM=P.PUR_NUM AND P.PUR_NUM=PL.PUR_NUM AND PL.SIZE_NUM=S.SIZE_NUM AND S.ITEM_NUM=I.ITEM_NUM;
        
CREATE OR REPLACE VIEW SM3_CART_VIEW
AS
    SELECT 
        CA.CART_NUM,CA.USER_NUM,CA.SIZE_NUM,CA.ORDER_CNT,
        I.ITEM_ORGIMG,I.ITEM_NAME,I.ITEM_PRICE,
        CO.COLOR_NAME
    FROM SM3_ITEM I,SM3_ITEM_SIZE S,SM3_ITEM_COLOR CO,SM3_CART CA
    WHERE I.ITEM_NUM=S.ITEM_NUM AND S.COLOR_NUM=CO.COLOR_NUM AND S.SIZE_NUM=CA.SIZE_NUM;


SELECT AA.*
FROM
(
    SELECT *
    FROM SM3_INDEX_VIEW
    ORDER BY ORDER_CNT DESC
)AA
WHERE ROWNUM<=24;

SELECT AA.*
FROM
(
    SELECT I.*
    FROM SM3_INDEX_VIEW IV,SM3_ITEM I 
    WHERE I.ITEM_NUM(+)=IV.ITEM_NUM
    ORDER BY IV.ITEM_NUM DESC
)AA
WHERE ROWNUM<=24;

SELECT * 
FROM SM3_PURCHASE_LIST P,SM3_PURCHASE PU,SM3_ORDER O
WHERE O.PUR_NUM=P.PUR_NUM AND P.PUR_NUM=PU.PUR_NUM AND O.PUR_NUM=28;

SELECT * 
FROM SM3_PURCHASE_LIST P,SM3_PURCHASE PU,SM3_ORDER O
WHERE O.PUR_NUM=P.PUR_NUM AND P.PUR_NUM=PU.PUR_NUM AND ORDER_STATUS>=4;

SELECT * 
FROM SM3_PURCHASE PU,SM3_ORDER O LEFT OUTER JOIN SM3_PURCHASE_LIST P ON (O.PUR_NUM=P.PUR_NUM)
WHERE P.PUR_NUM=PU.PUR_NUM AND O.PUR_NUM IS NULL;

SELECT * 
FROM SM3_PURCHASE PU
WHERE NOT EXISTS (SELECT * FROM SM3_ORDER O WHERE O.PUR_NUM=PU.PUR_NUM);

DELETE FROM SM3_PURCHASE_LIST P
WHERE P.PUR_NUM 
IN
(
    SELECT * 
    FROM SM3_PURCHASE PU
    WHERE NOT EXISTS (SELECT * FROM SM3_ORDER O WHERE O.PUR_NUM=PU.PUR_NUM)
);


DELETE FROM SM3_PURCHASE PU
WHERE NOT EXISTS (SELECT * FROM SM3_ORDER O WHERE O.PUR_NUM=PU.PUR_NUM);
commit;

SELECT * 
FROM SM3_PURCHASE_LIST P,SM3_PURCHASE PU,SM3_ORDER O
WHERE O.PUR_NUM=P.PUR_NUM AND P.PUR_NUM=PU.PUR_NUM AND ORDER_STATUS=3;

SELECT H.HINT_Q
FROM SM3_HINT H,SM3_USER U
WHERE H.HINT_NUM=U.HINT_NUM AND U.USER_ID='test';

    SELECT
        I.ITEM_SAVIMG,I.ITEM_NAME,I.ITEM_PRICE,I.ITEM_NUM,
        PU.ORDER_CNT
    FROM SM3_ITEM I,SM3_ITEM_SIZE S,SM3_PURCHASE_LIST PU,SM3_PURCHASE P,SM3_ORDER O
    WHERE I.ITEM_NUM=S.ITEM_NUM AND S.SIZE_NUM=PU.SIZE_NUM AND PU.PUR_NUM=P.PUR_NUM AND P.PUR_NUM=O.PUR_NUM;
    
DELETE FROM SM3_ORDER;