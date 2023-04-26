# Write your MySQL query statement below
SELECT dept_name,
    SUM(
        CASE
            WHEN s.dept_id THEN 1
            ELSE 0
        END
    ) AS student_number
FROM Department d 
LEFT JOIN Student s
ON d.dept_id = s.dept_id
GROUP BY 1
ORDER BY 2 DESC, 1;