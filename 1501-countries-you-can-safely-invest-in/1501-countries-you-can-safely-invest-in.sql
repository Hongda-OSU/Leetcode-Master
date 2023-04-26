# Write your MySQL query statement below
SELECT co.name AS country
FROM Person p
JOIN Country co
ON SUBSTRING(phone_number, 1, 3) = country_code
JOIN Calls ca
ON p.id IN (ca.caller_id, ca.callee_id)
GROUP BY co.name
HAVING AVG(duration) > (
    SELECT AVG(duration)
    FROM Calls
);