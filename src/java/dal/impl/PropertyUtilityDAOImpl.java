/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * Sep 28, 2022         1.0           DucPTMHE160517     First Implement
 */
package dal.impl;

import dal.DBContext;
import dal.IPropertyUtilityDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.PropertyUtility;

/**				
 * The class contains method find update, delete, insert property utility to/from DB			
 * 				
 * The method will throw an object  of <code>java.lang.Exception</code> class if 
 * there is any error occurring when finding, inserting, or updating data				
 * <p>Bugs: Haven't found yet				
 *				
 * @author DucPTMHE160517				
 */
public class PropertyUtilityDAOImpl extends DBContext implements IPropertyUtilityDAO {

    @Override
    public List<PropertyUtility> getUtilitiesByPID(int pid) throws SQLException{
        List<PropertyUtility> list = new ArrayList<>();
        String sql = "SELECT * FROM [Utility] WHERE property_id=?";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, pid);
            result = statement.executeQuery();

            //keep surf result while next result is can read
            while (result.next()) {
                PropertyUtility pu = new PropertyUtility();
                pu.setId(result.getInt("utility_id"));
                pu.setName(result.getString("name"));
                pu.setPrice(result.getDouble("price"));
                pu.setPid(result.getInt("property_id"));
                pu.setPeriod(result.getString("period"));
                list.add(pu);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeConnection(connection, statement, result);
        }
            
        return list;
    }
    
    @Override
    public void insertPropertyUtility(PropertyUtility propertyUtility) throws SQLException {
        String sql = "INSERT INTO Utility (property_id, name, price, period) "
                + "VALUES (?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, propertyUtility.getPid());
            statement.setString(2, propertyUtility.getName());
            statement.setDouble(3, propertyUtility.getPrice());
            statement.setString(4, propertyUtility.getPeriod());
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            closeConnection(connection, statement, null);
        }
    }

}
