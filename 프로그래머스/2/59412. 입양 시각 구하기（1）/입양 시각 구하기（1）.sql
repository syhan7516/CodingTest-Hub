select HOUR(datetime) hour, count(*) count
from animal_outs
group by hour
having hour between 9 and 19
order by hour;