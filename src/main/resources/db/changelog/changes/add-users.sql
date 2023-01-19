--liquibase formatted sql
--changeset <root>:<create-user-table>

INSERT INTO users (name, surname, email, password) VALUES ('Lera', 'Kulakova', 'val@gmail.com', '1234');

--rollback DELETE FROM users;