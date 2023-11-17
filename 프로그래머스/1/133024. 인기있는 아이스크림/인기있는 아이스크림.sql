# 아이스크림 가게의 상반기 주문 정보

select flavor
from first_half
order by total_order desc, shipment_id asc;