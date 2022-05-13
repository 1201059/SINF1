package com.example.sinf1.Model;

public class Gestor {
    int cod;
    String email, password;
    private static int codigo = 0;

    public Gestor(int codigo, String email, String password) {
        this.cod = ++ codigo;
        this.email = email;
        this.password = password;
    }

    public Gestor(Gestor gest){
        this.cod=gest.cod;
        this.email=gest.email;
        this.password=gest.password;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "gestor{" + "codigo=" + codigo + ", email=" + email + ", password=" + password + '}';
    }
        
}
