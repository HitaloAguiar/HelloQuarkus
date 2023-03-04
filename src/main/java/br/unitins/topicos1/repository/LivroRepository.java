package br.unitins.topicos1.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.unitins.topicos1.model.Livro;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class LivroRepository implements PanacheRepository<Livro> {
    
    public List<Livro> findByTitulo(String titulo) {

        return find("from Livro where upper(titulo) like ?1", "%" + titulo.toUpperCase() + "%").list();
    }
}
