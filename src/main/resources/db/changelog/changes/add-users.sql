--liquibase formatted sql
--changeset <root>:<create-user-table>

INSERT INTO users (name, surname, email) VALUES ('Lera', 'Kulakova', 'val@gmail.com');

--rollback DELETE FROM users;