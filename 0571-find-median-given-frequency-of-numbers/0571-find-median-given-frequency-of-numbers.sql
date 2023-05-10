# Write your MySQL query statement below
SELECT AVG(n.num) MEDIAN
FROM Numbers n
WHERE n.frequency >= ABS((SELECT SUM(frequency) FROM Numbers WHERE num <= n.num) - (SELECT SUM(frequency) FROM Numbers WHERE num >= n.num));