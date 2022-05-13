package java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    //LOCAL: "jdbc:mysql://localhost:3306/gestao";
    static final String URL = "jdbc:mysql://ctesp.dei.isep.ipp.pt:3306/2022sinf1_010"; 
    static final String USER = "2022sinf1_010";
    static final String PASS = "Ps23967oUE.";

    public static Connection getConnection(){
        try{
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Connection to " + conn.getCatalog() + " succeded!");
            return conn;
        } catch(SQLException exc) {
            throw new RuntimeException("Error connecting!", exc);
        }
    }

}
