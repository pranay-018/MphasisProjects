
create database online_quiz;
use online_quiz;
CREATE TABLE admin (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL, 
    name VARCHAR(100)
);


alter table admin auto_increment = 100;

insert into admin (username , password ,name ) values ('pranay','pranay@18','pranay reddy');

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL
);

alter table users  auto_increment = 200;


CREATE TABLE questions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    question_text VARCHAR(500) NOT NULL,
    option_a VARCHAR(200) NOT NULL,
    option_b VARCHAR(200) NOT NULL,
    option_c VARCHAR(200) NOT NULL,
    option_d VARCHAR(200) NOT NULL,
    correct_option CHAR(1) NOT NULL  
);

alter table questions  auto_increment = 300;



	CREATE TABLE quiz (
		id INT AUTO_INCREMENT PRIMARY KEY,
		name VARCHAR(100) NOT NULL
	);

alter table quiz  auto_increment = 400;


CREATE TABLE quiz_questions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    quiz_id INT NOT NULL,
    question_id INT NOT NULL,
    FOREIGN KEY (quiz_id) REFERENCES quiz(id),
    FOREIGN KEY (question_id) REFERENCES questions(id)
);

alter table quiz_questions  auto_increment = 500;


CREATE TABLE user_quiz_score (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    quiz_id INT NOT NULL,
    score INT NOT NULL,
    total_questions INT NOT NULL,
    attempted_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (quiz_id) REFERENCES quiz(id)
);

alter table user_quiz_score  auto_increment = 600;

select * from users;

INSERT INTO quiz (name) VALUES
('Java Basics Quiz'),
('Cricket Basics Quiz'),
('HR Basics Quiz');

INSERT INTO questions
(question_text, option_a, option_b, option_c, option_d, correct_option)
VALUES
('Java is a ___ language','Low level','High level','Assembly','Machine','B'),
('Which keyword creates an object?','class','new','this','static','B'),
('Which is not a primitive type?','int','float','String','char','C'),
('Which package is auto imported?','java.util','java.io','java.lang','java.sql','C'),
('Method overloading occurs at?','Runtime','Compile time','Both','None','B'),
('Which keyword prevents inheritance?','static','private','final','abstract','C'),
('Which exception is unchecked?','IOException','SQLException','NullPointerException','FileNotFound','C'),
('JDK contains?','JRE','JVM','Compiler','All','D'),
('Interface supports?','Multiple inheritance','Single','None','Abstract','A'),
('Which operator compares values?','==','=','!=','&&','A');

INSERT INTO questions
(question_text, option_a, option_b, option_c, option_d, correct_option)
VALUES
('Cricket originated in?','India','England','Australia','SA','B'),
('Players in a cricket team?','9','10','11','12','C'),
('Balls in an over?','4','5','6','8','C'),
('ODI overs per side?','20','40','50','60','C'),
('Who is Captain Cool?','Kohli','Dhoni','Rohit','Sachin','B'),
('T20 has how many overs?','10','15','20','25','C'),
('2011 World Cup winner?','Australia','India','Sri Lanka','England','B'),
('LBW stands for?','Leg Before Wicket','Long Bat Win','Left Ball Wide','None','A'),
('Hat-trick means?','3 runs','3 wickets','3 overs','3 fours','B'),
('Longest format of cricket?','T20','ODI','Test','Hundred','C');





INSERT INTO questions
(question_text, option_a, option_b, option_c, option_d, correct_option)
VALUES
('HR stands for?','Human Resource','High Rank','Human Relation','None','A'),
('Recruitment means?','Hiring','Training','Payroll','Exit','A'),
('Payroll deals with?','Salary','Leave','Hiring','Training','A'),
('HR interview checks?','Skill','Behavior','Attitude','All','D'),
('Performance appraisal is?','Evaluation','Hiring','Training','Exit','A'),
('Employee engagement improves?','Loss','Turnover','Productivity','Conflict','C'),
('Exit interview occurs during?','Joining','Promotion','Resignation','Training','C'),
('HR policy defines?','Rules','Salary','Leave','All','D'),
('Training improves?','Skill','Cost','Risk','Conflict','A'),
('Labour laws apply to?','Employees','Employers','Both','None','C');


INSERT INTO quiz_questions (quiz_id, question_id)
SELECT q.id, qs.id
FROM quiz q
JOIN questions qs
WHERE q.name = 'Java Basics Quiz'
AND qs.question_text IN (
 'Java is a ___ language',
 'Which keyword creates an object?',
 'Which is not a primitive type?',
 'Which package is auto imported?',
 'Method overloading occurs at?',
 'Which keyword prevents inheritance?',
 'Which exception is unchecked?',
 'JDK contains?',
 'Interface supports?',
 'Which operator compares values?'
);


INSERT INTO quiz_questions (quiz_id, question_id)
SELECT q.id, qs.id
FROM quiz q
JOIN questions qs
WHERE q.name = 'Cricket Basics Quiz'
AND qs.question_text IN (
 'Cricket originated in?',
 'Players in a cricket team?',
 'Balls in an over?',
 'ODI overs per side?',
 'Who is Captain Cool?',
 'T20 has how many overs?',
 '2011 World Cup winner?',
 'LBW stands for?',
 'Hat-trick means?',
 'Longest format of cricket?'
);


INSERT INTO quiz_questions (quiz_id, question_id)
SELECT q.id, qs.id
FROM quiz q
JOIN questions qs
WHERE q.name = 'HR Basics Quiz'
AND qs.question_text IN (
 'HR stands for?',
 'Recruitment means?',
 'Payroll deals with?',
 'HR interview checks?',
 'Performance appraisal is?',
 'Employee engagement improves?',
 'Exit interview occurs during?',
 'HR policy defines?',
 'Training improves?',
 'Labour laws apply to?'
);

INSERT INTO admin (username, password, name)
VALUES ('admin1', 'admin@123', 'Main Admin');
