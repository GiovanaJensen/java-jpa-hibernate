package br.com.alura.modelo;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "informatica")
public class Informatica extends Produto{
    private String marca;
    private Integer modelo;

    public Informatica(){

    }

    public Informatica(String marca, Integer modelo){
        this.marca = marca;
        this.modelo = modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setModelo(Integer modelo) {
        this.modelo = modelo;
    }

    public Integer getModelo() {
        return this.modelo;
    }
}
