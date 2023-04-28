# Write your MySQL query statement below
SELECT DISTINCT a.account_id
FROM LogInfo a
JOIN LogInfo b
ON a.account_id = b.account_id
AND a.ip_address != b.ip_address
AND ((
    a.logout BETWEEN b.login AND b.logout
) OR (
    b.logout BETWEEN a.login AND a.logout
));