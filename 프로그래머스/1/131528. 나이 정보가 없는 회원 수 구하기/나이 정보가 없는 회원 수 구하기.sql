select count(*) users
from user_info
where age is null
group by age
