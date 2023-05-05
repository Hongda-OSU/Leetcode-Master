# Write your MySQL query statement below
WITH cte AS 
(
    SELECT user1_id,
        user2_id
    FROM Friendship
    UNION
    SELECT user2_id,
        user1_id
    FROM Friendship
)

SELECT c1.user1_id,
    c2.user1_id AS user2_id,
    COUNT(*) AS common_friend 
FROM cte AS c1
JOIN cte AS c2
ON c1.user1_id < c2.user1_id
AND c1.user2_id = c2.user2_id
WHERE (c1.user1_id, c2.user1_id) IN
(
    SELECT *
    FROM Friendship
)
GROUP BY 1, 2
HAVING COUNT(*) >= 3;