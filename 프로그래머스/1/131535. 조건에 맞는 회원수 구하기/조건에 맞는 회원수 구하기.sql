select count(*) as 'USERS'
from user_info
where year(joined) = 2021 
    and age >= 02
    and age <= 29;
    