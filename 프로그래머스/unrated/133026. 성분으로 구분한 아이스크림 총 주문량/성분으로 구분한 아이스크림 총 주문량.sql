SELECT II.INGREDIENT_TYPE, SUM(FH.TOTAL_ORDER) AS TOTAL_ORDER
FROM FIRST_HALF FH, ICECREAM_INFO II
WHERE FH.FLAVOR = II.FLAVOR
GROUP BY II.INGREDIENT_TYPE
ORDER BY TOTAL_ORDER