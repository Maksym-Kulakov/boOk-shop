--liquibase formatted sql
--changeset <root>:<create-books_authors-table>

INSERT INTO books_authors (book_id, authors_id) VALUES (2, 1);
INSERT INTO books_authors (book_id, authors_id) VALUES (3, 2);
INSERT INTO books_authors (book_id, authors_id) VALUES (4, 3);
INSERT INTO books_authors (book_id, authors_id) VALUES (5, 4);
INSERT INTO books_authors (book_id, authors_id) VALUES (6, 5);
INSERT INTO books_authors (book_id, authors_id) VALUES (7, 6);
INSERT INTO books_authors (book_id, authors_id) VALUES (8, 7);
INSERT INTO books_authors (book_id, authors_id) VALUES (9, 1);
INSERT INTO books_authors (book_id, authors_id) VALUES (10, 2);
INSERT INTO books_authors (book_id, authors_id) VALUES (11, 3);
INSERT INTO books_authors (book_id, authors_id) VALUES (12, 4);

--rollback DELETE FROM books_authors;