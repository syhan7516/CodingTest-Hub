select HOUR(datetime) hour, count(HOUR(datetime)) count
from animal_outs
where HOUR(datetime) >= 9 and HOUR(datetime) < 20
group by hour
order by hour;