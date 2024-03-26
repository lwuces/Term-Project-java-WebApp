CREATE TABLE Students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    studentid INT NOT NULL,
    firstname VARCHAR(250) NOT NULL,
    lastname VARCHAR(250) NOT NULL,
    email VARCHAR(250) NOT NULL,
    birth DATE NOT NULL
);