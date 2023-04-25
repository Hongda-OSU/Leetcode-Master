# Write your MySQL query statement below
SELECT a.employee_id,
    COUNT(b.employee_id) AS team_size
FROM Employee a
LEFT JOIN Employee b
ON a.team_id = b.team_id
GROUP BY a.employee_id;