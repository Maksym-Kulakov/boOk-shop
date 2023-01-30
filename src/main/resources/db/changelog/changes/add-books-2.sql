--liquibase formatted sql
--changeset <root>:<create-book-table>

INSERT INTO books (country, in_stock, price, title, genre, pages, description) VALUES ('Greechland', true, 200, 'Troy1', 'ACTION', 1299, 'Ahiles1');
INSERT INTO books (country, in_stock, price, title, genre, pages, description) VALUES ('Italy', true, 300, 'Troy2', 'ADVENTURE', 299, 'Ahiles2');
INSERT INTO books (country, in_stock, price, title, genre, pages, description) VALUES ('Ukraine', true, 600, 'Troy3', 'COMEDY', 299, 'Ahiles3');
INSERT INTO books (country, in_stock, price, title, genre, pages, description) VALUES ('Germany', true, 100, 'Troy4', 'CRIME', 259, 'Ahiles4');
INSERT INTO books (country, in_stock, price, title, genre, pages, description) VALUES ('France', true, 700, 'Troy5', 'FANTASY', 199, 'Ahiles5');
INSERT INTO books (country, in_stock, price, title, genre, pages, description) VALUES ('Polen', true, 1000, 'Troy6', 'HISTORICAL', 249, 'Ahiles6');
INSERT INTO books (country, in_stock, price, title, genre, pages, description) VALUES ('England', true, 900, 'Troy7', 'SCIENCE', 599, 'Ahiles7');
INSERT INTO books (country, in_stock, price, title, genre, pages, description) VALUES ('Spain', true, 200, 'Troy8', 'HISTORICAL', 296, 'Ahiles8');
INSERT INTO books (country, in_stock, price, title, genre, pages, description) VALUES ('USA', true, 400, 'Troy9', 'COMEDY', 25, 'Ahiles9');
INSERT INTO books (country, in_stock, price, title, genre, pages, description) VALUES ('Canada', true, 600, 'Troy10', 'ADVENTURE', 295, 'Ahiles10');
INSERT INTO books (country, in_stock, price, title, genre, pages, description) VALUES ('Australia', true, 500, 'Troy11', 'ACTION', 1299, 'Ahiles11');

--rollback DELETE FROM books;