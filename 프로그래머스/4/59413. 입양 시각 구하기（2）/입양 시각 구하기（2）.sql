with recursive time as(
    select 0 hour
    union all
    select hour+1 from time
    where hour < 23)

select time.hour, count(animal_id)
    from (select *, HOUR(datetime) hour     
    from animal_outs) o
    right join time on o.hour = time.hour
group by time.hour
order by time.hour