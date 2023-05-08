# Write your MySQL query statement below
SELECT dep.name AS Department,
    emp.name AS Employee,
    emp.salary
FROM Department dep,
    Employee emp
WHERE emp.departmentId = dep.id AND 
(
    SELECT COUNT(DISTINCT salary)
    FROM Employee
    WHERE departmentId = dep.id
    AND salary > emp.salary
) < 3;