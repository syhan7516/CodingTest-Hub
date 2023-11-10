select substring(product_code,1,2) category, count(product_id) product
from product
group by category
order by category