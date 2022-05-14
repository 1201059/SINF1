package com.example.sinf1.model;

import java.util.Date;

/**
 *
 * @author grupo2
 */

public class Faturacao {
    Date data;
    int custo;
    int tempoEstacionado;
    String email;

    public Faturacao(Date data, int custo, int tempoEstacionado, String email) {
        this.data = data;
        this.custo = custo;
        this.tempoEstacionado = tempoEstacionado;
        this.email = email;
    }

    public Faturacao(Faturacao fat){
        this.data=fat.data;
        this.custo=fat.custo;
        this.tempoEstacionado=fat.tempoEstacionado;
        this.email=fat.email;
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