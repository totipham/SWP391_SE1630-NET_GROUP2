/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * Sep 4, 2022         1.0           DucPTMHE160517     First Implement
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * The class contains method get connection and close connection 
 *
 * The method will throw an object of <code>java.lang.Exception</code> class if
 * there is any error
 * <p>
 * Bugs: Haven't found yet
 *
 * @author DucPTMHE160517
 */
public class DBContext {
    
    protected static Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            String url = "jdbc:sqlserver://localhost:1433;databaseName= Hostalpy";
            String username = "sa";
            String password = "123";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, username, password);
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
    protected void closeConnection (Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException {
        
        if (ps != null) {
            ps.close();
        }
        
        if (rs != null) {
            rs.close();
        }
        
        conn.close();
    }
}
