# Write your MySQL query statement below
SELECT p.project_id,
    p.employee_id
FROM Project p
JOIN Employee e
ON p.employee_id = e.employee_id
WHERE (p.project_id, e.experience_years) IN 
(
    SELECT a.project_id,
        MAX(b.experience_years)
    FROM Project a 
    JOIN Employee b
    ON a.employee_id = b.employee_id
    GROUP BY a.project_id
);