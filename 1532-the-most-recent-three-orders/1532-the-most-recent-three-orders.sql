# Write your MySQL query statement below
SELECT a.name AS customer_name,
    a.customer_id,
    b.order_id,
    b.order_date
FROM Customers AS a
JOIN Orders AS b
ON a.customer_id = b.customer_id
JOIN Orders AS c
ON b.customer_id = c.customer_id 
AND b.order_date <= c.order_date
GROUP BY a.customer_id, b.order_id
HAVING COUNT(c.order_date) <= 3
ORDER BY customer_name, customer_id, order_date DESC;