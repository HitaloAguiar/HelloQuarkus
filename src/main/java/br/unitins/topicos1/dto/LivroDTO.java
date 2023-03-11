package br.unitins.topicos1.dto;

import java.time.LocalDate;

public class LivroDTO {
    
    private String titulo;
    private String isbn;
    private String genero;
    private LocalDate dataDeLancamento;
    private String nomeDoAutor;
    private Long ideditora;

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
    public Long getIdeditora() {
        return ideditora;
    }
    public void setIdeditora(Long ideditora) {
        this.ideditora = ideditora;
    }
}
