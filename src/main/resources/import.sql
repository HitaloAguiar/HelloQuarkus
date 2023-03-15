-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-1');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-2');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-3');

INSERT INTO Editora (nome, cnpj) values ('Darkside', '12.345.678/0001-00');

INSERT INTO Editora (nome, cnpj) values ('Zahar', '45.892.013/0001-04');

INSERT INTO Editora (nome, cnpj) values ('Intríseca', '14.074.638/0001-09');

INSERT INTO Editora (nome, cnpj) values ('Principis', '64.092.142/0001-51');

INSERT INTO Livro (titulo, isbn, genero, dataDeLancamento, nomeDoAutor, id_editora)
        values ('Vinte Mil Léguas Submarinas', '123-3-21-456654-9', 'ficção científica', '1869-09-22',
                'Júlio Verne', 2);

INSERT INTO Livro (titulo, isbn, genero, dataDeLancamento, nomeDoAutor, id_editora)
        values ('Don Quixote', '098-8-90-765567-2', 'aventura', '1603-10-07', 'Miguel de Cervantes', 4);

INSERT INTO Livro (titulo, isbn, genero, dataDeLancamento, nomeDoAutor, id_editora)
        values ('Alice no País das Maravilhas', '839-1-23-979380-4', 'aventura', '1893-11-26',
                'Lewis Carrol', 1);

INSERT INTO Livro (titulo, isbn, genero, dataDeLancamento, nomeDoAutor, id_editora)
        values ('Drácula', '639-2-34-092809-3', 'Terror', '1891-04-13', 'Bram Stoker', 1);

INSERT INTO Livro (titulo, isbn, genero, dataDeLancamento, nomeDoAutor, id_editora)
        values ('Os Três Mosqueteiros', '072-8-12-329456-5', 'ação', '1827-01-02', 'Alexandre Dumas', 2);

INSERT INTO Livro (titulo, isbn, genero, dataDeLancamento, nomeDoAutor, id_editora)
        values ('Sherlock Holmes: Um Estudo em Vermelho', '746-1-83-023478-6', 'mistério', '1891-05-12',
                'sir Arhur Conan Doyle', 2);