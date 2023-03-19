package br.unitins.topicos1.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import br.unitins.topicos1.dto.LivroDTO;
import br.unitins.topicos1.dto.LivroResponseDTO;
import br.unitins.topicos1.model.Livro;
import br.unitins.topicos1.repository.EditoraRepository;
import br.unitins.topicos1.repository.LivroRepository;

@ApplicationScoped
public class LivroImplService implements LivroService {

    @Inject
    LivroRepository livroRepository;

    @Inject
    EditoraRepository editoraRepository;

    @Inject
    Validator validator;

    @Override
    public List<LivroResponseDTO> getAll() {
        
        return livroRepository
                    .findAll()
                    .stream()
                    .map(LivroResponseDTO::new)
                    .collect(Collectors.toList());
    }

    @Override
    public LivroResponseDTO getById(Long id) {
        
        Livro livro = livroRepository.findById(id);

        if (livroRepository.isPersistent(livro))        
            return new LivroResponseDTO(livro);

        return null;
    }

    @Override
    public LivroResponseDTO insert(LivroDTO livroDto) throws ConstraintViolationException {
        
        validar(livroDto);

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

    @Override
    public void delete(Long id) {
        
        Livro livro = livroRepository.findById(id);

        if (livroRepository.isPersistent(livro))
            livroRepository.delete(livro);
    }

    @Override
    public LivroResponseDTO update(Long id, LivroDTO livroDto) throws ConstraintViolationException {
        
        validar(livroDto);

        Livro entity = livroRepository.findById(id);

        entity.setTitulo(livroDto.getTitulo());

        entity.setGenero(livroDto.getGenero());

        entity.setIsbn(livroDto.getIsbn());

        entity.setDataDeLancamento(livroDto.getDataDeLancamento());

        entity.setNomeDoAutor(livroDto.getNomeDoAutor());

        entity.setEditora(editoraRepository.findById(livroDto.getIdeditora()));

        return new LivroResponseDTO(entity);
    }

    @Override
    public List<LivroResponseDTO> getByTitulo(String titulo) {
        
        return livroRepository
                    .findByTitulo(titulo)
                    .stream()
                    .map(LivroResponseDTO::new)
                    .collect(Collectors.toList());
    }

    private void validar(LivroDTO livroDto) throws ConstraintViolationException {
        Set<ConstraintViolation<LivroDTO>> violations = validator.validate(livroDto);

        if (!(violations.isEmpty()))
            throw new ConstraintViolationException(violations);
    }
}
