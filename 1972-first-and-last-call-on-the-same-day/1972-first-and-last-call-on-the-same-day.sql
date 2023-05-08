# Write your MySQL query statement below
WITH cte AS 
(
    SELECT caller_id AS user_id,
        call_time,
        recipient_id 
    FROM Calls
    UNION
    SELECT recipient_id AS user_id,
        call_time,
        caller_id AS recipient_id
    FROM Calls
), cte1 AS (
    SELECT user_id,
        recipient_id,
        DATE(call_time) AS DAY,
        DENSE_RANK() OVER(PARTITION BY user_id, DATE(call_time) ORDER BY call_time ASC) AS RN,
        DENSE_RANK() OVER(PARTITION BY user_id, DATE(call_time) ORDER BY call_time DESC) AS RK
    FROM cte
)

SELECT DISTINCT user_id
FROM cte1
WHERE RN = 1
OR RK = 1
GROUP BY user_id, DAY
HAVING COUNT(DISTINCT recipient_id) = 1;