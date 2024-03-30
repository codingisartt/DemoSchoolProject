INSERT INTO `holidays` (`day`,`reason`,`type`,`created_at`, `created_by`)
VALUES (' Jan 1 ','New Year''s Day','FESTIVAL',CURDATE(),'DBA');

INSERT INTO `holidays` (`day`,`reason`,`type`,`created_at`, `created_by`)
VALUES (' Oct 31 ','Halloween','FESTIVAL',CURDATE(),'DBA');

INSERT INTO `holidays` (`day`,`reason`,`type`,`created_at`, `created_by`)
VALUES (' Nov 24 ','Thanksgiving Day','FESTIVAL',CURDATE(),'DBA');

INSERT INTO `holidays` (`day`,`reason`,`type`,`created_at`, `created_by`)
VALUES (' Dec 25 ','Christmas','FESTIVAL',CURDATE(),'DBA');

INSERT INTO `holidays` (`day`,`reason`,`type`,`created_at`, `created_by`)
VALUES (' Jan 17 ','Martin Luther King Jr. Day','FEDERAL',CURDATE(),'DBA');

INSERT INTO `holidays` (`day`,`reason`,`type`,`created_at`, `created_by`)
VALUES (' July 4 ','Independence Day','FEDERAL',CURDATE(),'DBA');

INSERT INTO `holidays` (`day`,`reason`,`type`,`created_at`, `created_by`)
VALUES (' Sep 5 ','Labor Day','FEDERAL',CURDATE(),'DBA');

INSERT INTO `holidays` (`day`,`reason`,`type`,`created_at`, `created_by`)
VALUES (' Nov 11 ','Veterans Day','FEDERAL',CURDATE(),'DBA');

INSERT INTO `roles` (`role_name`,`created_at`, `created_by`)
VALUES ('ADMIN',CURDATE(),'DBA');

