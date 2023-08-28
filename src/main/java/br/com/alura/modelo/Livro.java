package br.com.alura.modelo;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "livros")
public class Livro extends Produto{
    private String autor;
    private Integer numeroDePaginas;

    public Livro(){

    }

    public Livro(String autor, Integer numeroDePaginas){
        this.autor = autor;
        this.numeroDePaginas = numeroDePaginas;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setNumeroDePaginas(Integer numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }

    public Integer getNumeroDePaginas() {
        return this.numeroDePaginas;
    }
}
