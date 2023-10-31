select u.user_id, u.nickname, concat(u.city, " ", u.street_address1, " ",u.street_address2) '전체주소', 
    concat('010-',substring(tlno,4,4),'-',substring(tlno,8,4))'전화번호'
from used_goods_board b join used_goods_user u 
    on b.writer_id = u.user_id
group by u.user_id
having count(b.writer_id) >= 3
order by user_id desc;

