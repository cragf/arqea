package com.robert.arqea.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final ConnectionDB instancia = new ConnectionDB();
    private static final String url = "jdbc:mariadb://localhost:3306/arqeadb";
    private static final String user = "root";
    private static final String pass = "descartes";

    private ConnectionDB(){}
    
    public static ConnectionDB Getconexion(){
        return instancia;
    }
    
    public Connection Conectar() throws SQLException {
        return DriverManager.getConnection(url,user,pass);
    }
}
