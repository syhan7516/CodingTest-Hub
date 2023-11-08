select p.product_id, p.product_name, sum(o.amount)*price TOTAL_SALES
    from food_order o left join food_product p
    on o.product_id = p.product_id
where date_format(o.produce_date,'%Y-%m') = '2022-05'
group by p.product_id
order by TOTAL_SALES desc, p.product_id asc;