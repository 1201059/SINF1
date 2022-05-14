package com.example.sinf1.model;

import java.util.Date;

/**
 *
 * @author grupo2
 */

public class Faturacao {
    int cod;
    Date data;
    int custo;
    int tempoEstacionado;
    String email;

    private static int codigo = 0;
    private static final String STR_DEFAULT = "";
    private static final int INT_DEFAULT = 0;

    public Faturacao() {
        this.cod = ++codigo;
        this.data = new Date();
        this.custo = INT_DEFAULT;
        this.tempoEstacionado = INT_DEFAULT;
        this.email = STR_DEFAULT;
    }

    public Faturacao(Date data, int custo, int tempoEstacionado, String email) {
        this.cod = ++codigo;
        this.data = data;
        this.custo = custo;
        this.tempoEstacionado = tempoEstacionado;
        this.email = email;
    }

    public Faturacao(Faturacao fat){
        this.cod = fat.cod;
        this.data=fat.data;
        this.custo=fat.custo;
        this.tempoEstacionado=fat.tempoEstacionado;
        this.email=fat.email;
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

    public int getTempoEstacionado() {
        return tempoEstacionado;
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

    public void setTempoEstacionado(int tempoEstacionado) {
        this.tempoEstacionado = tempoEstacionado;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Fatura\u00e7\u00e3o{" + "data=" + data + ", custo=" + custo + ", tempoEstacionado=" + tempoEstacionado + ", email=" + email + '}';
    }
}