select date_format(start_date,'%c') month, car_id, count(*) records
from car_rental_company_rental_history
where car_id in (select car_id
    from car_rental_company_rental_history
    where date_format(start_date,'%Y-%m') between '2022-08' and '2022-10'
    group by car_id having count(*) >= 5)
    AND DATE_FORMAT(START_DATE, "%Y-%m") BETWEEN '2022-08' AND '2022-10'
group by month, car_id
having records>0
order by date_format(start_date,'%m') asc, car_id desc;