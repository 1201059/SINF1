package com.example.sinf1.model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author grupo2
 */

public class Viatura {
    private String tipoViatura, matricula, modelo;
    private Date data;
    private List<Marca> lstMarcas;
  
    public Viatura(String tipoViatura, String matricula, String modelo, Date data) {
        this.tipoViatura = tipoViatura;
        this.matricula = matricula;
        this.modelo = modelo;
        this.data = data;
    }

    public  Viatura(Viatura viatura){
        this.tipoViatura=viatura.tipoViatura;
        this.modelo=viatura.modelo;
        this.matricula=viatura.matricula;
        this.data=viatura.data;

    }

    public String getTipoViatura() {
        return tipoViatura;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public Date getData() {
        return data;
    }

    public List<Marca> getLstMarcas() {
        return lstMarcas;
    }

    public void setTipoViatura(String tipoViatura) {
        this.tipoViatura = tipoViatura;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setLstMarcas(List<Marca> lstMarcas) {
        this.lstMarcas = lstMarcas;
    }

    @Override
    public String toString() {
        return "Viatura{" + "tipoViatura=" + tipoViatura + ", matricula=" + matricula + ", modelo=" + modelo + ", data=" + data + ", lstMarcas=" + lstMarcas + '}';
    }
  
  
}
