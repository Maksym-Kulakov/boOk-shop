--liquibase formatted sql
--changeset <root>:<create-shopping_cart-table-two>

ALTER TABLE shopping_carts
    ADD CONSTRAINT FKc1fbrvff059ke4p8ce3hu38oa
        FOREIGN KEY (id) REFERENCES users (id);

