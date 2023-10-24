select HISTORY_ID, CAR_ID, 
    date_format(start_date,'%Y-%m-%d') START_DATE, 
    date_format(end_date, '%Y-%m-%d') END_DATE,
        case 
            when datediff(end_date, start_date)+1 >= 30 then '장기 대여'
            else '단기 대여'
        end RENT_TYPE
from car_rental_company_rental_history
where START_DATE like '2022-09-%'
order by history_id desc;