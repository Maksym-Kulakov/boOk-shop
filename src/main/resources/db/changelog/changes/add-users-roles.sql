--liquibase formatted sql
--changeset <root>:<create-users_roles-table>

INSERT INTO users_roles (user_id, roles_id) VALUES (1, 1);

--rollback DELETE FROM users_roles;