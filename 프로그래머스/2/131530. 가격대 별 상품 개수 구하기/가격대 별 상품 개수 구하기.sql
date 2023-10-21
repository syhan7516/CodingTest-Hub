select truncate(price,-4) as PRICE_GROUP, count(product_id) as PRODUCTS
from product
group by PRICE_GROUP
order by PRICE_GROUP