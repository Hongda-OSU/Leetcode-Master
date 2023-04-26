# Write your MySQL query statement below
SELECT student.student_id,
    student.student_name,
    subject.subject_name,
    COUNT(exam.subject_name) AS attended_exams
FROM Students student
JOIN Subjects subject
LEFT JOIN Examinations exam
ON student.student_id = exam.student_id 
AND subject.subject_name = exam.subject_name
GROUP BY student.student_id, subject.subject_name
ORDER BY student_id, subject_name;