--liquibase formatted sql
--changeset <root>:<create-order-book-table>

CREATE TABLE orders_books (
                                order_id bigint NOT NULL,
                                book_id bigint NOT NULL,
                                UNIQUE KEY UK_3e9xc89oblqedsluiowximnmm (book_id),
                                KEY FKol7arli7ptfejk3kwuo2n2mx3 (order_id),
                                CONSTRAINT FKol7arli7ptfejk3kwuo2n2mx3 FOREIGN KEY (order_id) REFERENCES orders (id)
);

--rollback DROP TABLE orders_books;