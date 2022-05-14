package com.example.sinf1.model;

/**
 *
 * @author grupo2
 */

public class Marca {
    public String nome;

    public Marca(String nome) {
        this.nome = nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Marca{" + "nome=" + nome + '}';
    }   
}