# Write your MySQL query statement below
SELECT id,
    company,
    salary
FROM 
(
    SELECT id,
        company,
        salary,
        ROW_NUMBER() OVER(PARTITION BY company ORDER BY salary) salaryrank,
        COUNT(*) OVER(PARTITION BY company) tte
    FROM Employee
) AS foo
WHERE salaryrank >= tte / 2 
AND salaryrank <= tte / 2 + 1;