package br.unitins.topicos1.model;

import java.time.LocalDate;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Livro extends PanacheEntity {
    
    private String titulo;
    private String genero;
    private String isbn;
    private LocalDate dataDeLancamento;
    private String nomeDoAutor;

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
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
}
