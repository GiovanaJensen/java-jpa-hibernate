package br.com.alura.modelo;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CategoriaId implements Serializable {
    private String nome;
    private String tipo;

    public CategoriaId(){

    }

    public CategoriaId(String nome, String tipo){
        this.nome = nome;
        this.tipo = tipo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return this.tipo;
    }

}
