select b.category, sum(sales) TOTAL_SALES
from book_sales s left join book b
    on s.book_id = b.book_id
where s.sales_date like '2022-01-%'
group by b.category
order by b.category