select animal_id, name, date_format(datetime,'%Y-%m-%d') 날짜
from animal_ins
order by animal_id