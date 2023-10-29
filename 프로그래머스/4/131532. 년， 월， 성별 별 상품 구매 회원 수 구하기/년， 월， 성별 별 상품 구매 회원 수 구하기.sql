select year(o.sales_date) year, 
        month(o.sales_date) month,
        u.gender, count(distinct u.user_id) users
from online_sale o left join user_info u
    on o.user_id = u.user_id
where u.gender is not null
group by year,month,gender
order by year,month,gender;