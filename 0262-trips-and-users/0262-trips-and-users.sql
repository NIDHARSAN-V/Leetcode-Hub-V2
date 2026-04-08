WITH sample AS (
    SELECT 
        t.id,
        t.client_id,
        t.driver_id,
        t.city_id,
        t.status,
        t.request_at,
        c.banned AS client_banned,
        d.banned AS driver_banned
    FROM Trips t
    LEFT JOIN Users c 
        ON t.client_id = c.users_id
    LEFT JOIN Users d 
        ON t.driver_id = d.users_id
)

SELECT 
    request_at AS Day,
    ROUND(
        SUM(
            CASE 
                WHEN status != 'completed' THEN 1 
                ELSE 0 
            END
        )  / COUNT(*), 
        2
    ) AS "Cancellation Rate"

FROM sample
WHERE 
    client_banned = 'No'
    AND driver_banned = 'No'
    AND request_at BETWEEN '2013-10-01' AND '2013-10-03'
GROUP BY request_at;