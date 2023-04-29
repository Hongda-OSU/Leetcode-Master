# Write your MySQL query statement below
SELECT pt1.id AS p1,
    pt2.id AS p2,
    ABS(pt2.x_value - pt1.x_value) * ABS(pt2.y_value - pt1.y_value) AS Area
FROM Points pt1
JOIN Points pt2
ON pt1.id < pt2.id
AND pt1.x_value != pt2.x_value
AND pt1.y_value != pt2.y_value
ORDER BY Area DESC, p1 ASC, p2 ASC;