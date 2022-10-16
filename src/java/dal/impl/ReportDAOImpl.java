/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * Oct 15, 2022         1.0           LanBTHHE160676     First Implement
 */

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dal.impl;

import dal.DBContext;
import dal.IReportDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

/**				
 * The class contains method find update, delete, insert staff information from				
 * Staff table in database. In the update or insert method, all data will be normalized (trim space) before update/insert into database				
 * The method wil throw an object  of <code>java.lang.Exception</code> class if there is any error occurring when finding, inserting, or updating data				
 * <p>Bugs: Haven't found yet				
 *				
 * @author LanBTHHE160676				
 */
public class ReportDAOImpl extends DBContext implements IReportDAO{

    /**
     *
     * @param senderId
     * @param reportUserId
     * @param reportDate
     * @param header
     * @param content
     * @throws Exception
     */
    @Override
    public void insertReportUser(int senderId, int reportUserId, Date reportDate, String header, String content) throws Exception {
        String sql = "INSERT INTO Report (sender_id ,report_user_id ,time, header, content) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = null;
        Connection connection = getConnection();
        try {
            statement = connection.prepareStatement(sql);

            statement.setInt(1, senderId);
            statement.setInt(2, reportUserId);
            statement.setDate(3, reportDate);
            statement.setString(4, header);
            statement.setString(5, content);
            statement.executeUpdate();

        } catch (Exception e) {
           throw e;
        }finally {
            closeConnection(connection, statement, null);
        }
    }

    /**
     *
     * @param senderId
     * @param reportPropertyId
     * @param reportDate
     * @param header
     * @param content
     * @throws Exception
     */
    @Override
    public void insertReportProperty(int senderId, int reportPropertyId, Date reportDate, String header, String content) throws Exception {
        String sql = "INSERT INTO Report (sender_id ,report_property_id ,time, header, content) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = null;
        Connection connection = getConnection();
        try {
            statement = connection.prepareStatement(sql);

            statement.setInt(1, senderId);
            statement.setInt(2, reportPropertyId);
            statement.setDate(3, reportDate);
            statement.setString(4, header);
            statement.setString(5, content);
            statement.executeUpdate();

        } catch (Exception e) {
           throw e;
        }finally {
            closeConnection(connection, statement, null);
        }
    }

}
