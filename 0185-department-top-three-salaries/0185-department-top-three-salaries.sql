WITH temp AS (
    SELECT 
        e.name AS empname, 
        d.name AS deptname, 
        e.salary AS sal,
        DENSE_RANK() OVER (
            PARTITION BY e.departmentId 
            ORDER BY e.salary DESC
        ) AS dept_rank
    FROM Employee e
    JOIN Department d
        ON e.departmentId = d.id
)

SELECT deptname  as Department, empname as Employee, sal as Salary 
FROM temp
where dept_rank <=3;