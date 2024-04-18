CREATE TABLE users (
    username varchar2(50) PRIMARY KEY,
    password varchar2(100) not null,
    enabled char(1) DEFAULT '1'
);

CREATE TABLE authorities (
    username varchar2(50) not null,
    authority varchar2(50) not null,
    CONSTRAINT fk_authorities_users FOREIGN KEY(username) REFERENCES users(username)
);

INSERT INTO users(username,password) VALUES ('admin','admin');
INSERT INTO users(username,password) VALUES ('user','user');
INSERT INTO users(username,password) VALUES ('member','member');

INSERT INTO authorities(username,authority) VALUES ('user','ROLE_USER');
INSERT INTO authorities(username,authority) VALUES ('member','ROLE_MANAGER');
INSERT INTO authorities(username,authority) VALUES ('admin','ROLE_MANAGER');
INSERT INTO authorities(username,authority) VALUES ('admin','ROLE_ADMIN');
INSERT INTO authorities(username,authority) VALUES ('admin','ROLE_USER');

SELECT * from users;

SELECT * from authorities;

DELETE FROM authorities WHERE authority='ROLE_USER';

commit;
rollback;
