# Write your MySQL query statement below
SELECT t.customer_id,
    t.product_id,
    product_name
FROM 
(
    SELECT customer_id,
        product_id,
        DENSE_RANK() OVER (PARTITION BY customer_id ORDER BY COUNT(*) DESC) prank
    FROM Orders
    GROUP BY 1, 2
) t
JOIN Products p 
ON p.product_id = t.product_id
WHERE prank = 1;