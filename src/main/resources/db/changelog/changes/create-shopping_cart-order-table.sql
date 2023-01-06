--liquibase formatted sql
--changeset <root>:<create-shopping_cart-order-table>

CREATE TABLE shopping_carts_orders (
                                         shopping_cart_id bigint NOT NULL,
                                         orders_id bigint NOT NULL,
                                         UNIQUE KEY UK_ouskmtrl40lq1fssvgjcy3huo (orders_id),
                                         KEY FK9h1uvlhhne0gsv36jrd0a2n7s (shopping_cart_id),
                                         CONSTRAINT FK56v5laq1xx9mh62o65b8pk572 FOREIGN KEY (orders_id) REFERENCES orders (id),
                                         CONSTRAINT FK9h1uvlhhne0gsv36jrd0a2n7s FOREIGN KEY (shopping_cart_id) REFERENCES shopping_carts (id)
);


--rollback DROP TABLE shopping_carts_orders;