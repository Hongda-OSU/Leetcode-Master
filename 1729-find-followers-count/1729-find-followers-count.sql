# Write your MySQL query statement below
SELECT user_id,
    COUNT(DISTINCT follower_id) AS Followers_count
FROM Followers
GROUP BY user_id;