package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.LivroDTO;
import br.unitins.topicos1.dto.LivroResponseDTO;

public interface LivroService {
    
    // recurso basico

    List<LivroResponseDTO> getAll();

    LivroResponseDTO getById(Long id);

    LivroResponseDTO insert (LivroDTO livroDto);

    void delete(Long id);

    LivroResponseDTO update (Long id, LivroDTO livroDto);

    // recursos extra

    public List<LivroResponseDTO> getByTitulo(String titulo);
}
