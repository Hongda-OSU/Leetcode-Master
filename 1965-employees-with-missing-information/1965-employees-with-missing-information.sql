# Write your MySQL query statement below
SELECT Employees.employee_id
FROM Employees
WHERE Employees.employee_id  NOT IN (
    SELECT Salaries.employee_id 
    FROM Salaries
    WHERE Salaries.salary IS NOT NULL
)

UNION

SELECT Salaries.employee_id
FROM Salaries
WHERE Salaries.employee_id  NOT IN (
    SELECT Employees.employee_id 
    FROM Employees
    WHERE Employees.name IS NOT NULL
)

ORDER BY 1 ASC;