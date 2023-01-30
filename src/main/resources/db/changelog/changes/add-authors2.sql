--liquibase formatted sql
--changeset <root>:<create-author-table>

INSERT INTO authors (name, surname) VALUES ('Valeriia', 'Kulakova');
INSERT INTO authors (name, surname) VALUES ('Danyil', 'Kulakov');
INSERT INTO authors (name, surname) VALUES ('Chistof', 'Kunzman');
INSERT INTO authors (name, surname) VALUES ('Katy', 'Bukatich');
INSERT INTO authors (name, surname) VALUES ('Anait', 'Bulka');
INSERT INTO authors (name, surname) VALUES ('Pizda', 'Pot');

--rollback DELETE FROM authors;