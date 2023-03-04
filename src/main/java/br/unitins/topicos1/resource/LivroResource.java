package br.unitins.topicos1.resource;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.unitins.topicos1.model.Livro;
import br.unitins.topicos1.repository.LivroRepository;

@Path("/livros")
public class LivroResource {

    @Inject
    private LivroRepository repository;
    
    @GET
    public List<Livro> getAll() {

        return repository.findAll().list();
    }

    @GET
    @Path("/{id}")
    public Livro get(@PathParam ("id") Long id) {

        Livro livro = repository.findById(id);

        if (repository.isPersistent(livro))        
            return livro;

        return null;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Livro insert (Livro livro) {

        repository.persist(livro);

        return livro;
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public void delete(@PathParam ("id") Long id) {

        Livro livro = repository.findById(id);

        if (repository.isPersistent(livro))
            repository.delete(livro);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Livro update (@PathParam ("id") Long id, Livro livro) {

        Livro entity = repository.findById(id);

        entity.setTitulo(livro.getTitulo());

        entity.setGenero(livro.getGenero());

        entity.setIsbn(livro.getIsbn());

        entity.setDataDeLancamento(livro.getDataDeLancamento());

        entity.setNomeDoAutor(livro.getNomeDoAutor());

        return entity;
    }

    @GET
    @Path("/search/{titulo}")
    public List<Livro> searchByTitulo(@PathParam("titulo") String titulo) {

        return repository.findByTitulo(titulo);
    }
}
