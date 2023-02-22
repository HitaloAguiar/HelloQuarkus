-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-1');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-2');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-3');

insert into Livro (id, titulo, genero, isbn, dataDeLancamento, nomeDoAutor)
values (nextval('hibernate_sequence'), 'Vinte Mil Léguas Submarinas', 'ficção científica', '1233214566549',
        '1869-09-22', 'Júlio Verne');

insert into Livro (id, titulo, genero, isbn, dataDeLancamento, nomeDoAutor)
values (nextval('hibernate_sequence'), 'Don Quixote', 'aventura', '0988907655672', '1603-10-07',
        'Miguel de Cervantes');