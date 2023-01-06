--liquibase formatted sql
--changeset <root>:<create-book-table>

CREATE TABLE IF NOT EXISTS books (
                         id bigint NOT NULL AUTO_INCREMENT,
                         country varchar(255) DEFAULT NULL,
                             in_stock bit(1) DEFAULT NULL,
                         price decimal(19,2) DEFAULT NULL,
                         description varchar(255) DEFAULT NULL,
                         genre varchar(255) DEFAULT NULL,
                         pages int NOT NULL,
                         title varchar(255) DEFAULT NULL,
                         PRIMARY KEY (id)
);

--rollback DROP TABLE books;