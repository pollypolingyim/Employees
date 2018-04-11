USE Registrar;

SET SQL_SAFE_UPDATES = 0;

DELETE FROM ClassRep;
DELETE FROM Tuition;
DELETE FROM Students;
DELETE FROM Registry;
DELETE FROM Courses;

SET SQL_SAFE_UPDATES = 1;

INSERT INTO `Courses` (`course_num`, `name`) VALUES
('MAT8001C', 'Technical Math for Computer Science'),
('CST8101', 'Computer Essentials'),
('CST8300', 'Achieving Success in Changing Environments'),
('CST8110', 'Intro to Computer Programing'),
('CST8215', 'Database'),
('ENL1813T', 'Communications I'),
('GED0336', 'Gen. Ed. Elective'),
('CST8102', 'Operating System Fund.'),
('CST8284', 'OOP'),
('CST8285', 'Web Programing'),
('CST2355', 'Database Systems'),
('ENL2019T', 'Technical Communication for Eng. Tech.'),
('CST8109', 'Network Programing'),
('CST8288', 'OOP II'),
('CST2335', 'Mobile Graphical Interface Programing'),
('CST2234', 'System Analysis and Design'),
('CST8283', 'Business Programming(Cobol)'),
('CST8130', 'Data Structures'),
('CST8234', 'C Language and Network Programming'),
('CST8390', 'Business Intelligence and Data Analytics'),
('CST8333', 'Programing Language Research Project'),
('CST8277', 'Enterprise Appl. Programing'),
('CST8334', 'Software Development Project'),
('CST8276', 'Advanced Database Topics');

INSERT INTO `Students` (`student_num`, `first_name`, `last_name`, `date_birth`, `enrolled`) VALUES (100000001, 'John', 'Doe', '1900-01-01', '2017-09-01');

INSERT INTO `ClassRep` (`student_num`, `course_num`, `term`, `year`) VALUES (100000001, 'CST8288', 'F', 17);

INSERT INTO `Tuition` (`student_num`, `paid`, `remainder`) VALUES (100000001, 10000, 15000);

INSERT INTO `Registry` (`student_num`, `course_num`, `term`, `year`) VALUES (100000001, 'CST8288', 'F', 17);