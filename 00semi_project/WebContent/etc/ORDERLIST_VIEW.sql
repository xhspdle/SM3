
CREATE OR REPLACE VIEW SM3_ORDERLIST_VIEW
AS
    SELECT
        ORD.ORDER_NUM,ORD.USER_NUM,ORD.PUR_NUM,I.ITEM_NAME,I.ITEM_SAVIMG, 
        I.ITEM_INFO,PL.ORDER_CNT,
        ORD.ORDER_PAY,ORD.ORDER_STATUS
        FROM SM3_ORDER ORD,SM3_ITEM I,SM3_PURCHASE P,SM3_PURCHASE_LIST PL,SM3_ITEM_SIZE S
        WHERE ORD.PUR_NUM=P.PUR_NUM AND P.PUR_NUM=PL.PUR_NUM AND PL.SIZE_NUM=S.SIZE_NUM AND S.ITEM_NUM=I.ITEM_NUM; 
        