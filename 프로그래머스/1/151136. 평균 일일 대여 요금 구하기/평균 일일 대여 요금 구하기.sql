# 대여중인 자동차들의 정보

select round(avg(daily_fee),0) average_fee
from car_rental_company_car
where car_type = 'SUV'
group by car_type