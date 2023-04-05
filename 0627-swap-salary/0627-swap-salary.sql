# Write your MySQL query statement below
UPDATE
    salary
SET
    sex = case sex
        when 'm' then 'f'
        else 'm'
    END