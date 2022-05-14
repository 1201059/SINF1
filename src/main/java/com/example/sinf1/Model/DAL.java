package com.example.sinf1.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.example.sinf1.model.Gestor;
import com.example.sinf1.model.Marca;
import com.example.sinf1.model.Reserva;

/**
 *
 * @author grupo2
 */

public class DAL {
    public DAL(){}
    
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
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Viatura (cod, matricula, modelo, dataDia, dataMes, dataAno) VALUES (?,?,?,?,?,?,?)");
            stmt.setInt(1, v.getCod());
            stmt.setString(2, v.getMatricula());
            stmt.setString(3, v.getModelo());
            stmt.setInt(4, v.getdataDia());
            stmt.setInt(5, v.getdataMes());
            stmt.setInt(6, v.getdataAno());
            stmt.setString(7, v.getViatura());
            stmt.executeUpdate();
            conn.close();
        }catch(Exception e){ System.out.println(e); }
    }

    public static void insereReserva(Reserva r){
        try{
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Reserva (dataDia, dataMes, dataAno, custo, tempo, email, cod) VALUES (?,?,?,?,?,?,?)");
            stmt.setInt(1, r.getdataDia());
            stmt.setInt(2, r.getdataMes());
            stmt.setInt(3, r.getdataAno());
            stmt.setInt(4, r.getCusto());
            stmt.setInt(5, r.getTempo());
            stmt.setString(6, r.getEmail());
            stmt.setint(7, r.getcod());
            stmt.executeUpdate();
            conn.close();
        }catch(Exception e){ System.out.println(e); }
    }

    public static void insereLugar(Lugar l){
        try{
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Lugar (numero, ocupacao, tempoEstacionamento, cod) VALUES (?,?,?,?,?,?,?)");
            stmt.setInt(1, l.getNumero());
            stmt.setInt(2, l.getOcupacao());
            stmt.setInt(3, l.gettempoEstacionamento());
            stmt.setInt(4, l.getCod());
            stmt.executeUpdate();
            conn.close();
        }catch(Exception e){ System.out.println(e); }
    }

    public static void insereFaturacao(Faturacao f){
        try{
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Faturacao (tempo, dataDia, dataMes, dataAno, custo, email, cod) VALUES (?,?,?,?,?,?,?)");
            stmt.setInt(1, f.getTempo());
            stmt.setInt(2, f.getdataDia());
            stmt.setInt(3, f.getdataMes());
            stmt.setInt(4, f.getdataAno());
            stmt.setInt(5, f.getCusto());
            stmt.setString(6, f.getEmail());
            stmt.setSInt(7, f.getCod());
            stmt.executeUpdate();
            conn.close();
        }catch(Exception e){ System.out.println(e); }
    }

    public static void insereGestor(Gestor g){
        try{
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Cliente (email, password, cod, numFiscal, viaturas, nome, sobreNome) VALUES (?,?,?,?,?,?,?)");
            stmt.setString(1, g.getEmail());
            stmt.setString(2, g.getPassword());
            stmt.setInt(3, g.getCodigo());
            stmt.setInt(4, g.getNrFiscal());
            stmt.setInt(5, g.getVeiculo());
            stmt.setString(6, g.getNome());
            stmt.setString(7, g.getSobreNome());
            stmt.executeUpdate();
            conn.close();
        }catch(Exception e){ System.out.println(e); }
    }

    public static void insereMarca(Marca m){
        try{
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Cliente (email, password, cod, numFiscal, viaturas, nome, sobreNome) VALUES (?,?,?,?,?,?,?)");
            stmt.setString(1, m.getEmail());
            stmt.setString(2, m.getPassword());
            stmt.setInt(3, m.getCodigo());
            stmt.setInt(4, m.getNrFiscal());
            stmt.setInt(5, m.getVeiculo());
            stmt.setString(6, c.getNome());
            stmt.setString(7, c.getSobreNome());
            stmt.executeUpdate();
            conn.close();
        }catch(Exception e){ System.out.println(e); }
    }
}