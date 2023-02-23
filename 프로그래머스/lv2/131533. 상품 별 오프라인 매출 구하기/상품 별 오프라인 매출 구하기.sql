SELECT PR.PRODUCT_CODE, SUM(PR.PRICE * OS.SALES_AMOUNT) AS PRICE FROM PRODUCT PR, OFFLINE_SALE OS
WHERE PR.PRODUCT_ID = OS.PRODUCT_ID
GROUP BY PR.PRODUCT_CODE
ORDER BY PRICE DESC, PR.PRODUCT_CODE