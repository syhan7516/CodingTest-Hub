SELECT MAX(DATETIME) AS '시간'
FROM ANIMAL_INS

# SELECT DATETIME
# FROM ANIMAL_INS 
# WHERE DATETIME = (SELECT MAX(DATETIME) FROM ANIMAL_INS)

# SELECT DATETIME
# FROM ANIMAL_INS
# ORDER BY DATETIME DESC LIMIT 1