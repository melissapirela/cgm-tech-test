CREATE TABLE IF NOT EXISTS patient (
  id integer NOT NULL,
  name varchar(150) NOT NULL,
  surname varchar(150) NOT NULL,
  dateOfBirth varchar(10) NOT NULL,
  socialSecurityNumber varchar(20) NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO patient(id, name, surname, dateOfBirth, socialSecurityNumber) VALUES (1, 'Sam', 'Smith', '10-02-1946', 'KG92I49230');
INSERT INTO patient(id, name, surname, dateOfBirth, socialSecurityNumber) VALUES (2, 'John', 'Stevens', '15-10-1953', 'KG92I7463876');
INSERT INTO patient(id, name, surname, dateOfBirth, socialSecurityNumber) VALUES (3, 'Cate', 'Grant', '20-12-1977', 'KG92I85946');
INSERT INTO patient(id, name, surname, dateOfBirth, socialSecurityNumber) VALUES (4, 'Julia', 'Slater', '01-03-1980', 'KG92I25378');
INSERT INTO patient(id, name, surname, dateOfBirth, socialSecurityNumber) VALUES (5, 'Liam', 'Jones', '13-07-1962', 'KG92I037455');