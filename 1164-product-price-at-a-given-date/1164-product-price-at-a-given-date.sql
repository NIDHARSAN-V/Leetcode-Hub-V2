with sample as (
    select * 
    from Products
    where change_date <= '2019-08-16'
),
fin as (
    select *,
    row_number() over (
        partition by product_id 
        order by change_date desc
    ) as rownum
    from sample
),
unid as (
    select distinct product_id as disid 
    from products
)
select 
    disid as product_id,
    case
        when disid not in (select product_id from fin) 
            then 10
        else (

            select new_price 
            from fin 
            where product_id = disid 
            and rownum = 1
            
        )
    end as price
from unid;