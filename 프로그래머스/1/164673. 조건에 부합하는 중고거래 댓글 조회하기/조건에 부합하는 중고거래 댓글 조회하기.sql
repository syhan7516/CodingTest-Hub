# used_goods_board : 게시판 정보
# used_goods_reply : 댓글 정보

select b.title, b.board_id, r.reply_id, r.writer_id, r.contents, date_format(r.created_date,'%Y-%m-%d') created_date 
from used_goods_board b left join used_goods_reply r
    on b.board_id = r.board_id
where date_format(b.CREATED_DATE,'%Y-%m') = '2022-10'
    and r.reply_id is not null
order by r.CREATED_DATE asc, b.title
