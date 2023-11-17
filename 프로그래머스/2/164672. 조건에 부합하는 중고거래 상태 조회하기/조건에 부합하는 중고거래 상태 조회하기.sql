# 중고거래 게시판 정보 : used_goods_board

select board_id, writer_id, title, price, (
    case 
        when status = 'sale' then '판매중'
        when status = 'reserved' then '예약중'
        else '거래완료'
    end
    ) status
from used_goods_board
where date_format(created_date,'%Y-%m-%d') = '2022-10-05'
order by board_id desc;