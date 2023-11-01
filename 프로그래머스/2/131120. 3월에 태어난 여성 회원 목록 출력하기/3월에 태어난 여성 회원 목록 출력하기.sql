select member_id, member_name, gender, date_format(DATE_OF_BIRTH,'%Y-%m-%d') date_of_birth
from member_profile
where month(DATE_OF_BIRTH) = '3'
    and gender = 'w'
    and tlno is not null
order by member_id asc;