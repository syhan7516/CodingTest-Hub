# first_half : 상반기 주문 정보
# icecream_info : 아이스크림 성분 정보

select i.ingredient_type, sum(h.total_order) total_order
from first_half h left join icecream_info i
    on h.flavor = i.flavor
group by i.ingredient_type
order by total_order