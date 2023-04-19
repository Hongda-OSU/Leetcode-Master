# Write your MySQL query statement below
SELECT activity_date AS Day,
    COUNT(DISTINCT user_id) AS Active_users
FROM Activity
WHERE activity_date > "2019-06-27"
    AND activity_date <= "2019-07-27"
GROUP BY activity_date;