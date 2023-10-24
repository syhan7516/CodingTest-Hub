select distinct(h.car_id) CAR_ID
from car_rental_company_car c left join car_rental_company_rental_history h
    on c.car_id = h.car_id
where h.start_date like '2022-10-%'
    and c.car_type = '세단'
order by CAR_ID desc;