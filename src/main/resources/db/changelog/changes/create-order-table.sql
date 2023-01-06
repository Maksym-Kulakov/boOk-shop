--liquibase formatted sql
--changeset <root>:<create-order-table>

CREATE TABLE orders (
                          id bigint NOT NULL AUTO_INCREMENT,
                          order_time datetime(6) DEFAULT NULL,
                          user_id bigint DEFAULT NULL,
                          PRIMARY KEY (id),
                          KEY FK32ql8ubntj5uh44ph9659tiih (user_id)
);

--rollback DROP TABLE orders;