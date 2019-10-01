insert into entry (check_in , check_out)
values (parsedatetime('12-02-2009 23:33:22.00', 'dd-MM-yyyy HH:mm:ss.SS'), parsedatetime('12-02-2019 23:33:22.00','dd-MM-yyyy HH:mm:ss.SS'));

INSERT INTO user (id, username, password)
VALUES (1, 'user', '$2a$10$jgK/iszM3xKjkzcu0qH4wO.miIZ/drwybwVyp.3xSjyO5BdtKepLy');
-- password: password

INSERT INTO user_roles (user_id, roles)
VALUES (1, 'ROLE_USER');