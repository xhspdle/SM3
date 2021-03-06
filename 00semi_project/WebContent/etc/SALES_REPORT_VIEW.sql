SELECT 
    O.ORDER_NUM,O.ORDER_TOTAL,O.ORDER_POINT,O.ORDER_PAY,O.ORDER_DATE,
    P.ORDER_CNT,P.ITEM_PRICE,        
    I.IN_CNT,I.IN_COST
FROM SM3_ORDER O,SM3_PURCHASE PU,SM3_PURCHASE_LIST P,SM3_ITEM_SIZE S,SM3_IN_ITEM I
WHERE O.PUR_NUM=PU.PUR_NUM AND PU.PUR_NUM=P.PUR_NUM AND P.SIZE_NUM=S.SIZE_NUM AND S.SIZE_NUM=I.SIZE_NUM
AND O.ORDER_DATE BETWEEN '18/08/01' AND '18/08/31';

CREATE OR REPLACE VIEW SM3_SALES_REPORT_VIEW
AS
    SELECT 
        O.ORDER_NUM,O.ORDER_TOTAL,O.ORDER_POINT,O.ORDER_PAY,O.ORDER_DATE,
        P.ORDER_CNT,P.ITEM_PRICE,        
        I.IN_CNT,I.IN_COST
    FROM SM3_ORDER O,SM3_PURCHASE PU,SM3_PURCHASE_LIST P,SM3_ITEM_SIZE S,SM3_IN_ITEM I
    WHERE O.PUR_NUM=PU.PUR_NUM AND PU.PUR_NUM=P.PUR_NUM AND P.SIZE_NUM=S.SIZE_NUM AND S.SIZE_NUM=I.SIZE_NUM;