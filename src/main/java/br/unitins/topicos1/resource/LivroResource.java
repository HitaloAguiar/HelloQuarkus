package br.unitins.topicos1.resource;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.unitins.topicos1.application.Result;
import br.unitins.topicos1.dto.LivroDTO;
import br.unitins.topicos1.dto.LivroResponseDTO;
import br.unitins.topicos1.service.LivroService;

@Path("/livros")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LivroResource {

    @Inject
    LivroService livroService;
    
    @GET
    public List<LivroResponseDTO> getAll() {

        return livroService.getAll();
    }

    @GET
    @Path("/{id}")
    public LivroResponseDTO getById(@PathParam ("id") Long id) {

        return livroService.getById(id);
    }

    @POST
    @Transactional
    public Response insert (LivroDTO livroDto) {

        try {

            return Response
                    .status(201)
                    .entity(livroService.insert(livroDto))
                    .build();
        } catch (ConstraintViolationException e) {

            return Response
                    .status(404)
                    .entity(new Result(e.getConstraintViolations()))
                    .build();
        }
    }
    
    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(@PathParam ("id") Long id) {

        livroService.delete(id);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response update (@PathParam ("id") Long id, LivroDTO livroDto) {

        try {

            livroService.update(id, livroDto);

            return Response
                    .status(204)
                    .build();
        } catch (ConstraintViolationException e) {

            return Response
                    .status(404)
                    .entity(new Result(e.getConstraintViolations()))
                    .build();
        }
    }
    
    @GET
    @Path("/search/{titulo}")
    public List<LivroResponseDTO> getByTitulo(@PathParam("titulo") String titulo) {

        return livroService.getByTitulo(titulo);
    }
}
