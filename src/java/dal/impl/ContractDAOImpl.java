/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * Oct 20, 2022         1.0           LanBTHHE160676     First Implement
 */

 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.impl;

import dal.DBContext;
import dal.IContractDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * The class contains method find update, delete, insert staff information from
 * Staff table in database. In the update or insert method, all data will be
 * normalized (trim space) before update/insert into database The method wil
 * throw an object of <code>java.lang.Exception</code> class if there is any
 * error occurring when finding, inserting, or updating data
 * <p>
 * Bugs: Haven't found yet
 *
 * @author LanBTHHE160676
 */
public class ContractDAOImpl extends DBContext implements IContractDAO {

    /**
     *
     * @param propertyId
     * @param userId
     * @param beginDate
     * @throws Exception
     */
    @Override
    public void insertContract(int propertyId, int userId, Date beginDate) throws Exception {
        String sql = "INSERT INTO Contract (property_id ,user_id ,begin_date, cstatus_id) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = null;
        Connection connection = getConnection();
        try {
            statement = connection.prepareStatement(sql);

            statement.setInt(1, propertyId);
            statement.setInt(2, userId);
            statement.setDate(3, beginDate);
            statement.setInt(4, 1);
            statement.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(connection, statement, null);
        }
    }

    /**
     *
     * @param hostId
     * @param begin
     * @param end
     * @return
     * @throws Exception
     */
    public int getNumberOfContractInRange(int hostId, Date begin, Date end) throws Exception {
        String sql = "SELECT COUNT(*) as number \n"
                + "FROM [Contract] c\n"
                + "INNER JOIN Property p\n"
                + "ON c.property_id = p.property_id\n"
                + "WHERE begin_date BETWEEN ? AND ?\n"
                + "AND p.host_id = ?";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, begin.toString());
            statement.setString(2, end.toString());
            statement.setInt(3, hostId);
            
            result = statement.executeQuery();
            
            if (result.next()) {
                return result.getInt("number");
            }
            
            return -1;
            
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeConnection(connection, statement, result);
        }
    }

}