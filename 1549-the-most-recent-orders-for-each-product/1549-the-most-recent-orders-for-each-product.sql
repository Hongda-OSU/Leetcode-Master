# Write your MySQL query statement below
SELECT b.product_name,
    a.product_id,
    a.order_id,
    a.order_date
FROM Orders a
JOIN Products b
ON a.product_id = b.product_id
WHERE (a.product_id, a.order_date)
IN (
    SELECT product_id,
        MAX(order_date) AS order_date
    FROM Orders
    GROUP BY product_id
)
ORDER BY b.product_name, a.product_id, a.order_id;