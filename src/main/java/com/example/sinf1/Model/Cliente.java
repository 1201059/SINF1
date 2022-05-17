package com.example.sinf1.model;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private List<Viatura> lstViatura;
    
    String nome, email, sobreNome, password;
    int nrFiscal;

    int veiculo, cod;

    private static int codigo = 0;

    public Cliente(String email, String password, int cod, int nrFiscal, int veiculo, String nome, String sobreNome) {
        this.email = email;
        this.password = password;
        this.cod = ++codigo;
        this.nrFiscal = nrFiscal;
        this.veiculo = veiculo;
        this.nome = nome;
        this.sobreNome = sobreNome;
    }

    public Cliente(String nome, String sobreNome, String email, String password, int nrFiscal) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.email = email;
        this.nrFiscal = nrFiscal;
        this.cod = ++codigo;
        this.lstViatura = new ArrayList<>();
        this.password = password;
    }

    public Cliente(Cliente cliente){
        this.cod = cliente.cod;
        this.nome = cliente.nome;
        this.sobreNome = cliente.sobreNome;
        this.email = cliente.email;
        this.nrFiscal = cliente.nrFiscal;
        this.lstViatura = cliente.lstViatura;
        this.password = cliente.password;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNrFiscal(int nrFiscal) {
        this.nrFiscal = nrFiscal;
    }

    public Cliente(List<Viatura> lstViatura) {
        this.lstViatura = lstViatura;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static void setCodigo(int codigo) {
        Cliente.codigo = codigo;
    }

    public int getCodigo(){
        return codigo;
    }

    public String getPassword() {
        return password;
    }

    public String getNome() {
        return nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public int getVeiculo() {
        return veiculo;
    }

    public String getEmail() {
        return email;
    }

    public int getNrFiscal() {
        return nrFiscal;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nome=" + nome + ", email=" + email + ", sobreNome=" + sobreNome + ", nrFiscal=" + nrFiscal + ", Viatura(s)=" + lstViatura + '}';
    }  
}