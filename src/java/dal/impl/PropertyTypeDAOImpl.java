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
import dal.IPropertyTypeDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.PropertyType;

/**
 * The class contains method find update, delete, insert property type to/from
 * DB
 *
 * The method will throw an object of <code>java.lang.Exception</code> class if
 * there is any error occurring when finding, inserting, or updating data
 * <p>
 * Bugs: Haven't found yet
 *
 * @author DucPTMHE160517
 */
public class PropertyTypeDAOImpl extends DBContext implements IPropertyTypeDAO {

    @Override
    public PropertyType getTypeByID(int id) throws SQLException {
        String sql = "SELECT * FROM [PropertyType] WHERE type_id=?";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            result = statement.executeQuery();

            if (result.next()) {
                PropertyType type = new PropertyType();
                type.setId(result.getInt("type_id"));
                type.setType(result.getString("ptype"));

                return type;
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            closeConnection(connection, statement, result);
        }

        return null;
    }

    @Override
    public void insertPropertyType(String newPropertyType) throws SQLException {
        String sql = "INSERT INTO PropertyType (ptype) VALUES (?)";
        PreparedStatement statement = null;
        Connection connection = getConnection();
        try {
            statement = connection.prepareStatement(sql);

            statement.setString(1, newPropertyType);
            statement.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(connection, statement, null);
        }
    }
}
