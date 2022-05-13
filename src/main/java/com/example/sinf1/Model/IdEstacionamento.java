package com.example.sinf1.Model;

/**
 *
 * @author arabs
 */

public class IdEstacionamento {
    int totalLugaresNormais, totalLugaresEspeciais;

    public IdEstacionamento(int totalLugaresNormais, int totalLugaresEspeciais) {
        this.totalLugaresNormais = 35;
        this.totalLugaresEspeciais = 2;
    }

    public int getTotalLugaresNormais() {
        return totalLugaresNormais;
    }

    public int getTotalLugaresEspeciais() {
        return totalLugaresEspeciais;
    }

    @Override
    public String toString() {
        return "IdEstacionamento{" + "totalLugaresNormais=" + totalLugaresNormais + ", totalLugaresEspeciais=" + totalLugaresEspeciais + '}';
    }    
}