package com.example.sinf1.Model;

/**
 *
 * @author arabs
 */

public class Lugar {
    int numero;
    boolean ocupacao;
    int tempoSegundos;

    public Lugar(int numero, boolean ocupacao, int tempoSegundos) {
        this.numero = numero;
        this.ocupacao = ocupacao;
        this.tempoSegundos = tempoSegundos;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isOcupacao() {
        return ocupacao;
    }

    public int getTempoSegundos() {
        return tempoSegundos;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setOcupacao(boolean ocupacao) {
        this.ocupacao = ocupacao;
    }

    public void setTempoSegundos(int tempoSegundos) {
        this.tempoSegundos = tempoSegundos;
    }

    @Override
    public String toString() {
        return "Lugar{" + "numero=" + numero + ", ocupacao=" + ocupacao + ", tempoSegundos=" + tempoSegundos + '}';
    }
}