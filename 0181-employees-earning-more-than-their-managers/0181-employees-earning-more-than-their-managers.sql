SELECT e.name as Employee 
FROM employee e
WHERE e.managerId IS NOT NULL
  AND e.salary > (
    SELECT p.salary 
    FROM employee p 
    WHERE p.id = e.managerId
  );
