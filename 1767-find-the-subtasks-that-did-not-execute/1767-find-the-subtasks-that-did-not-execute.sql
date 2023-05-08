# Write your MySQL query statement below
WITH RECURSIVE cte AS 
(
    SELECT task_id,
        subtasks_count
    FROM Tasks
    UNION ALL
    SELECT task_id,
        subtasks_count - 1
    FROM cte
    WHERE subtasks_count > 1
)

SELECT task_id,
    subtasks_count
AS subtask_id
FROM cte
WHERE (task_id, subtasks_count) NOT IN
(
    SELECT *
    FROM Executed
);