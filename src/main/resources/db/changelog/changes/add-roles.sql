--liquibase formatted sql
--changeset <root>:<create-role-table>

INSERT INTO roles (role_name) VALUES ('USER');
INSERT INTO roles (role_name) VALUES ('ADMIN');

--rollback DELETE FROM roles;