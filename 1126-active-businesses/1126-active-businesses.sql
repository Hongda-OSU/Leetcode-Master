# Write your MySQL query statement below
SELECT business_id
FROM 
(
    SELECT event_type,
        AVG(occurences) AS ave_occurences   
    FROM Events AS e1
    GROUP BY event_type
) AS e
JOIN Events AS e2
ON e.event_type = e2.event_type
WHERE e2.occurences > e.ave_occurences
GROUP BY business_id
HAVING COUNT(DISTINCT e.event_type) > 1;