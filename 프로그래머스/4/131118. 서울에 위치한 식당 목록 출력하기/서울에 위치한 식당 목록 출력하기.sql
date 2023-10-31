select a.rest_id, rest_name, food_type, favorites, address, round(avg(review_score),2) score
from rest_info a right join rest_review b
on a.rest_id = b.rest_id
where address like '서울%'
group by a.rest_id
order by score desc, favorites desc;