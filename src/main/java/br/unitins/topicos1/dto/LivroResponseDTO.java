package br.unitins.topicos1.dto;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import br.unitins.topicos1.model.Livro;

public class LivroResponseDTO {
    
    private Long id;
    private String titulo;
    private String isbn;
    private String genero;
    private LocalDate dataDeLancamento;
    private String nomeDoAutor;
    private Map<String, Object> editora;

    public LivroResponseDTO (Livro livro) {

        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.isbn = livro.getIsbn();
        this.genero = livro.getGenero();
        this.dataDeLancamento = livro.getDataDeLancamento();
        this.nomeDoAutor = livro.getNomeDoAutor();
        this.editora = new HashMap<String, Object>();

        this.editora.put("nome", livro.getEditora().getNome());
        this.editora.put("cnpj", livro.getEditora().getCnpj());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDate getDataDeLancamento() {
        return dataDeLancamento;
    }

    public void setDataDeLancamento(LocalDate dataDeLancamento) {
        this.dataDeLancamento = dataDeLancamento;
    }

    public String getNomeDoAutor() {
        return nomeDoAutor;
    }

    public void setNomeDoAutor(String nomeDoAutor) {
        this.nomeDoAutor = nomeDoAutor;
    }

    public Map<String, Object> getEditora() {
        return editora;
    }

    public void setEditora(Map<String, Object> editora) {
        this.editora = editora;
    }
}
