select car_id,
    if(sum(if(start_date <= date('2022-10-16')
            and end_date >= date('2022-10-16'),1,0)) >=1,
       '대여중','대여 가능') availability
from car_rental_company_rental_history
group by car_id
order by car_id desc;