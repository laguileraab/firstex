INSERT INTO roles(name) VALUES('ROLE_OPERATOR');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');


INSERT INTO USERS(email,username,password) VALUES('admin@avangenio.com','avangenio','supersecretpassword');
INSERT INTO USER_ROLES(USER_ID,ROLE_ID) VALUES(1,2);