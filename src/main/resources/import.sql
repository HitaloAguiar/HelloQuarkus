-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-1');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-2');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-3');

insert into Livro (titulo, isbn, genero, dataDeLancamento, nomeDoAutor)
        values ('Vinte Mil Léguas Submarinas', '1233214566549', 'ficção científica', '1869-09-22',
                'Júlio Verne');

insert into Livro (titulo, isbn, genero, dataDeLancamento, nomeDoAutor)
        values ('Don Quixote', '0988907655672', 'aventura', '1603-10-07', 'Miguel de Cervantes');

insert into Livro (titulo, isbn, genero, dataDeLancamento, nomeDoAutor)
        values ('Alice no País das Maravilhas', '83912397934', 'aventura', '1893-11-26',
                'Lewis Carrol');

insert into Livro (titulo, isbn, genero, dataDeLancamento, nomeDoAutor)
        values ('Drácula', '63923409283', 'Terror', '1891-04-13', 'Bram Stoker');

insert into Livro (titulo, isbn, genero, dataDeLancamento, nomeDoAutor)
        values ('Os Três Mosqueteiros', '0728123295', 'ação', '1827-01-02', 'Alexandre Dumas');

insert into Livro (titulo, isbn, genero, dataDeLancamento, nomeDoAutor)
        values ('Sherlock Holmes: Um Estudo em Vermelho', '7461830236', 'mistério', '1891-05-12',
                'sir Arhur Conan Doyle');