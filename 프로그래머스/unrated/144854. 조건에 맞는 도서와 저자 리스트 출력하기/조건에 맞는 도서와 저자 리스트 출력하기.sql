SELECT BK.BOOK_ID, AR.AUTHOR_NAME, DATE_FORMAT(BK.PUBLISHED_DATE,'%Y-%m-%d') AS PUBLISHED_DATE
    FROM BOOK BK, AUTHOR AR
    WHERE BK.AUTHOR_ID = AR.AUTHOR_ID
    AND BK.CATEGORY = '경제'
ORDER BY BK.PUBLISHED_DATE ASC