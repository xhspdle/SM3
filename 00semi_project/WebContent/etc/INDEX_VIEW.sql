-- INDEX���ѷ��ٰ� ��ǰ�̹���, ��ǰ��, ����, ���䰹��
CREATE OR REPLACE VIEW SM3_INDEX_VIEW
AS
    SELECT
        I.ITEM_SAVIMG,I.ITEM_NAME,I.ITEM_PRICE,I.ITEM_NUM,
        PU.ORDER_CNT
    FROM SM3_ITEM I,SM3_ITEM_SIZE S,SM3_PURCHASE_LIST PU,SM3_PURCHASE P,SM3_ORDER O
    WHERE I.ITEM_NUM=S.ITEM_NUM AND S.SIZE_NUM=PU.SIZE_NUM AND PU.PUR_NUM=P.PUR_NUM AND P.PUR_NUM=O.PUR_NUM;

SELECT AA.*
FROM
(
    SELECT *
    FROM SM3_INDEX_VIEW
    ORDER BY ORDER_CNT DESC
)AA
WHERE ROWNUM<=24;