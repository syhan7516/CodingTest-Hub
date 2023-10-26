select book.author_id, author_name, book.category, sum(book_sales.sales*book.price) TOTAL_SALES 
from book_sales
    join book on book_sales.book_id = book.book_id
    join author on book.author_id = author.author_id
where date_format(book_sales.sales_date,'%Y-%m') like '2022-01%'
group by book.author_id, book.category
order by book.author_id asc, book.category desc;