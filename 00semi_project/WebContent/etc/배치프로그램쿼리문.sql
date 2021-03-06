--구매목록에는 존재하지만, 주문목록에는 존재하지 않는 데이터들 찾아서 삭제하기

SELECT * 
FROM SM3_PURCHASE PU
WHERE NOT EXISTS (SELECT * FROM SM3_ORDER O WHERE O.PUR_NUM=PU.PUR_NUM);

--자식테이블인 구매목록에서 먼저 지우고
DELETE FROM SM3_PURCHASE_LIST P
WHERE P.PUR_NUM 
IN
(
    SELECT * 
    FROM SM3_PURCHASE PU
    WHERE NOT EXISTS (SELECT * FROM SM3_ORDER O WHERE O.PUR_NUM=PU.PUR_NUM)
);

--부모테이블인 구매테이블 지우기
DELETE FROM SM3_PURCHASE PU
WHERE NOT EXISTS (SELECT * FROM SM3_ORDER O WHERE O.PUR_NUM=PU.PUR_NUM);