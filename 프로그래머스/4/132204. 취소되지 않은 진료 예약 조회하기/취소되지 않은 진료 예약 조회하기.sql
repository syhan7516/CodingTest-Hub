# 진료예약번호, 환자이름, 환자번호, 진료과코드, 의사이름, 진료예약일시

select a.APNT_NO, p.PT_NAME, p.PT_NO, d.MCDP_CD, d.DR_NAME, a.APNT_YMD
from APPOINTMENT a left join PATIENT p 
    on a.PT_NO = p.PT_NO left join DOCTOR d
    on a.MDDR_ID = d.DR_ID
where date_format(a.APNT_YMD,'%Y-%m-%d') = '2022-04-13'
    and a.APNT_CNCL_YMD is null
    and a.MCDP_CD = 'CS'
order by a.APNT_YMD asc;