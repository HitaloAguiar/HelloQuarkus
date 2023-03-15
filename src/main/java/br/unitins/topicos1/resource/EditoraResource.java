package br.unitins.topicos1.resource;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import br.unitins.topicos1.model.Editora;
import br.unitins.topicos1.repository.EditoraRepository;

@Path("/editoras")
public class EditoraResource {
    
    @Inject
    EditoraRepository editoraRepository;

    @GET
    public List<Editora> getAll() {

        return editoraRepository.findAll().list();
    }

    @Path("/{id}")
    @GET
    public Editora getById(@PathParam("id") Long id) {

        Editora editora = editoraRepository.findById(id);

        if (editoraRepository.isPersistent(editora))
            return editora;

        return null;
    }

    @POST
    @Transactional    
    public Editora insert (@Valid Editora editora) {

        editoraRepository.persist(editora);

        return editora;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete (@PathParam("id") Long id) {

        Editora editora = editoraRepository.findById(id);

        if (editoraRepository.isPersistent(editora))
            editoraRepository.delete(editora);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Editora update (@PathParam ("id") Long id, @Valid Editora editora) {

        Editora entity = editoraRepository.findById(id);

        entity.setNome(editora.getNome());

        entity.setCnpj(editora.getCnpj());

        return entity;
    }

    @GET
    @Path("/search/{nome}")
    public List<Editora> searchByNome (@PathParam("nome") String nome) {

        return editoraRepository.findByNome(nome);
    }
}
