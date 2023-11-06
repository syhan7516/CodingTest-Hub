select a.car_id, a.car_type, round(a.daily_fee * 30 * (100 - p.discount_rate) * .01, 0) as FEE
    from (
        select distinct c.car_id, c.car_type, c.daily_fee
        from CAR_RENTAL_COMPANY_CAR c
        join CAR_RENTAL_COMPANY_RENTAL_HISTORY h on c.car_id = h.car_id
        where date_format(h.start_date, '%Y%m%d') not between '20221101' and '20221130'
        and date_format(h.end_date, '%Y%m%d') not between '20221101' and '20221130'
        and h.car_id not in (select car_id from CAR_RENTAL_COMPANY_RENTAL_HISTORY
                            where end_date >= '2022-11-01' and start_date <= '2022-11-30')
        and c.car_type in ('SUV', '세단')
        ) a join (select car_type, discount_rate from CAR_RENTAL_COMPANY_DISCOUNT_PLAN
            where duration_type = '30일 이상') p on p.car_type = a.car_type
        where round(a.daily_fee * 30 * (100 - p.discount_rate) * .01, 0) between 500000 and 1999999
order by FEE desc, a.car_type asc, a.car_id desc;