select flavor
from (
    select j.FLAVOR, sum((ifnull(h.TOTAL_ORDER,0)+j.TOTAL_ORDER)) TOTAL_ORDER
    from july j left join first_half h 
        on j.shipment_id = h.shipment_id
    group by j.flavor
    ) a
order by TOTAL_ORDER desc limit 3;