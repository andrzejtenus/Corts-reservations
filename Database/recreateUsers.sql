CREATE USER 'user'@'localhost' IDENTIFIED BY 'userPassword';
GRANT ALL PRIVILEGES ON kortyapp.* TO 'user'@'localhost';
FLUSH PRIVILEGES;