# Write your MySQL query statement below
SELECT d.name AS department,
    e.name AS employee,
    e.salary
FROM Department d, Employee e
WHERE e.departmentId = d.id
AND e.salary = (
    SELECT MAX(salary)
    FROM Employee e2
    WHERE e2.departmentId = d.id
);