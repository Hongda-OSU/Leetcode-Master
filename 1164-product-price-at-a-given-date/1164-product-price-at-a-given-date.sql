# Write your MySQL query statement below
SELECT DISTINCT product_id,
    10 as price
FROM Products
GROUP BY product_id
HAVING (MIN(change_date) > "2019-08-16")
UNION
SELECT p2.product_id,
    new_price
FROM Products p2
WHERE (p2.product_id, p2.change_date) IN (
    SELECT product_id,
        MAX(change_date) AS recent_date
    FROM Products
    WHERE change_date <= "2019-08-16"
    GROUP BY product_id
);