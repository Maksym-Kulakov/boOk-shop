--liquibase formatted sql
--changeset <root>:<create-shopping_cart-table>

CREATE TABLE shopping_carts (
                                  id bigint NOT NULL,
                                  PRIMARY KEY (id)
);

--rollback DROP TABLE shopping_carts;