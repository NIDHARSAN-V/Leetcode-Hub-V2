WITH sample AS (
    SELECT *,
           MIN(year) OVER (PARTITION BY product_id) AS first_year
    FROM Sales
)
SELECT 
    product_id,
    first_year,
    quantity,
    price
FROM sample
WHERE year = first_year
order by first_year;