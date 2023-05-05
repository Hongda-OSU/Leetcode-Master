# Write your MySQL query statement below
SELECT  transaction_id
FROM
(
	SELECT  * , DENSE_RANK() OVER (PARTITION BY DATE(day) ORDER BY amount DESC) as dt
	FROM    Transactions
	ORDER BY day ASC
) tmp
WHERE dt = 1
ORDER BY transaction_id ASC