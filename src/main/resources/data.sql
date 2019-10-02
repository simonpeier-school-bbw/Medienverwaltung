INSERT INTO user (id, name , surname, username, password)
VALUES (1, 'hans', 'meier', 'user', '$2a$10$jgK/iszM3xKjkzcu0qH4wO.miIZ/drwybwVyp.3xSjyO5BdtKepLy');
-- password: password

INSERT INTO user_roles (user_id, roles)
VALUES (1, 'ROLE_USER');

INSERT INTO medium (id, title ,publisher ,rating ,description)
VALUES (1, 'Terry Botter', 'halo', 'good', 'cool game!');

INSERT INTO book (id,author,pages, medium_id, user_id)
VALUES (1, 'D.J. Bowling', '300',1,1)