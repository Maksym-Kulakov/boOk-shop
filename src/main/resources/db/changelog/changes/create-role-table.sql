--liquibase formatted sql
--changeset <root>:<create-role-table>

CREATE TABLE roles (
                         id bigint NOT NULL AUTO_INCREMENT,
                         role_name varchar(255) DEFAULT NULL,
                         PRIMARY KEY (id),
                         UNIQUE KEY UK_716hgxp60ym1lifrdgp67xt5k (role_name)
);

--rollback DROP TABLE roles;