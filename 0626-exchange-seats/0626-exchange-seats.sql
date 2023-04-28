# Write your MySQL query statement below
SELECT s1.id - 1 AS id,
    s1.student
FROM Seat s1
WHERE s1.id MOD 2 = 0

UNION 

SELECT s2.id + 1 AS id,
    s2.student
FROM Seat s2
WHERE s2.id MOD 2 = 1 
AND s2.id != (
    SELECT MAX(id)
    FROM Seat
)

UNION

SELECT s3.id,
    s3.student
FROM Seat s3
WHERE s3.id MOD 2 = 1 
AND s3.id = (
    SELECT MAX(id)
    FROM Seat
)
ORDER BY id ASC;