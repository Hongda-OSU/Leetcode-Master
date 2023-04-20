# Write your MySQL query statement below
SELECT player_id,
    MIN(event_date) AS First_login
FROM Activity
GROUP BY player_id;