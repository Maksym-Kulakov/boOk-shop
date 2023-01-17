--liquibase formatted sql
--changeset <root>:<create-book-table>

INSERT INTO books (country, in_stock, price, title, genre, pages, description) VALUES ('Greechland', true, 444, 'Troy', 'HISTORICAL', 299, 'Ahiles');

--rollback DELETE FROM books;