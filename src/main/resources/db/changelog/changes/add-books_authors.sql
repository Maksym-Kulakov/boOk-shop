--liquibase formatted sql
--changeset <root>:<create-books_authors-table>

INSERT INTO books_authors (book_id, authors_id) VALUES (1, 1);

--rollback DELETE FROM books_authors;