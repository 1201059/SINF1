package com.example.sinf1.model;

import static com.example.sinf1.model.DBConnection.getConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author grupo2
 */

public class DAL {

    private String cliente = "cliente";
    private String viatura = "viatura";
    private String reserva = "reserva";
    private String lugar = "lugar";
    private String faturacao = "faturacao";
    private String gestor = "gestor";

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

    public  void addCliente (String email, String password, int cod, int nrFiscal, int veiculo , String nome, String sobreNome) throws SQLException{
        Connection conn = DBConnection.getConnection();
        Statement statement = conn.createStatement();
        statement.executeUpdate("Inserir informação" + cliente + "(email, password, cod, nrFiscal, veiculo, nome, sobreNome) VALUES ("+email+","+password+","+cod+","+nrFiscal+","+veiculo+","+nome+","+sobreNome+");");
        System.out.println("Adicionado com sucesso:" + email);
    } 

    public ResultSet getCliente() throws SQLException{
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("selecione * from" + cliente + ";");
        return rs;
    } 

    public void deleteCliente(int cod) throws SQLException {
        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        statement.executeUpdate("Eliminar " + cliente + " com o seguinte código =" + cod + ";");
        System.out.println("Eliminado com sucesso!");
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

    public  void addViatura (int cod, String matricula, String tipoViatura, String modelo, Date data) throws SQLException{
        Connection conn = DBConnection.getConnection();
        Statement statement = conn.createStatement();
        statement.executeUpdate("Inserir informação" + viatura + "(codigo, tipo de viatura, matricula, modelo, data) VALUES ("+cod+","+tipoViatura+","+matricula+","+modelo+","+data+");");
        System.out.println("Adicionado com sucesso:" + matricula);
    } 

    public ResultSet getViatura() throws SQLException{
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("selecione * from" + viatura + ";");
        return rs;
    } 

    public void deleteViatura(int cod) throws SQLException {
        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        statement.executeUpdate("Eliminar " + viatura + " com o seguinte código =" + cod + ";");
        System.out.println("Eliminado com sucesso!");
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

    public  void addReserva (int cod, Date data, int custo, int tempo, String email) throws SQLException{
        Connection conn = DBConnection.getConnection();
        Statement statement = conn.createStatement();
        statement.executeUpdate("Inserir informação" + reserva + "(codigo, data, custo, tempo, email) VALUES ("+cod+","+data+","+custo+","+tempo+","+email+");");
        System.out.println("Adicionado com sucesso:" + reserva);
    } 

    public ResultSet getReserva() throws SQLException{
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("selecione * from" + reserva + ";");
        return rs;
    } 

    public void deleteReserva(int cod) throws SQLException {
        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        statement.executeUpdate("Eliminar " + reserva + " com o seguinte código =" + cod + ";");
        System.out.println("Eliminado com sucesso!");
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

    public  void addLugar (int numero, boolean ocupacao, int tempoSegundos) throws SQLException{
        Connection conn = DBConnection.getConnection();
        Statement statement = conn.createStatement();
        statement.executeUpdate("Inserir informação" + lugar + "(numero, ocupacao,tempo) VALUES ("+numero+","+ocupacao+","+tempoSegundos+");");
        System.out.println("Adicionado com sucesso:" + lugar);
    } 

    public ResultSet getLugar() throws SQLException{
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("selecione * from" + lugar + ";");
        return rs;
    } 

    public void deleteLugar (int numero) throws SQLException {
        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        statement.executeUpdate("Eliminar " + lugar + " com o seguinte código =" + numero + ";");
        System.out.println("Eliminado com sucesso!");
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

    public  void addFaturacao (int cod, Date data, int custo, int tempoEstacionado, String email) throws SQLException{
        Connection conn = DBConnection.getConnection();
        Statement statement = conn.createStatement();
        statement.executeUpdate("Inserir informação" + faturacao + "(codigo, data, custo, tempoEstacionado, email) VALUES ("+cod+","+data+","+custo+","+tempoEstacionado+","+email+");");
        System.out.println("Adicionado com sucesso:" + faturacao);
    } 

    public ResultSet getFaturacao() throws SQLException{
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("selecione * from" + faturacao + ";");
        return rs;
    } 

    public void deleteFaturacao (int cod) throws SQLException {
        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        statement.executeUpdate("Eliminar " + faturacao + " com o seguinte código =" + cod + ";");
        System.out.println("Eliminado com sucesso!");
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

    public  void addGestor (int cod, String email, String password) throws SQLException{
        Connection conn = DBConnection.getConnection();
        Statement statement = conn.createStatement();
        statement.executeUpdate("Inserir informação" + gestor + "(codigo, email, password) VALUES ("+cod+","+email+","+password+");");
        System.out.println("Adicionado com sucesso:" + gestor);
    } 

    public ResultSet getGestor() throws SQLException{
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("selecione * from" + gestor + ";");
        return rs;
    } 

    public void deleteGestor (int cod) throws SQLException {
        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        statement.executeUpdate("Eliminar " + gestor + " com o seguinte código =" + cod + ";");
        System.out.println("Eliminado com sucesso!");
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