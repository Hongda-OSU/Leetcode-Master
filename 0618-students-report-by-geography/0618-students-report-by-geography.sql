# Write your MySQL query statement below
SELECT 
    MAX((CASE WHEN x.continent = 'America' THEN x.name ELSE NULL END)) AS "America",
    MAX((CASE WHEN x.continent = 'Asia' THEN x.name ELSE NULL END)) AS "Asia",
     MAX((CASE WHEN x.continent = 'Europe' THEN x.name ELSE NULL END)) AS "Europe"
FROM
(
    SELECT s.continent,
        s.name,
        ROW_NUMBER() OVER(PARTITION BY s.continent ORDER BY s.name) AS rn
    FROM Student s
) x
GROUP BY x.rn;