package br.unitins.topicos1.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.unitins.topicos1.model.Editora;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class EditoraRepository implements PanacheRepository<Editora> {
    
    public List<Editora> findByNome(String nome) {

        if (nome == null)
            return null;

        return find("from Editora where upper(unaccent(nome)) like unaccent(?1)", "%" + nome.toUpperCase() + "%").list();
    }
}
