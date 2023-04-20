# Write your MySQL query statement below
SELECT event_day AS Day,
    emp_id,
    SUM(out_time) - SUM(in_time) AS Total_time
FROM Employees
GROUP BY event_day, emp_id;