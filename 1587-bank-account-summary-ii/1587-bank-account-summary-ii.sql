# Write your MySQL query statement below
SELECT a.name,
    SUM(b.amount) AS balance
FROM Transactions b
JOIN Users a
ON a.account = b.account
GROUP BY a.account
HAVING balance > 10000;