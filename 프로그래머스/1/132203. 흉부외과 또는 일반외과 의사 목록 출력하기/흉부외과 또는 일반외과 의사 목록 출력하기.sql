select dr_name, dr_id, mcdp_cd, date_format(hire_ymd,'%Y-%m-%d') hire_ymd
from doctor
where mcdp_cd in ('cs','gs')
order by hire_ymd desc, dr_name asc;