# Write your MySQL query statement below
SELECT order_id
FROM OrdersDetails
GROUP BY order_id
HAVING MAX(quantity) > ALL (
    SELECT (SUM(quantity) / COUNT(DISTINCT product_id)) AS avg_quant_order
    FROM OrdersDetails
    GROUP BY order_id
)
ORDER BY order_id ASC;