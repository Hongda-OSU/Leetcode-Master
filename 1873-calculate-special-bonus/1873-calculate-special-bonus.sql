# Write your MySQL query statement below
SELECT 
    employee_id, salary as bonus
FROM 
    employees
WHERE 
    employee_id % 2 != 0 and name not like 'M%'

UNION

SELECT 
    employee_id, 0 as bonus
FROM 
    employees
WHERE 
    employee_id % 2 = 0 or name like 'M%'
ORDER BY
    employee_id