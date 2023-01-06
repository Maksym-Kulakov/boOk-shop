--liquibase formatted sql
--changeset <root>:<create-book-author-table>

CREATE TABLE IF NOT EXISTS books_authors (
                                 book_id bigint NOT NULL,
                                 authors_id bigint NOT NULL,
                                 KEY FK20menrngp9wi9at1dsu5cbb8o (authors_id),
                                 KEY FK1b933slgixbjdslgwu888m34v (book_id),
                                 CONSTRAINT FK1b933slgixbjdslgwu888m34v FOREIGN KEY (book_id) REFERENCES books (id),
                                 CONSTRAINT FK20menrngp9wi9at1dsu5cbb8o FOREIGN KEY (authors_id) REFERENCES authors (id)
);

--rollback DROP TABLE books_authors;