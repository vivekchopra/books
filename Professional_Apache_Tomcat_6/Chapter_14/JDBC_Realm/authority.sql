CREATE DATABASE IF NOT EXISTS authority;

USE authority;

CREATE TABLE users (
   login VARCHAR(15) NOT NULL PRIMARY KEY,
   password VARCHAR(32) NOT NULL
);

CREATE TABLE user_roles (
   login VARCHAR(15) NOT NULL,
   role VARCHAR(10) NOT NULL,
   PRIMARY KEY (login, role)
);

INSERT INTO users (login, password) VALUES (‘maharaja’, MD5(‘tomcat’));
INSERT INTO user_roles (login, role) VALUES (‘maharaja’, ‘manager’);
