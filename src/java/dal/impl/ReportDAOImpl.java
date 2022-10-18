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
import java.sql.SQLException;

/**				
 * The class contains method find update, delete, insert staff information from				
 * Staff table in database. In the update or insert method, all data will be normalized (trim space) before update/insert into database				
 * The method wil throw an object  of <code>java.lang.Exception</code> class if there is any error occurring when finding, inserting, or updating data				
 * <p>Bugs: Haven't found yet				
 *				
 * @author LanBTHHE160676				
 */
public class ReportDAOImpl extends DBContext implements IReportDAO{

    @Override
    public void insertReport(int reportTypeId, int currentUserId,  int targetId, String target, Date reportDate, String header, String content) throws SQLException{
        String sql = "INSERT INTO Report (rtype_id, sender_id, target_id, target, time, header, content) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);

            statement.setInt(1, reportTypeId);
            statement.setInt(2, currentUserId);
            statement.setInt(3, targetId);
            statement.setString(4, target);
            statement.setDate(5, reportDate);
            statement.setString(6, header);
            statement.setString(7, content);
            statement.executeUpdate();

        } catch (SQLException e) {
           throw e;
        }finally {
            closeConnection(connection, statement, null);
        }
    }

}
