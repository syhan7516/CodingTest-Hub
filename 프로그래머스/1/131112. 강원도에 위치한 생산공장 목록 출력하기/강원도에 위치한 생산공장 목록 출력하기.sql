select FACTORY_ID, FACTORY_NAME, ADDRESS
    from food_factory
where address like '강원도%'
order by factory_id