package br.unitins.topicos1.resource;

import java.util.List;
import java.util.stream.Collectors;

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

import br.unitins.topicos1.dto.LivroDTO;
import br.unitins.topicos1.dto.LivroResponseDTO;
import br.unitins.topicos1.model.Livro;
import br.unitins.topicos1.repository.EditoraRepository;
import br.unitins.topicos1.repository.LivroRepository;

@Path("/livros")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LivroResource {

    @Inject
    private LivroRepository livroRepository;

    @Inject
    private EditoraRepository editoraRepository;
    
    @GET
    public List<LivroResponseDTO> getAll() {

        return livroRepository.findAll().stream()
        .map(livro -> new LivroResponseDTO(livro))
        .collect(Collectors.toList());
    }

    @GET
    @Path("/{id}")
    public LivroResponseDTO get(@PathParam ("id") Long id) {

        Livro livro = livroRepository.findById(id);

        if (livroRepository.isPersistent(livro))        
            return new LivroResponseDTO(livro);

        return null;
    }

    @POST
    @Transactional
    public LivroResponseDTO insert (LivroDTO livroDto) {

        Livro livro = new Livro();

        livro.setTitulo(livroDto.getTitulo());

        livro.setIsbn(livroDto.getIsbn());

        livro.setGenero(livroDto.getGenero());

        livro.setDataDeLancamento(livroDto.getDataDeLancamento());

        livro.setNomeDoAutor(livroDto.getNomeDoAutor());

        livro.setEditora(editoraRepository.findById(livroDto.getIdeditora()));

        livroRepository.persist(livro);

        return new LivroResponseDTO(livro);
    }
    
    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(@PathParam ("id") Long id) {

        Livro livro = livroRepository.findById(id);

        if (livroRepository.isPersistent(livro))
            livroRepository.delete(livro);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public LivroResponseDTO update (@PathParam ("id") Long id, LivroDTO livroDto) {

        Livro entity = livroRepository.findById(id);

        entity.setTitulo(livroDto.getTitulo());

        entity.setGenero(livroDto.getGenero());

        entity.setIsbn(livroDto.getIsbn());

        entity.setDataDeLancamento(livroDto.getDataDeLancamento());

        entity.setNomeDoAutor(livroDto.getNomeDoAutor());

        entity.setEditora(editoraRepository.findById(livroDto.getIdeditora()));

        return new LivroResponseDTO(entity);
    }
    
    @GET
    @Path("/search/{titulo}")
    public List<LivroResponseDTO> searchByTitulo(@PathParam("titulo") String titulo) {

        return livroRepository.findByTitulo(titulo).stream()
        .map(livro -> new LivroResponseDTO(livro))
        .collect(Collectors.toList());
    }
}
