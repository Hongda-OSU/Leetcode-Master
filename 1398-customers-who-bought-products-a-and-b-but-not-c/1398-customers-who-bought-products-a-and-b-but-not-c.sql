# Write your MySQL query statement below
SELECT a.customer_id,
    a.customer_name
FROM Customers a, 
    Orders b
WHERE a.customer_id = b.customer_id
GROUP BY a.customer_id
HAVING SUM(b.product_name = "A") > 0
    AND SUM(b.product_name = "B") > 0
    AND SUM(b.product_name = "C") = 0;