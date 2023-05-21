SELECT
  MAX((CASE WHEN X.continent = 'America' THEN X.name ELSE NULL END)) AS "America",
  MAX((CASE WHEN X.continent = 'Asia' THEN X.name ELSE NULL END)) AS "Asia",
  MAX((CASE WHEN X.continent = 'Europe' THEN X.name ELSE NULL END)) AS "Europe"
FROM
  (
    SELECT
      S.continent,
      S.name,
      ROW_NUMBER() OVER(PARTITION BY S.continent ORDER BY S.name) AS rn
    FROM
      student S
  ) X
GROUP BY
  X.rn;