package java;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
        }catch(Exception e){ System.out.println(e) }
    }
    public static void insereViatura(Viatura v){
        try{
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Viatura (cod, matricula, modelo, dataDia, dataMes, dataAno) VALUES (?,?,?,?,?,?,?)");
            stmt.setInt(1, c.getCod());
            stmt.setString(2, c.getMatricula());
            stmt.setString(3, c.getModelo());
            stmt.setInt(4, c.getdataDia());
            stmt.setInt(5, c.getdataMes());
            stmt.setInt(6, c.getdataAno());
            stmt.setString(7, c.getViatura());
            stmt.executeUpdate();
            conn.close();
        }catch(Exception e){ System.out.println(e) }
    }
    public static void insereReserva(Reserva r){
        try{
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Reserva (dataDia, dataMes, dataAno, custo, tempo, email, cod) VALUES (?,?,?,?,?,?,?)");
            stmt.setInt(1, c.getdataDia());
            stmt.setInt(2, c.getdataMes());
            stmt.setInt(3, c.getdataAno());
            stmt.setInt(4, c.getCusto());
            stmt.setInt(5, c.getTempo());
            stmt.setString(6, c.getEmail());
            stmt.setint(7, c.getcod());
            stmt.executeUpdate();
            conn.close();
        }catch(Exception e){ System.out.println(e) }
    }
    public static void insereLugar(Lugar l){
        try{
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Lugar (numero, ocupacao, tempoEstacionamento, cod) VALUES (?,?,?,?,?,?,?)");
            stmt.setInt(1, c.getNumero());
            stmt.setInt(2, c.getOcupacao());
            stmt.setInt(3, c.gettempoEstacionamento());
            stmt.setInt(4, c.getCod());
            stmt.executeUpdate();
            conn.close();
        }catch(Exception e){ System.out.println(e) }
    }
    public static void insereFaturacao(Faturacao f){
        try{
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Faturacao (tempo, dataDia, dataMes, dataAno, custo, email, cod) VALUES (?,?,?,?,?,?,?)");
            stmt.setInt(1, c.getTempo());
            stmt.setInt(2, c.getdataDia());
            stmt.setInt(3, c.getdataMes());
            stmt.setInt(4, c.getdataAno());
            stmt.setInt(5, c.getCusto());
            stmt.setString(6, c.getEmail());
            stmt.setSInt(7, c.getCod());
            stmt.executeUpdate();
            conn.close();
        }catch(Exception e){ System.out.println(e) }
    }
    public static void insereGestor(Gestor g){
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
        }catch(Exception e){ System.out.println(e) }
    }
    public static void insereMarca(Marca m){
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
        }catch(Exception e){ System.out.println(e) }
    }
}