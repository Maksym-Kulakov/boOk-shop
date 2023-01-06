--liquibase formatted sql
--changeset <root>:<create-author-table>

INSERT INTO authors (name, surname) VALUES ('Max', 'Kulakov');

--rollback DELETE FROM authors;