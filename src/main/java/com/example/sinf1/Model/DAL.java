package com.example.sinf1.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

/**
 *
 * @author grupo2
 */

public class DAL {
    public static void insereCliente(Cliente c){
        try{
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Cliente (email, password, cod, numFiscal, viaturas, nome, sobreNome) VALUES (?,?,?,?,?,?,?)");
            stmt.setString(1, c.getEmail());
            stmt.setString(2, c.getPassword());
            stmt.setInt(3, c.getCodigo());
            stmt.setInt(4, c.getNrFiscal());
            stmt.setInt(5, c.getVeiculo());
            stmt.setString(6, c.getNome());
            stmt.setString(7, c.getSobreNome());
            stmt.executeUpdate();
            conn.close();
        }catch(Exception e){ System.out.println(e); }
    }

    public static void insereViatura(Viatura v){
        try{
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Viatura (cod, matricula, modelo, data) VALUES (?,?,?,?,?)");
            stmt.setInt(1, v.getCodigo());
            stmt.setString(2, v.getMatricula());
            stmt.setString(3, v.getModelo());
            stmt.setDate(4, (Date) v.getData());
            stmt.executeUpdate();
            conn.close();
        }catch(Exception e){ System.out.println(e); }
    }

    public static void insereReserva(Reserva r){
        try{
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Reserva (dataDia, dataMes, dataAno, custo, tempo, email, cod) VALUES (?,?,?,?,?,?,?)");
            stmt.setDate(4, (Date) r.getData());
            stmt.setInt(4, r.getCusto());
            stmt.setInt(5, r.getTempo());
            stmt.setString(6, r.getEmail());
            stmt.setInt(7, r.getCodigo());
            stmt.executeUpdate();
            conn.close();
        }catch(Exception e){ System.out.println(e); }
    }

    public static void insereLugar(Lugar l){
        try{
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Lugar (numero, ocupacao, tempoEstacionamento) VALUES (?,?,?,?,?,?,?)");
            stmt.setInt(1, l.getNumero());
            stmt.setString(2, Boolean.toString(l.isOcupacao()));
            stmt.setInt(3, l.getTempoSegundos());
            stmt.executeUpdate();
            conn.close();
        }catch(Exception e){ System.out.println(e); }
    }

    public static void insereFaturacao(Faturacao f){
        try{
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Faturacao (tempo, dataDia, custo, email, cod) VALUES (?,?,?,?,?)");
            stmt.setInt(1, f.getTempoEstacionado());
            stmt.setDate(2, (Date) f.getData());
            stmt.setInt(3, f.getCusto());
            stmt.setString(4, f.getEmail());
            stmt.setInt(5, f.getCodigo());
            stmt.executeUpdate();
            conn.close();
        }catch(Exception e){ System.out.println(e); }
    }

    public static void insereGestor(Gestor g){
        try{
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Gestor (email, password, cod) VALUES (?,?,?)");
            stmt.setString(1, g.getEmail());
            stmt.setString(2, g.getPassword());
            stmt.setInt(3, g.getCodigo());
            stmt.executeUpdate();
            conn.close();
        }catch(Exception e){ System.out.println(e); }
    }

    public static void insereMarca(Marca m){
        try{
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Marca (nome) VALUES (?)");
            stmt.setString(1, m.getNome());
            stmt.executeUpdate();
            conn.close();
        }catch(Exception e){ System.out.println(e); }
    }
}