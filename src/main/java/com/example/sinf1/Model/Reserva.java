package com.example.sinf1.model;

import java.util.Date;

/**
 *
 * @author arabs
 */

public class Reserva {
    int cod;
    Date data;
    int custo;
    int tempo;
    String email;

    private static int codigo = 0;
    private static final String STR_DEFAULT = "";
    private static final int INT_DEFAULT = 0;

    public Reserva() {
        this.cod = ++codigo;
        this.data = new Date();
        this.custo = INT_DEFAULT;
        this.tempo = INT_DEFAULT;
        this.email = STR_DEFAULT;
    }

    public Reserva(int cod, Date data, int custo, int tempo, String email) {
        this.cod = ++codigo;
        this.data = data;
        this.custo = custo;
        this.tempo = tempo;
        this.email = email;
    }

    public int getCodigo() {
        return cod;
    }

    public Date getData() {
        return data;
    }

    public int getCusto() {
        return custo;
    }

    public int getTempo() {
        return tempo;
    }

    public String getEmail() {
        return email;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setCusto(int custo) {
        this.custo = custo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Reserva{" + "data=" + data + ", custo=" + custo + ", tempo=" + tempo + ", email=" + email + '}';
    }  
}