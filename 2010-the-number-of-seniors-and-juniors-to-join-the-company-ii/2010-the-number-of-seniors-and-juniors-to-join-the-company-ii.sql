# Write your MySQL query statement below
WITH a AS 
(
    SELECT employee_id,
        experience,
        salary,
        SUM(salary) OVER(PARTITION BY experience ORDER BY salary) AS budget
    FROM Candidates
), b AS (
    SELECT employee_id,
        budget 
    FROM a 
    WHERE experience = "senior" 
    AND budget <= 70000
), c AS (
    SELECT employee_id
    FROM a
    WHERE budget <= 70000 - (SELECT IFNULL(MAX(budget), 0) FROM b)
)

SELECT employee_id 
FROM b
UNION
SELECT employee_id
FROM c;