INSERT INTO `roles` (`role_name`,`created_at`, `created_by`)
VALUES ('STUDENT',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`, `mobile_num`, `email`, `subject`, `message`, `status`, `created_at`, `created_by`)
VALUES
    ('John Smith', '5551234567', 'john.smith@example.com', 'Information Inquiry', 'I would like to inquire for more information about your school.', 'Open', NOW(), 'DBA');
INSERT INTO `contact_msg` (`name`, `mobile_num`, `email`, `subject`, `message`, `status`, `created_at`, `created_by`)
VALUES
    ('Emma Johnson', '5552345678', 'emma.johnson@example.com', 'Question for Application', 'I have some questions before applying as a student.', 'Open', NOW(), 'DBA');
INSERT INTO `contact_msg` (`name`, `mobile_num`, `email`, `subject`, `message`, `status`, `created_at`, `created_by`)
VALUES
    ('Michael Brown', '5553456789', 'michael.brown@example.com', 'Event Inquiry', 'I would like to know more about the events organized by your school.', 'Open', NOW(), 'DBA');
INSERT INTO `contact_msg` (`name`, `mobile_num`, `email`, `subject`, `message`, `status`, `created_at`, `created_by`)
VALUES
    ('Emily Davis', '5554567890', 'emily.davis@example.com', 'Information for Enrollment', 'I need information about the enrollment process.', 'Open', NOW(), 'DBA');
INSERT INTO `contact_msg` (`name`, `mobile_num`, `email`, `subject`, `message`, `status`, `created_at`, `created_by`)
VALUES
    ('James Wilson', '5555678901', 'james.wilson@example.com', 'Tuition Fee Inquiry', 'I would like to inquire about the tuition fees and payment options.', 'Open', NOW(), 'DBA');
INSERT INTO `contact_msg` (`name`, `mobile_num`, `email`, `subject`, `message`, `status`, `created_at`, `created_by`)
VALUES
    ('Sophia Miller', '5556789012', 'sophia.miller@example.com', 'Teacher Application', 'What documents are required for teacher application?', 'Open', NOW(), 'DBA');
INSERT INTO `contact_msg` (`name`, `mobile_num`, `email`, `subject`, `message`, `status`, `created_at`, `created_by`)
VALUES
    ('William Taylor', '5557890123', 'william.taylor@example.com', 'School Administration', 'Can I get information about your school\''s administrative team?', 'Open', NOW(), 'DBA');
INSERT INTO `contact_msg` (`name`, `mobile_num`, `email`, `subject`, `message`, `status`, `created_at`, `created_by`)
VALUES
    ('Olivia Martinez', '5558901234', 'olivia.martinez@example.com', 'School Facilities', 'I want to know about the facilities available at your school.', 'Open', NOW(), 'DBA');
INSERT INTO `contact_msg` (`name`, `mobile_num`, `email`, `subject`, `message`, `status`, `created_at`, `created_by`)
VALUES
    ('Ethan Anderson', '5559012345', 'ethan.anderson@example.com', 'Student Clubs', 'Can I get information about the student clubs active in your school?', 'Open', NOW(), 'DBA');
INSERT INTO `contact_msg` (`name`, `mobile_num`, `email`, `subject`, `message`, `status`, `created_at`, `created_by`)
VALUES
    ('Ava Thomas', '5550123456', 'ava.thomas@example.com', 'Exam Schedule', 'I want to know the exam schedule.', 'Open', NOW(), 'DBA');
INSERT INTO `contact_msg` (`name`, `mobile_num`, `email`, `subject`, `message`, `status`, `created_at`, `created_by`)
VALUES
    ('Noah Clark', '5551234567', 'noah.clark@example.com', 'Cafeteria Services', 'I want to get information about your cafeteria services.', 'Open', NOW(), 'DBA');
INSERT INTO `contact_msg` (`name`, `mobile_num`, `email`, `subject`, `message`, `status`, `created_at`, `created_by`)
VALUES
    ('Isabella Lewis', '5552345678', 'isabella.lewis@example.com', 'Transportation', 'How can I reach the school? What are the transportation options?', 'Open', NOW(), 'DBA');
INSERT INTO `contact_msg` (`name`, `mobile_num`, `email`, `subject`, `message`, `status`, `created_at`, `created_by`)
VALUES
    ('Mason Lee', '5553456789', 'mason.lee@example.com', 'Internship Application', 'I want to apply for an internship.', 'Open', NOW(), 'DBA');
INSERT INTO `contact_msg` (`name`, `mobile_num`, `email`, `subject`, `message`, `status`, `created_at`, `created_by`)
VALUES
    ('Mia Harris', '5554567890', 'mia.harris@example.com', 'Library Services', 'Can I get information about your library services?', 'Open', NOW(), 'DBA');
INSERT INTO `contact_msg` (`name`, `mobile_num`, `email`, `subject`, `message`, `status`, `created_at`, `created_by`)
VALUES
    ('Lucas Martin', '5555678901', 'lucas.martin@example.com', 'Study Abroad', 'I want to get information about study abroad programs.', 'Open', NOW(), 'DBA');
INSERT INTO `contact_msg` (`name`, `mobile_num`, `email`, `subject`, `message`, `status`, `created_at`, `created_by`)
VALUES
    ('Ella Walker', '5556789012', 'ella.walker@example.com', 'Social Responsibility Projects', 'Can I get information about your school''s social responsibility projects?', 'Open', NOW(), 'DBA');
INSERT INTO `contact_msg` (`name`, `mobile_num`, `email`, `subject`, `message`, `status`, `created_at`, `created_by`)
VALUES
    ('Benjamin Green', '5557890123', 'benjamin.green@example.com', 'Educational Programs', 'I want to get information about the educational programs offered by your school.', 'Open', NOW(), 'DBA');
INSERT INTO `contact_msg` (`name`, `mobile_num`, `email`, `subject`, `message`, `status`, `created_at`, `created_by`)
VALUES
    ('Avery Hill', '5558901234', 'avery.hill@example.com', 'Student Council', 'I want to get information about the student council of your school.', 'Open', NOW(), 'DBA');
INSERT INTO `contact_msg` (`name`, `mobile_num`, `email`, `subject`, `message`, `status`, `created_at`, `created_by`)
VALUES
    ('Sofia Young', '5559012345', 'sofia.young@example.com', 'Education Quality', 'Can I get information about the quality of education at your school?', 'Open', NOW(), 'DBA');
INSERT INTO `contact_msg` (`name`, `mobile_num`, `email`, `subject`, `message`, `status`, `created_at`, `created_by`)
VALUES
    ('Jackson Adams', '5550123456', 'jackson.adams@example.com', 'Campus Tour', 'Can I schedule a campus tour?', 'Open', NOW(), 'DBA');

