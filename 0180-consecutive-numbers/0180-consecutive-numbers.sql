WITH RECURSIVE temp AS (

    SELECT 
        id,
        num,
        1 AS cnt
    FROM Logs
    WHERE id = 1

    UNION ALL

    SELECT 
        l.id,
        l.num,
        CASE 
            WHEN l.num = t.num THEN t.cnt + 1
            ELSE 1
        END AS cnt
    FROM Logs l
    JOIN temp t
        ON l.id = t.id + 1
)

SELECT DISTINCT num AS ConsecutiveNums
FROM temp
WHERE cnt >= 3;