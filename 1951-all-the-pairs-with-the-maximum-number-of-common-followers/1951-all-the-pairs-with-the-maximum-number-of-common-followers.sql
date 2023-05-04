# Write your MySQL query statement below
SELECT user1_id, 
    user2_id
FROM (
    SELECT r1.user_id AS user1_id,
        r2.user_id AS user2_id,
        dense_rank() OVER(ORDER BY COUNT(r1.follower_id) DESC) AS rk
    FROM Relations r1,
        Relations r2
    WHERE r1.user_id < r2.user_id
    AND r1.follower_id = r2.follower_id
    GROUP BY r1.user_id, 
        r2.user_id
) temp
where rk = 1;