# Write your MySQL query statement below
SELECT username,
    activity,
    startDate,
    endDate
FROM
(
    SELECT *,
        COUNT(activity) OVER (PARTITION BY username) cnt,
        ROW_NUMBER() OVER (PARTITION BY username ORDER BY startDate DESC) n
    FROM UserActivity
) tbl
WHERE n = 2 or cnt < 2;