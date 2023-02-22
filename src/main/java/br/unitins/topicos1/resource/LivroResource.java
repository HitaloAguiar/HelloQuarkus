package br.unitins.topicos1.resource;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.unitins.topicos1.model.Livro;

@Path("/livros")
public class LivroResource {
    
    @GET
    public List<Livro> getAll() {

        return Livro.findAll().list();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Livro insert (Livro livro) {

        livro.persist();

        return livro;
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Livro update (@PathParam ("id") Long id, Livro livro) {

        Livro entity = Livro.findById(id);

        entity.setTitulo(livro.getTitulo());

        entity.setGenero(livro.getGenero());

        entity.setIsbn(livro.getIsbn());

        entity.setDataDeLancamento(livro.getDataDeLancamento());

        entity.setNomeDoAutor(livro.getNomeDoAutor());

        return entity;
    }
}
