package net.endoedgar.dictionaryproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private final Connection con;
    
    public DbConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");  
        this.con = DriverManager.getConnection(
                "jdbc:mysql://localhost/entries?useSSL=false", 
                "root", 
                "123456");
    }
    
    public Connection getConnection() {
        return this.con;
    }
}
