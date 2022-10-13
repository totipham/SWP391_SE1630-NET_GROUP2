package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        conn.close();
        
        if (ps != null) {
            ps.close();
        }
        
        if (rs != null) {
            rs.close();
        }
    }
}
