with sample as (
    select 
        t.id,
        t.client_id,
        t.driver_id,
        t.city_id,
        t.status,
        t.request_at,
        c.banned as client_banned,
        d.banned as driver_banned
    from Trips t
    left join Users c 
        on t.client_id = c.users_id
    left join Users d 
        on t.driver_id = d.users_id
)

select 
    request_at as Day,
    round(
        sum(
            case 
                when status != 'completed' then 1 
                else 0 
            end
        ) * 1.0 / count(*), 
        2
    ) as "Cancellation Rate"
from sample
where 
    client_banned = 'No'
    and driver_banned = 'No'
    and request_at between '2013-10-01' and '2013-10-03'
group by request_at;