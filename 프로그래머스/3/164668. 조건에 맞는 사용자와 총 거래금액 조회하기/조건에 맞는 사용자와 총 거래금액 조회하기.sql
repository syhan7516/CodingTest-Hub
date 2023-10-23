select u.user_id USER_ID, u.nickname NICKNAME, sum(b.price) TOTAL_SALES
from 
(
    select *
    from used_goods_board
    where status='DONE'
) b inner join used_goods_user u
on b.writer_id = u.user_id
group by USER_ID
having TOTAL_SALES >= 700000
order by TOTAL_SALES;