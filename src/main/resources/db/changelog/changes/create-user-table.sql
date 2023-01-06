--liquibase formatted sql
--changeset <root>:<create-user-table>

CREATE TABLE users (
                         id bigint NOT NULL AUTO_INCREMENT,
                         address varchar(255) DEFAULT NULL,
                         birthday varchar(255) DEFAULT NULL,
                         city varchar(255) DEFAULT NULL,
                         email varchar(255) DEFAULT NULL,
                         name varchar(255) DEFAULT NULL,
                         password varchar(255) DEFAULT NULL,
                         phone varchar(255) DEFAULT NULL,
                         registration_date_time datetime(6) DEFAULT NULL,
                         surname varchar(255) DEFAULT NULL,
                         shopping_cart_id bigint DEFAULT NULL,
                         PRIMARY KEY (id),
                         KEY FKpit3woesw8x1062syim3kei69 (shopping_cart_id),
                         CONSTRAINT FKpit3woesw8x1062syim3kei69 FOREIGN KEY (shopping_cart_id) REFERENCES shopping_carts (id)
);

--rollback DROP TABLE users;