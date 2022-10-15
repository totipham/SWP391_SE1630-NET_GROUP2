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
import dal.IPropertyImageDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.PropertyImage;

/**				
 * The class contains method find update, delete, insert property image to/from DB			
 * 				
 * The method will throw an object of <code>java.lang.Exception</code> class if 
 * there is any error occurring when finding, inserting, or updating data				
 * <p>Bugs: Haven't found yet				
 *				
 * @author DucPTMHE160517				
 */
public class PropertyImageDAOImpl extends DBContext implements IPropertyImageDAO {

    @Override
    public ArrayList<PropertyImage> getImagesByPID(int pid) throws SQLException{

        ArrayList<PropertyImage> list = new ArrayList<>();
        String sql = "SELECT * FROM [PropertyImage] WHERE property_id = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, pid);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                PropertyImage propertyImage = new PropertyImage();
                propertyImage.setPropertyId(pid);
                propertyImage.setFileName(rs.getString("filename"));

                list.add(propertyImage);
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            closeConnection(connection, statement, null);
        }

        return list;
    }
    
    @Override
    public void insertPropertyImage(PropertyImage propertyImage) throws SQLException{
        String sql = "INSERT INTO PropertyImage (property_id, filename) VALUES (?, ?)";
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, propertyImage.getPropertyId());
            statement.setString(2, propertyImage.getFileName());
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            closeConnection(connection, statement, null);
        }
    }

}
