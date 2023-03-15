package br.unitins.topicos1.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

public class LivroDTO {
    
    @NotBlank(message = "O titulo deve ser informado")
    private String titulo;

    @NotBlank
    @Size(min = 13, message = "A ISBN precisa conter 13 dígitos, considerando apenas números")
    private String isbn;

    private String genero;

    @PastOrPresent(message = "A data precisa estar no passado, não é possível que a data de lançamento esteja no futuro")
    private LocalDate dataDeLancamento;

    @NotBlank
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
